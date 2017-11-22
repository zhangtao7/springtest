package com.springtest.yamltest;

import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlTest {

	public static void main(String[] args) {
		Yaml yaml=new Yaml();
		Map<String,List<String>> data=yaml.load(YamlTest.class.getResourceAsStream("/mytest.yaml"));
		//InputStream stream=YamlTest.class.getResourceAsStream("/mytest.yaml");
		//System.out.println(stream);
		System.out.println(data);
	}

}
