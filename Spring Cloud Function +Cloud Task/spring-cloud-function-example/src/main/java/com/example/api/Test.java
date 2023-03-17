package com.example.api;

import java.util.function.Function;

public class Test implements Function<String, String>{

	@Override
	public String apply(String t) {
		System.out.println(t);
		return "Serverless functional programming : " + t;
	}

}
