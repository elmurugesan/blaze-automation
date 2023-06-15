package com.frm.config.converter;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;

import com.frm.enums.RunMode;

public class StringToRunModeTypeConverter implements Converter<RunMode>{

	@Override
	public RunMode convert(Method method, String runMode) {
		return RunMode.valueOf(runMode.toUpperCase());
	}
}
