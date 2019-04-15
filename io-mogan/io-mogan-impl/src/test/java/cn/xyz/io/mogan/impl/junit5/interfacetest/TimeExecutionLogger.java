package cn.xyz.io.mogan.impl.junit5.interfacetest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author lvchenggang.
 * @date 2019/4/15 10:28
 * @see
 * @since
 */
@Tag("interfacetest")
@ExtendWith(TimingExtension.class)
public interface TimeExecutionLogger {

}
