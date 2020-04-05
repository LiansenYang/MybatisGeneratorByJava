package com.yangLs.MybatisGeneratorByJava;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, Exception
    {
    	List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String path = App.class.getClassLoader().getResource("generatorConfig.xml").getPath();
        File configFile = new File(path);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
