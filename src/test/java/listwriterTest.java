
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


public class listwriterTest {

    @Test
    @DisplayName("listwriter confrim badlinks is writing")
    void testlistwriter1() {

        try {
            OutputStream testing = new FileOutputStream("badlinks.txt");
            ListWriter tester = new ListWriter(testing);
            List<String> list = Arrays.asList("C:/Users/uwu", "D:/no-u");
            tester.writeList(list );

            BufferedReader reader = new BufferedReader(new FileReader("badlinks.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            assertEquals(2, lines);


        } catch( Exception e) {
            System.out.println("doesn't work");
        }
    }

    @Test
    @DisplayName("listwriter confrim good-links is writing")
    void testlistwriter2() {

        try {
            OutputStream testing = new FileOutputStream("good-links.txt");
            ListWriter tester = new ListWriter(testing);
            List<String> list = Arrays.asList("C:/Users/uwu", "c:/bemore", "D:/Steam");
            tester.writeList(list );

            BufferedReader reader = new BufferedReader(new FileReader("good-links.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            assertEquals(3, lines);


        } catch( Exception e) {
            System.out.println("doesn't work");        }
    }

    @Test
    @DisplayName("listwriter confirm email is writing")
    void testlistwriter3() {

        try {
            OutputStream testing = new FileOutputStream("email.txt");
            ListWriter tester = new ListWriter(testing);
            List<String> list = Arrays.asList("itbelikethat@simp.com");
            tester.writeList(list );

            BufferedReader reader = new BufferedReader(new FileReader("email.txt"));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            assertEquals(1, lines);


        } catch( Exception e) {
            System.out.println("doesn't work");        }
    }



}

