package cn.xyz.io.mogan.impl;

import cn.xyz.io.mogan.api.HelloProvider;
import cn.xyz.io.mogan.repository.TestRepository;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * UT类
 *
 * @author lvchenggang.
 * @date 2019/3/27 16:18
 * @see
 * @since
 */

@SpringBootTest
public class HelloProviderTest {

    @Reference
    private HelloProvider helloProvider;

    @Autowired
    private TestRepository testRepository;

    @Test
    public void testSayHello(){
        String resStr=helloProvider.sayHello("lcg");
        assertEquals("same!","Hello,lcg",resStr);
    }

    @Test
    @Transactional
    @Rollback
    public void testTransactionCommit(){
        this.helloProvider.batchInsertCommit();
        List<cn.xyz.io.mogan.entity.Test> testList=this.testRepository.selectAll();
        assertTrue("same count",2==testList.size());
    }

    @Test
    public void testTransactionRollback(){
        this.helloProvider.batchInsertRollback();
        List<cn.xyz.io.mogan.entity.Test> testList=this.testRepository.selectAll();
        assertTrue("same count", CollectionUtils.isEmpty(testList));
    }
}
