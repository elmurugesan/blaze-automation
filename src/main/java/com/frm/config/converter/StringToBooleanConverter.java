package com.frm.config.converter;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;

public class StringToBooleanConverter implements Converter<Boolean>{

	@Override
	public Boolean convert(Method method, String input) {
		return Boolean.valueOf(input);
	}
}
