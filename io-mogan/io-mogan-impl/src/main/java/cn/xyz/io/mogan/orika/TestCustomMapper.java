package cn.xyz.io.mogan.orika;

import cn.xyz.io.mogan.dto.TestDTO3;
import cn.xyz.io.mogan.entity.Test;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

/**
 * @author lvchenggang.
 * @date 2019/3/29 14:46
 * @see
 * @since
 */
public class TestCustomMapper extends CustomMapper<Test,TestDTO3> {
    @Override
    public void mapAtoB(Test test, TestDTO3 testDTO3, MappingContext context) {
        if(null!=test){
            testDTO3.setId3(test.getTestId());
            testDTO3.setName(test.getName());
        }
    }

    @Override
    public void mapBtoA(TestDTO3 testDTO3, Test test, MappingContext context) {
        if(null!=testDTO3){
            test.setTestId(testDTO3.getId3());
            test.setName(testDTO3.getName());
        }
    }
}
