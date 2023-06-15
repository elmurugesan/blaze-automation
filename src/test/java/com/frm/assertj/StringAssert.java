package com.frm.assertj;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class StringAssert extends AbstractAssert<StringAssert, String> {

	private StringAssert(String actual, Class<?> selfType) {
		super(actual, selfType);
	}
	
	public static StringAssert assertThat(String string) {
		return new StringAssert(string, StringAssert.class);
	}
	
	public StringAssert isStringContainsIngoringCase(String expected) {
		Assertions.assertThat(actual)
		.withFailMessage(() -> expected+" is NOT matched with "+actual)
		.isNotNull()
		.isNotBlank()
		.isNotEmpty()
		.containsIgnoringCase(expected);
		return this;
	}

}
