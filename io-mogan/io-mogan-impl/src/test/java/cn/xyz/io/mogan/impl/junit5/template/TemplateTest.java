package cn.xyz.io.mogan.impl.junit5.template;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author lvchenggang.
 * @date 2019/4/15 11:50
 * @see
 * @since
 */
public class TemplateTest {

    @TestTemplate
    @ExtendWith(MyTestTemplateInvocationContextProvider.class)
    void testTemplate(String parameter) {
        assertEquals(3, parameter.length());
    }

}
