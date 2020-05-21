
import java.io.BufferedReader;
import java.io.File;  // Import the File class

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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.stream.Stream;




public class emailTest {


    @Test
    @DisplayName("email finder good link get email")
    void testemailfinder1() {
        EmailFinder b = new EmailFinder();
        String[] c = {"src/test/resources/tester.txt"};
        b.run(c);
        //File file = new File("badlinks.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("good-links.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            assertEquals(1, lines);

        } catch (Exception e)
        { System.out.println("doesn't work");}


        //Document doc = new PageFetcher().get(System.getProperty("user.dir") + "/src/email.txt");

    }

    @Test
    @DisplayName("email finder bad link/file path")
    void testemailfinder2() {
        EmailFinder b = new EmailFinder();
        String[] c = {"src/test/resources/badlinker.txt" };
        b.run(c);

        try {

            BufferedReader reader = new BufferedReader(new FileReader("badlinks.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            //assertEquals(1, lines);

        } catch (Exception e) {
            System.out.println("doesn't work");
            assertThrows(EmailFinderException.class, () -> b.run(c));

        }
    }

    @Test
    @DisplayName("email finder good link no email")
    void testemailfinder3() {
        EmailFinder b = new EmailFinder();
        String[] c = {"src/test/resources/goodlinknoemail.txt" };
        b.run(c);

        try {

            BufferedReader reader = new BufferedReader(new FileReader("good-links.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            assertEquals(1, lines);

        } catch (Exception e) {
            System.out.println("doesn't work");
        }
    }

    @Test
    @DisplayName("email finder good link no email")
    void testemailfinder4() {
        EmailFinder b = new EmailFinder();
        String[] c = {"src/test/resources/moreemails.txt" };
        b.run(c);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("email.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            assertEquals(3, lines);

        } catch (Exception e) {
            System.out.println("doesn't work");        }
    }










}
