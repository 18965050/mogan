package cn.xyz.io.mogan.impl.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

/**
 * <pre>
 *     TestInfo: resolved by TestInfoParameterResolver
 *     RepetitionInfo: resolved by RepetitionInfoParameterResolver
 *     TestReporter: resolved by TestReporterParameterResolver
 * </pre>
 *
 * @author lvchenggang.
 * @date 2019/4/15 9:58
 * @see
 * @since
 */
@DisplayName("TestInfo Demo")
public class TestInfoDemo {

    TestInfoDemo(TestInfo testInfo) {
        assertEquals("TestInfo Demo", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void test1(TestInfo testInfo) {
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {}

}
