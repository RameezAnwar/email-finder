
import java.io.*;

// Specify the filename
import static edu.depaul.email.StorageService.StorageType.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import edu.depaul.email.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class storageserviceTest {
    @Test
    @DisplayName("storage test email.txt")
    void storagetest1() {
        StorageService tester = new StorageService();

        tester.addLocation(StorageService.StorageType.EMAIL,"email.txt " );
        List<String> list = Arrays.asList("wow@gmail.coo", "c@wow.com", "dino@jurassic.com");
        tester.storeList(StorageService.StorageType.EMAIL, list);
        try {

            BufferedReader reader = new BufferedReader(new FileReader("email.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            assertEquals(3, lines);

        } catch (Exception e) {
            System.out.println("doesn't work");

        }
    }

    @Test
    @DisplayName("storage test badlinks.txt")
    void storagetest2() {
        StorageService tester = new StorageService();

        tester.addLocation(BADLINKS,"badlinks.txt " );
        List<String> list = Arrays.asList("c:/wefw", "notrel/ee/c:/", "d:/acf", "uwu");
        tester.storeList(BADLINKS, list);
        try {

            BufferedReader reader = new BufferedReader(new FileReader("badlinks.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            assertEquals(4, lines);

        } catch (Exception e) {
            System.out.println("doesn't work");

        }
    }


    @Test
    @DisplayName("storage test good-links.txt")
    void storagetest3() {
        StorageService tester = new StorageService();

        tester.addLocation(GOODLINKS,"good-links.txt " );
        List<String> list = Arrays.asList("c:/wefw", "notrel/ee/c:/", "d:/acf", "uwu", "opopop");
        tester.storeList(GOODLINKS, list);
        try {

            BufferedReader reader = new BufferedReader(new FileReader("good-links.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            assertEquals(5, lines);

        } catch (Exception e) {
            System.out.println("doesn't work");

        }
    }

    @Test
    @DisplayName("storage test bad link/path")
    void storagetest4() {
        StorageService tester = new StorageService();

        tester.addLocation(GOODLINKS,"src/test/java/resources/owo.txt " );
        List<String> list = Arrays.asList("c:/wefw", "notrel/ee/c:/", "d:/acf", "uwu", "opopop");

        try {
            tester.storeList(GOODLINKS, list);
        } catch (Exception e) {
            System.out.println("doesn't work");
            assertThrows(EmailFinderException.class, () -> tester.storeList(GOODLINKS, list));

        }
    }


}
