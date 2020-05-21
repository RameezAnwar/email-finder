
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


public class pageparserTest {

    @Test
    @DisplayName("file 1 email")
    void parsertest1() {
        PageParser tester = new PageParser();
        Document doc = new PageFetcher().get(System.getProperty("user.dir") + "/src/test/resources/tester.txt");
        assertEquals( tester.findEmails(doc).size(), 1);
    }

    @Test
    @DisplayName("file more than 1 link")
    void parsertest2() {
        PageParser tester = new PageParser();
        Document doc = new PageFetcher().get(System.getProperty("user.dir") + "/src/test/resources/8emaillimitcheck.txt");
        assertEquals( tester.findEmails(doc).size(), 8);
    }

    @Test
    @DisplayName("html file 0 a tag")
    void parsertest3() {
        PageParser tester = new PageParser();
        Document doc = new PageFetcher().get(System.getProperty("user.dir") + "/src/test/resources/noatag.html");
        assertEquals( tester.findLinks(doc).size(), 0);
    }

    @Test
    @DisplayName("html file 1 a tag")
    void parsertest4() {
        PageParser tester = new PageParser();
        Document doc = new PageFetcher().get(System.getProperty("user.dir") + "/src/test/resources/1tag.html");
        assertEquals( tester.findLinks(doc).size(), 1);
    }

    @Test
    @DisplayName("html file 3 a tag")
    void parsertest5() {
        PageParser tester = new PageParser();
        Document doc = new PageFetcher().get(System.getProperty("user.dir") + "/src/test/resources/3tag.html");
        assertEquals( tester.findLinks(doc).size(), 3);
    }

    @Test
    @DisplayName("html file relative base tag")
    void parsertest6() {
        PageParser tester = new PageParser();
        Document doc = new PageFetcher().get(System.getProperty("user.dir") + "/src/test/resources/basetagrelative.html");

        assertFalse( tester.findLinks(doc).size() == 1);
    }






}
