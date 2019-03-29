package cn.xyz.io.mogan;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Bootstrap Class
 *
 * @author lvchenggang.
 * @date 2019/3/27 10:47
 * @see
 * @since
 */
@SpringBootApplication
@EnableDubboConfiguration
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(basePackages = {"cn.xyz.io.mogan.repository"},
    annotationClass = cn.xyz.chaos.orm.mybatis.MyBatisRepository.class)
public class IoMoganApplication {

    public static void main(String[] args)throws Exception {
        SpringApplication.run(IoMoganApplication.class,args);
    }
}
