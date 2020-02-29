package com.pink.screw.java.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pink.screw.java.entities.Person;

public class Resources<T> {
	private final List<Person> producers;

	@JsonCreator
	public Resources(@JsonProperty("producers") List<Person> producers) {

		this.producers = producers;
	}


	public List<Person> getContent() {

		return this.producers;
	}

}