package com.chy.generator;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorRun {
	public static void main(String[] args) {
		String genCfg = "D:\\work\\workspace\\chy\\src\\com\\chy\\generator\\generator.xml";
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		System.out.println(genCfg);
		File configFile = new File(genCfg);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = null;
		try {
			config = cp.parseConfiguration(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		}
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = null;
		try {
			myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		try {
			myBatisGenerator.generate(null);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
