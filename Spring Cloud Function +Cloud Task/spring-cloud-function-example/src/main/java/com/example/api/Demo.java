package com.example.api;

import java.util.function.Supplier;

public class Demo implements Supplier<Book>{

	@Override
	public Book get() {
		return new Book(1, "Core Java");
	}

}
