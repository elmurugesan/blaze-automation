package com.frm.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.frm.drivers.Driver;

public class BaseTest {
	
	@BeforeMethod
	protected static void setUp() {
		Driver.initDriver();
		
	}
	
	@AfterMethod
	protected static void tearDown() {
		Driver.quitDriver();
	}

}
