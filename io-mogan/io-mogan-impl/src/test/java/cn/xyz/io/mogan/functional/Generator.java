package cn.xyz.io.mogan.functional;

import java.io.IOException;
import java.sql.SQLException;

import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;

import cn.xyz.chaos.orm.generator.GeneratorLauncher;

/**
 * @author chaochenghan
 */
public class Generator {
    public static void main(String[] args)
        throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {
        GeneratorLauncher.generate(getResourcesPath() + "/mybatis/generatorConfig.xml");
    }

    private static String getResourcesPath() {
        //noinspection ConstantConditions
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        return classpath.substring(1, classpath.indexOf("/target")) + "/src/main/resources";
    }
}
