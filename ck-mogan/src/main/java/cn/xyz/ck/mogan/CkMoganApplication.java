package cn.xyz.ck.mogan;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Bootstrap Class
 *
 * @author lvchenggang.
 * @date 2019/3/31 15:53
 * @see
 * @since
 */
@SpringBootApplication
@EnableDubboConfiguration
public class CkMoganApplication{
    public static void main(String[] args) {
        SpringApplication.run(CkMoganApplication.class, args);
    }
}
