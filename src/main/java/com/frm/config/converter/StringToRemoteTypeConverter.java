package com.frm.config.converter;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;

import com.frm.enums.RemoteType;

public class StringToRemoteTypeConverter implements Converter<RemoteType>{

	@Override
	public RemoteType convert(Method method, String remoteType) {
		return RemoteType.valueOf(remoteType.toUpperCase());
	}

}
