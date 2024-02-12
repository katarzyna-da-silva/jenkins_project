HOST = os.environ.get('HOST', 'localhost')

import datetime
x = datetime.datetime.now()
print("It's a beautiful day today : " + x.strftime("%Y-%m-%d %A"))

def hello(fname):
    print("Hello, " + fname + "! How are you today?")

hello("Katarzyna")
hello("Tom")
hello("Theo")