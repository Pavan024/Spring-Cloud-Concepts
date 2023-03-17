package com.example.api;

import java.util.function.Consumer;

public class Sample implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println(t);
	}

}
