package com.zhangrenhua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@PropertySource(value="classpath:my.properties",encoding="utf-8")
public class Chapter2Application {

	@Value("${code}")
	private String code;

	@Value("${name}")
	private String name;

	@Autowired
	private Config config;

	@RequestMapping("/")
	public String home(){
		return "Hello World！" + code + "/" + name + "|" + config.toString() ;
	}

	public static void main(String[] args) {
		SpringApplication.run(Chapter2Application.class, args);
	}
}
