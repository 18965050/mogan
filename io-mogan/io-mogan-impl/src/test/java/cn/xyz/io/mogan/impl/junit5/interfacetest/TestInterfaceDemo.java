package cn.xyz.io.mogan.impl.junit5.interfacetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author lvchenggang.
 * @date 2019/4/15 10:29
 * @see
 * @since
 */
public class TestInterfaceDemo implements TimeExecutionLogger, TestInterfaceDynamicTestsDemo {

    @Test
    void isEqualValue() {
        assertEquals(1, 1, "is always equal");
    }
}
