package com.frm.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.frm.enums.CatagoryType;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface FrameworkAnnotaion {

	public String[] authors();
	
	public CatagoryType[] catagories();
}
