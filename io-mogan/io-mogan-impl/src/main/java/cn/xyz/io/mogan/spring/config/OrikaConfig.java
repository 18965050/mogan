package cn.xyz.io.mogan.spring.config;

import cn.xyz.io.mogan.orika.IoMoganOrikaMapperFactoryConfigurer;
import cn.xyz.io.mogan.orika.TestCustomMapper;
import cn.xyz.io.mogan.orika.XyzOrikaMapperFactoryBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvchenggang.
 * @date 2019/3/29 16:34
 * @see
 * @since
 */
@Configuration
public class OrikaConfig {

    @Bean
    public IoMoganOrikaMapperFactoryConfigurer ioMoganOrikaMapperFactoryConfigurer(){
        return new IoMoganOrikaMapperFactoryConfigurer();
    }

    @Bean
    public XyzOrikaMapperFactoryBuilderConfigurer xyzOrikaMapperFactoryBuilderConfigurer(){
        return new XyzOrikaMapperFactoryBuilderConfigurer();
    }

    @Bean
    public TestCustomMapper testCustomMapper(){
        return new TestCustomMapper();
    }
}
