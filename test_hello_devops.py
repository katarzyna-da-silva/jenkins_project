import unittest

from hello_devops import hello

class TestHelloFunc (unittest.TestCase):
    def test_name(self):
        self.assertEqual(hello("Katarzyna"), "Hello, Katarzyna! How are you today?")
        self.assertEqual(hello("Tom"), "Hello, Katarzyna! How are you today?")
        self.assertEqual(hello("Theo"), "Hello, Katarzyna! How are you today?")

if __name__ == '__main__':
    unittest.main()