package com.frm.config.converter;

import java.lang.reflect.Method;
import java.net.URL;

import org.aeonbits.owner.Converter;

import com.machinezoo.noexception.Exceptions;

public class StringToURLConverter implements Converter<URL> {

	@Override
	public URL convert(Method method, String url) {
		return Exceptions.wrap(RuntimeException::new).get(() -> new URL(url));
	}

}
