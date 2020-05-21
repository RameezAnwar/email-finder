
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


public class pagefetcherTest {

    @Test
    @DisplayName("fetcher get link get")
    void fetchertest1() {
        PageFetcher testing = new PageFetcher();
        testing.get( "src/test/resources/moreemails.txt");
        assertTrue( testing.get("src/test/resources/moreemails.txt") != null);
    }

    @Test
    @DisplayName("fetcher bad link error get")
    void fetchertest2() {
        PageFetcher testing = new PageFetcher();

        assertThrows(EmailFinderException.class, () -> testing.get("src/resources/test/gnome"));
    }

    @Test
    @DisplayName("fetcher getstring good link")
    void fetchertest3() {
        PageFetcher testing = new PageFetcher();
        assertTrue( testing.getString("https://google.com") != null);
        //assertThrows(EmailFinderException.class, () -> testing.get("src/resources/test/gnome"));
    }

    @Test
    @DisplayName("fetcher getstring bad link error")
    void fetchertest4() {
        PageFetcher testing = new PageFetcher();

        assertThrows(EmailFinderException.class, () -> testing.getString("gnome.com"));
    }

    @Test
    @DisplayName("fetcher get good link2")
    void fetchertest5() {
        PageFetcher testing = new PageFetcher();
        assertTrue( testing.get("https://google.com") != null);
        //assertThrows(EmailFinderException.class, () -> testing.get("src/resources/test/gnome"));
    }

    @Test
    @DisplayName("fetcher get bad link2")
    void fetchertest6() {
        PageFetcher testing = new PageFetcher();
        //assertTrue( testing.get("https://gojsbgfjersfse.com") != null);
        assertThrows(EmailFinderException.class, () -> testing.get("https://gojsbgfjersfse.com"));
    }


}
