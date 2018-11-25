package com.zhangrenhua;

import com.zhangrenhua.springboot.config.Config;
import com.zhangrenhua.springboot.config.Demo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Random;

@SpringBootApplication
@PropertySource(value="classpath:my.properties",encoding="utf-8")
@ServletComponentScan
@EnableTransactionManagement
@RestController
public class Chapter2Application {

	@Value("${code}")
	private String code;

	@Value("${name}")
	private String name;

	@Autowired
	private Config config;

	@RequestMapping("/")
	public String home(){
		int a = new Random().nextInt(2);
		if(a == 1){
			throw new IllegalArgumentException("3ewwwew");
		}
		return "Hello World！" + code + "/" + name + "|" + config.toString() ;
	}
	
	@PostMapping("/demo/a1")
	public String a1(@RequestBody @Valid Demo1 demo1){
		return demo1.getName() + " / " +  demo1.getAge();
	}
	
	/*@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		//当过滤器有注入其他bean类时，可直接通过@bean的方式进行实体类过滤器，这样不可自动注入过滤器使用的其他bean类。
		//当然，若无其他bean需要获取时，可直接new CustomFilter()，也可使用getBean的方式。
		registration.setFilter(customFilter());
		//过滤器名称
		registration.setName("customFilter");
		//拦截路径
		registration.addUrlPatterns("*//*");
		//设置顺序
		registration.setOrder(10);
		return registration;
	}
	
	@Bean
	public Filter customFilter() {
		return new CustomFilter();
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(Chapter2Application.class, args);
	}
}
