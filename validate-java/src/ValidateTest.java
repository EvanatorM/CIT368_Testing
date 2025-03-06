package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValidateTest {
    @Test
    void testZip() {
        // Happy Path
        assertTrue(Validate.zip("53524"));
        assertFalse(Validate.zip("2342"));
        assertFalse(Validate.zip("573829"));

        // Abuse
        try {
            File blnsFile = new File("blns.payloads");
            Scanner blnsReader = new Scanner(blnsFile);
            while (blnsReader.hasNextLine()) {
                String data = blnsReader.nextLine();
                System.out.println("Current Test: " + data);
                assertFalse(Validate.zip(data));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    @Test
    void testMinor() {
        assertTrue(Validate.minor(15));
        assertFalse(Validate.minor(18));
        assertTrue(Validate.minor(17));
        assertFalse(Validate.minor(18));
        assertFalse(Validate.minor(18452));
        assertTrue(Validate.minor(0));
    }

    @Test
    void testEmail() {
        // Happy Path
        assertTrue(Validate.email("test@example.com"));

        // Abuse
        try {
            File blnsFile = new File("blns.payloads");
            Scanner blnsReader = new Scanner(blnsFile);
            while (blnsReader.hasNextLine()) {
                String data = blnsReader.nextLine();
                System.out.println("Current Test: " + data);
                assertFalse(Validate.email(data));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    @Test
    void testIsLat() {
        assertTrue(Validate.isLat(23.12));
        assertFalse(Validate.isLat(23453.12));
    }

    @Test
    void testIsLng() {
        assertTrue(Validate.isLat(23.12));
        assertFalse(Validate.isLat(23453.12));
    }

    @Test
    void testIsDomain() {
        // Happy Path
        assertTrue(Validate.isDomain("example.com"));

        // Abuse
        try {
            File blnsFile = new File("blns.payloads");
            Scanner blnsReader = new Scanner(blnsFile);
            while (blnsReader.hasNextLine()) {
                String data = blnsReader.nextLine();
                System.out.println("Current Test: " + data);
                assertFalse(Validate.isDomain(data));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    @Test
    void testIsInDomain() {
        assertTrue(Validate.isInDomain("example.com", "test.example.com"));
        assertFalse(Validate.isInDomain("example.com", "test.fes.com"));

        // Abuse
        try {
            File blnsFile = new File("blns.payloads");
            Scanner blnsReader = new Scanner(blnsFile);
            while (blnsReader.hasNextLine()) {
                String data = blnsReader.nextLine();
                System.out.println("Current Test: " + data);
                assertFalse(Validate.isInDomain("example.com", data));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    @Test
    void testIsUrl() {
        assertTrue(Validate.isUrl("https://www.example.com"));

        // Abuse
        try {
            File blnsFile = new File("blns.payloads");
            Scanner blnsReader = new Scanner(blnsFile);
            while (blnsReader.hasNextLine()) {
                String data = blnsReader.nextLine();
                System.out.println("Current Test: " + data);
                assertFalse(Validate.isUrl(data));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    @Test
    void testGrade() {
        assertEquals('A', Validate.grade(90.0));
        assertEquals('A', Validate.grade(124.0));
        assertEquals('F', Validate.grade(0.0));
    }

    @Test
    void testIp() {
        assertTrue(Validate.ip("10.0.0.1"));

        // Abuse
        try {
            File blnsFile = new File("blns.payloads");
            Scanner blnsReader = new Scanner(blnsFile);
            while (blnsReader.hasNextLine()) {
                String data = blnsReader.nextLine();
                System.out.println("Current Test: " + data);
                assertFalse(Validate.ip(data));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    @Test
    void testMac() {
        assertTrue(Validate.mac("00-B3-A8-00-64-C2"));

        // Abuse
        try {
            File blnsFile = new File("blns.payloads");
            Scanner blnsReader = new Scanner(blnsFile);
            while (blnsReader.hasNextLine()) {
                String data = blnsReader.nextLine();
                System.out.println("Current Test: " + data);
                assertFalse(Validate.mac(data));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }

    @Test
    void testMd5() {
        assertTrue(Validate.md5("79054025255fb1a26e4bc422aef54eb4"));

        // Abuse
        try {
            File blnsFile = new File("blns.payloads");
            Scanner blnsReader = new Scanner(blnsFile);
            while (blnsReader.hasNextLine()) {
                String data = blnsReader.nextLine();
                System.out.println("Current Test: " + data);
                assertFalse(Validate.md5(data));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

    }
}
