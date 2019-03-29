package cn.xyz.io.mogan.orika;

import cn.xyz.io.mogan.dto.TestDTO;
import cn.xyz.io.mogan.entity.Test;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * @author lvchenggang.
 * @date 2019/3/29 13:35
 * @see
 * @since
 */
public class IoMoganOrikaMapperFactoryConfigurer extends XyzAbstractOrikaMapperFactoryConfigurer {
    @Override
    protected void addConverter(ConverterFactory converterFactory) {
        //注册global converter
        converterFactory.registerConverter(new TestConverter());

//        //注册field converter
//        converterFactory.registerConverter("testConverter",new TestConverter());
    }

    @Override
    protected void addFluidMapper(MapperFactory mapperFactory) {
        mapperFactory.classMap(Test.class, TestDTO.class).fieldMap("testId", "id").add().byDefault().register();
    }
}
