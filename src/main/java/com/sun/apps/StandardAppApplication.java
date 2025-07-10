package com.sun.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties
public class StandardAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandardAppApplication.class, args);

		List<String> list = Arrays.asList("apple", "banana", "cherry");
		List<String> list1 = Arrays.asList("", "", "");
		String result = String.join(", ", list);
		test(String.join(",", list1));
		//System.out.println(result);
	}
	public static void test(String str){
		System.out.println(str);

	}

}
