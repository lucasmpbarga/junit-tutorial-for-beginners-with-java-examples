package test;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class StringTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("=====Initialize connection to database=====");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("=====Close connection to database=====");
    }

    @BeforeEach
        //@Before
    void beforeEach(TestInfo testInfo) {
        System.out.println("BeforeEach - Initialize Test Data for each test: " + testInfo.getDisplayName());
    }

    @AfterEach
        //@After
    void afterEach(TestInfo testInfo) {
        System.out.println("AfterEach - Clen up Test Data: " + testInfo.getDisplayName());
    }

    @Test
    @RepeatedTest(7)
    void testLengthString() {
        Integer actualLength = "ABC".length();
        Integer expectedLength = 3;

        assertEquals(expectedLength, actualLength);
    }

    @Test
    void toUpperCase() {
        String string = "abcd".toUpperCase();
        assertEquals("ABCD", string);
    }

    @Test
    void stringContains() {
//        String string = "abcdefghi";
//        Boolean result = string.contains("def");,
//        assertEquals(true, result);
        assertTrue("abcdefghi".contains("def"));
    }

    @Test
    void splitArray() {
        String string = "abc def ghi";
        String actualArray[] = string.split(" ");
        String[] expectedArray = new String[]{"abc", "def", "ghi"};
        assertArrayEquals(expectedArray, actualArray);
    }

    //This test expected a exception if your return be a true generates error in test
    @Test()
    @DisplayName("When lenght is null, throw an exception")
    void testLengthException() {
        String string = null;
        assertThrows(
                NullPointerException.class,
                () -> {
                    string.length();
                }
        );
    }

    @Test()
    @Disabled
        //@Ignored
    void performanceTest() {
        assertTimeout(
                Duration.ofSeconds(4),
                () -> {
                    for (int i = 0; i <= 1000000; i++) {
                        System.out.println(i);
                    }
                }
        );
    }

    @Nested
    @DisplayName("For an empty String")
    class EmptyStringTest {
        String string;

        @BeforeEach
        void setToEmpty() {
            string = "";
        }

        @Test
        void lenthIsZero() {
            assertEquals(0, string.length());
        }

        @Test
        void upperCaseIsEmpty(){
            assertEquals("", string.toUpperCase());
        }
    }
}
