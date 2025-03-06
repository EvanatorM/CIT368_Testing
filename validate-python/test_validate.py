from validate import Validate    # The code to test
import unittest   # The test framework

class Test_TestValidate(unittest.TestCase):
    def test_zip_happy(self):
        #HAPPY PATH
        self.assertTrue(Validate.zip("17701"))

    def test_zip_bad(self):
        #ABUSE
        f = open("blns.payloads", "rb")

        for line in f:
            print(f"Attempting {line}")
            self.assertFalse(Validate.zip(str(line)))

    def test_minor_happy(self):
        self.assertTrue(Validate.minor(15))
        self.assertFalse(Validate.minor(18))

    def test_minor_bad(self):
        #ABUSE
        self.assertTrue(Validate.minor(17))
        self.assertTrue(Validate.minor(0))
        self.assertFalse(Validate.minor(18))
        self.assertFalse(Validate.minor(100))
        self.assertFalse(Validate.minor(';'))
        f = open("blns.payloads", "rb")

    def test_email_happy(self):
        self.assertTrue(Validate.email("test@example.com"))

    def test_email_bad(self):
        #ABUSE
        f = open("blns.payloads", "rb")

        for line in f:
            print(f"Attempting {line}")
            self.assertFalse(Validate.email(str(line)))

    def test_lat_happy(self):
        self.assertTrue(Validate.is_lat(32.23))

    def test_lat_bad(self):
        self.assertTrue(Validate.is_lat(-89.32))
        self.assertTrue(Validate.is_lat(3))
        self.assertFalse(Validate.is_lat("hello"))
        self.assertFalse(Validate.is_lat(234))
        self.assertFalse(Validate.is_lat(-91))

    def test_lng_happy(self):
        self.assertTrue(Validate.is_lng(-14.32))

    def test_lng_bad(self):
        self.assertTrue(Validate.is_lng(-180))
        self.assertTrue(Validate.is_lng(3))
        self.assertFalse(Validate.is_lng("hello"))
        self.assertFalse(Validate.is_lng(234))
        self.assertFalse(Validate.is_lng(-181))

    def test_domain_happy(self):
        self.assertTrue(Validate.is_domain("example.com"))

    def test_domain_bad(self):
        #ABUSE
        f = open("blns.payloads", "rb")

        for line in f:
            print(f"Attempting {line}")
            self.assertFalse(Validate.is_domain(str(line)))

    def test_url_happy(self):
        self.assertTrue(Validate.is_url("https://www.example.com"))

    def test_url_bad(self):
        #ABUSE
        f = open("blns.payloads", "rb")

        for line in f:
            print(f"Attempting {line}")
            self.assertFalse(Validate.is_url(str(line)))

    def test_grade_happy(self):
        self.assertEqual("A", Validate.grade(90))

    def test_grade_bad(self):
        self.assertEqual("A", Validate.grade(124))
        self.assertEqual("F", Validate.grade(0))
        self.assertEqual("Not a grade", Validate.grade('ahsdif'))

    def test_ip_happy(self):
        self.assertTrue(Validate.ip("10.0.0.1"))

    def test_ip_bad(self):
        #ABUSE
        f = open("blns.payloads", "rb")

        for line in f:
            print(f"Attempting {line}")
            self.assertFalse(Validate.ip(str(line)))

    def test_mac_happy(self):
        self.assertTrue(Validate.mac("00-B3-A8-00-64-C2"))

    def test_mac_bad(self):
        #ABUSE
        f = open("blns.payloads", "rb")

        for line in f:
            print(f"Attempting {line}")
            self.assertFalse(Validate.mac(str(line)))

    def test_md5_happy(self):
        self.assertTrue(Validate.md5("79054025255fb1a26e4bc422aef54eb4"))

    def test_md5_bad(self):
        #ABUSE
        f = open("blns.payloads", "rb")

        for line in f:
            print(f"Attempting {line}")
            self.assertFalse(Validate.md5(str(line)))

if __name__ == '__main__':
    unittest.main()
