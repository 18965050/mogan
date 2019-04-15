package cn.xyz.io.mogan.impl.junit5;

import static java.time.Duration.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

/**
 * @author lvchenggang.
 * @date 2019/4/12 16:13
 * @see
 * @since
 */
@DisplayName("A standard test case")
@TestInstance(TestInstance.Lifecycle.PER_METHOD /*default. every test method invoke a new test Instane*/ /*Lifecycle.PER_CLASS*/)
public class StandardTest {

    @BeforeAll
    static void initAll() {
        System.out.println("initAll");
    }

    @BeforeEach
    void init() {
        System.out.println("init");
    }

    @Test
    @DisplayName("succeed test")
    void succeedingTest() {
        assertEquals(2, 2);
        assertEquals(4, 4, "The optional assertion message is now the last parameter.");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
            + "to avoid constructing complex messages unnecessarily.");

        Person person = new Person().getDefaultPerson();
        assertAll("myPerson", () -> assertEquals("John", person.getFirstName()),
            () -> assertEquals("Doe", person.getLastName()));

    }

    @Test
    void succeedingTest2() {
        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        Person person = new Person().getDefaultPerson();
        assertAll("properties", () -> {
            String firstName = person.getFirstName();
            assertNotNull(firstName);

            // Executed only if the previous assertion is valid.
            assertAll("first name", () -> assertTrue(firstName.startsWith("J")),
                () -> assertTrue(firstName.endsWith("n")));
        }, () -> {
            // Grouped assertion, so processed independently
            // of results of first name assertions.
            String lastName = person.getLastName();
            assertNotNull(lastName);
            // Executed only if the previous assertion is valid.
            assertAll("last name", () -> assertTrue(lastName.startsWith("D")),
                () -> assertTrue(lastName.endsWith("e")));
        });

    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

    @Test
    void timeoutTest() {
        // The following assertion succeeds.
        assertTimeout(ofSeconds(2), () -> {
            // fail if execution exceed expect time
            TimeUnit.SECONDS.sleep(1);
        });

        String actualResult = assertTimeout(ofMinutes(2), () -> {
            return "a result";
        });
        assertEquals("a result", actualResult);

        String actualGreeting = assertTimeout(ofMinutes(2), StandardTest::greeting);
        assertEquals("Hello, World!", actualGreeting);

        assertTimeoutPreemptively(ofMillis(100), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(10);
        });

    }

    @Test

    void assertWithHamcrestMatcher() {
        assertThat(2 + 1, is(equalTo(3)));
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @EnabledOnJre(JRE.JAVA_8)
    @EnabledIfSystemProperty(named = "hello",matches = "lcg")
    @EnabledIf("2*3==6")
    void conditionalTest(){

    }

    @Test
    @Tag("myTag")
    void tagTest(){

    }

    @Test
    void assumeTest() {
        /**
         * assume用于必须具备某个条件才能进行测试, 但没有这个条件又不会判断为fail
         */
//        assumeTrue("CI".equals(System.getenv("ENV")));

//        assumeTrue("DEV".equals(System.getenv("ENV")), () -> "Aborting test: not on developer workstation");

        assumingThat("CI".equals(System.getenv("ENV")), () -> {
            // perform these assertions only on the CI server
            assertEquals(2, 2);
        });

    }

    @Test
    void failingTest() {
        // fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {
        System.out.println("afterEach");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("afterAll");
    }

    private static String greeting() {
        return "Hello, World!";
    }

    private class Person {
        private String firstName;
        private String lastName;

        public Person() {}

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Person getDefaultPerson() {
            return new Person("John", "Doe");
        }
    }

}
