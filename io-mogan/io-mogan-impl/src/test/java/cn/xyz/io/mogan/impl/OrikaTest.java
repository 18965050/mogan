package cn.xyz.io.mogan.impl;

import cn.xyz.io.mogan.dto.TestDTO;
import cn.xyz.io.mogan.dto.TestDTO2;
import cn.xyz.io.mogan.dto.TestDTO3;
import cn.xyz.io.mogan.orika.MappingUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lvchenggang.
 * @date 2019/3/29 13:52
 * @see
 * @since
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrikaTest {

    @Test
    public void testOrika() {
        cn.xyz.io.mogan.entity.Test test = new cn.xyz.io.mogan.entity.Test();
        test.setTestId(100);
        test.setName("aaa");
        TestDTO testDTO = MappingUtils.beanConvert(test, TestDTO.class);
        Assert.assertEquals("id same", test.getTestId(), testDTO.getId());
        Assert.assertEquals("name same", test.getName(), testDTO.getName());

        testDTO.setId(200);
        testDTO.setName("bbb");
        MappingUtils.beanConvert(testDTO, test);
        Assert.assertEquals("id same", testDTO.getId(), test.getTestId());
        Assert.assertEquals("name same", testDTO.getName(), test.getName());

        TestDTO2 testDTO2 = MappingUtils.beanConvert(test, TestDTO2.class);
        Assert.assertEquals("id same", test.getTestId(), testDTO2.getId2());
        Assert.assertEquals("name same", test.getName(), testDTO2.getName());

        testDTO2.setId2(300);
        testDTO2.setName("ccc");
        test=MappingUtils.beanConvert(testDTO2, cn.xyz.io.mogan.entity.Test.class);
//        MappingUtils.beanConvert(testDTO2, test);
        Assert.assertEquals("id same", testDTO2.getId2(), test.getTestId());
        Assert.assertEquals("name same", testDTO2.getName(), test.getName());

        TestDTO3 testDTO3 = MappingUtils.beanConvert(test, TestDTO3.class);
        Assert.assertEquals("id same", test.getTestId(), testDTO3.getId3());
        Assert.assertEquals("name same", test.getName(), testDTO3.getName());

        testDTO3.setId3(400);
        testDTO3.setName("ddd");
        MappingUtils.beanConvert(testDTO3, test);
        Assert.assertEquals("id same",testDTO3.getId3(), test.getTestId());
        Assert.assertEquals("name same",testDTO3.getName(), test.getName());
    }
}
