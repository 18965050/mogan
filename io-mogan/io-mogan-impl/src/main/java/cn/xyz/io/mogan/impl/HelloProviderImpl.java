package cn.xyz.io.mogan.impl;

import cn.xyz.io.mogan.api.HelloProvider;
import cn.xyz.io.mogan.repository.TestRepository;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 测试实现
 *
 * @author lvchenggang.
 * @date 2019/3/27 15:18
 * @see
 * @since
 */
@Service(interfaceClass = HelloProvider.class)
@Component
public class HelloProviderImpl implements HelloProvider {

    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    TestRepository testRepo;

    @Override
    public String sayHello(String name) {
        return "Hello,"+name;
    }

    @Override
    public void batchInsertCommit() {
        this.testRepo.batchInsertCommit();
    }

    @Override
    public void batchInsertRollback() {
        try{
            this.testRepo.batchInsertRollback();
        }catch (RuntimeException e){
            logger.error("rollback");
        }
    }
}
