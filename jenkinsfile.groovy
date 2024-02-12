pipeline {
    agent any                    // connect avec jenkins
    environment {                // variables
        PYTHON_VERSION = '3.8'  // version python
        VENV_NAME = 'katarzyna_venv'      // name env
        HOST = 'localhost'
    }

    stages {                  // code section
        stage('Build') {               // preparation env.
            steps {          
                sh "sudo apt-get update && sudo apt-get install -y  python${PYTHON_VERSION} python${PYTHON_VERSION}-dev python3-pip"          //  install python
                sh "pip3 install virtualenv"                                                                                        // install environment 
                sh "virtualenv -p = python${PYTHON_VERSION} python${VENV_NAME}"                                                       // install version & name env
                sh "source ${VENV_NAME}/bin/activate"                                                                                // active env
                sh "pip install -r requirements.txt"                                                                                // ajouter le reste des dépendances
            }
        }

        stage('Test') {              // build test units py 
            steps {
                sh "source ${VENV_NAME}/bin/activate"
                sh "python -m unittest discover -s tests -p '*_test.py'"         // test_unit test_hello_devops.py -m module -p fichier pour test
            }
        }
        stage('Deploy') {   // build & deploy
            steps {
                sh "python hello_devops.py"
                sh 'echo "Deploy completed successfully" >> deploy_log.txt'    
                sh "python -m http.server --bind ${HOST} 8000"}
        }
    }
}