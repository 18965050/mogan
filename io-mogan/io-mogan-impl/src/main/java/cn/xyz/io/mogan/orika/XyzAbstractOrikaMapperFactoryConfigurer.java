package cn.xyz.io.mogan.orika;

import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Custom Orika MapperFactory
 *
 * @author lvchenggang.
 * @date 2019/3/29 11:57
 * @see
 * @since
 */
public abstract class XyzAbstractOrikaMapperFactoryConfigurer
    implements OrikaMapperFactoryConfigurer, ApplicationContextAware {

    private MapperFactory mapperFactory;

    private ApplicationContext ac;

    @Override
    public void configure(MapperFactory orikaMapperFactory) {
        this.mapperFactory = orikaMapperFactory;

        // (1)先添加converter,converter可被mapper使用
        this.addConverter(this.mapperFactory.getConverterFactory());

        // (2)添加 Custom Mapper,Custom Mapper继承ma.glasnost.orika.CustomMapper
        Map<String, Mapper> mappers = ac.getBeansOfType(Mapper.class);
        for (final Mapper mapper : mappers.values()) {
            addMapper(mapper);
        }

        // (3)添加Fluid Mapper
        addFluidMapper(mapperFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }

    private void addMapper(Mapper<?, ?> mapper) {
        mapperFactory.classMap(mapper.getAType(), mapper.getBType()).byDefault().customize((Mapper)mapper).register();
    }

    abstract protected void addConverter(ConverterFactory converterFactory);

    abstract protected void addFluidMapper(MapperFactory mapperFactory);
}
