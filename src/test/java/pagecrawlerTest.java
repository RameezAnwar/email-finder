
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


public class pagecrawlerTest {

    @Test
    @DisplayName("Pagecrawler good link no email")
    void pagetest1() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");

        PageCrawler crawling = new PageCrawler(storage, 5);
        crawling.crawl("src/test/resources/goodlinknoemail.txt");
        assertEquals( crawling.getGoodLinks().size(), 1);
    }

    @Test
    @DisplayName("Pagecrawler bad link")
    void pagetest2() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");

        PageCrawler crawling = new PageCrawler(storage, 5);
        crawling.crawl("C:/Users/Magikarp/Desktop/badderino.txt");
        assertEquals( crawling.getBadLinks().size(), 1);

    }

    @Test
    @DisplayName("Pagecrawler good link 1 email")
    void pagetest3() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");

        PageCrawler crawling = new PageCrawler(storage, 5);
        crawling.crawl("src/test/resources/tester.txt");
        assertEquals( crawling.getEmails().size(), 1);

    }

    @Test
    @DisplayName("Pagecrawler good link more than 1 email under limit")
    void pagetest4() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");

        PageCrawler crawling = new PageCrawler(storage, 5);
        crawling.crawl("src/test/resources/moreemails.txt");
        assertEquals( crawling.getEmails().size(), 3);

    }


    @Test
    @DisplayName("Pagecrawler good link more than 1 email over limit")
    void pagetest5() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");

        PageCrawler crawling = new PageCrawler(storage, 5);
        crawling.crawl("src/test/resources/8emaillimitcheck.txt");

        assertFalse( crawling.getEmails().size() == 5);

    }


    //recursion check
    @Test
    @DisplayName("Pagecrawler recursive check")
    void pagetest6() {
        StorageService storage = new StorageService();
        storage
                .addLocation(EMAIL, "email.txt")
                .addLocation(GOODLINKS, "good-links.txt")
                .addLocation(BADLINKS, "badlinks.txt");

        PageCrawler crawling = new PageCrawler(storage, 5);
        crawling.crawl("src/test/resources/recursive1.html");

        assertTrue( crawling.getEmails().size() == 2);

    }

}
