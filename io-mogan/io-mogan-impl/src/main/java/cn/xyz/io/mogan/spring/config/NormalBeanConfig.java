package cn.xyz.io.mogan.spring.config;

import cn.xyz.chaos.common.utils.SpringContextUtils;
import cn.xyz.io.mogan.orika.IoMoganOrikaMapperFactoryConfigurer;
import cn.xyz.io.mogan.orika.TestCustomMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvchenggang.
 * @date 2019/3/29 13:57
 * @see
 * @since
 */
@Configuration
public class NormalBeanConfig {

    @Bean
    public SpringContextUtils springContextUtils(){
        return new SpringContextUtils();
    }

}
