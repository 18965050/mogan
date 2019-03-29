package cn.xyz.io.mogan.orika;

import cn.xyz.io.mogan.dto.TestDTO2;
import cn.xyz.io.mogan.entity.Test;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

/**
 * @author lvchenggang.
 * @date 2019/3/29 14:33
 * @see
 * @since
 */
public class TestConverter extends BidirectionalConverter<Test,TestDTO2> {

    @Override
    public TestDTO2 convertTo(Test source, Type<TestDTO2> destinationType) {
        if(null==source){
            return null;
        }
        TestDTO2 testDTO2=new TestDTO2();
        testDTO2.setId2(source.getTestId());
        testDTO2.setName(source.getName());
        return testDTO2;
    }

    @Override
    public Test convertFrom(TestDTO2 source, Type<Test> destinationType) {
        if(null==source){
            return null;
        }
        Test test=new Test();
        test.setTestId(source.getId2());
        test.setName(source.getName());
        return test;
    }
}
