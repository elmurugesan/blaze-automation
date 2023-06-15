package com.frm.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DataTimeUtil {
	
	private DataTimeUtil() {}
	
	public static String getCurrentDataTime() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   return dtf.format(now);  
	}

}
