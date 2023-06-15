package com.frm.utils;

import java.io.File;
import java.util.List;

import com.creditdatamw.zerocell.Reader;
import com.frm.constants.FrameworkConstant;
import com.frm.testdata.NewMessage;
import com.machinezoo.noexception.Exceptions;

public final class ExcelUtil {

	private ExcelUtil() {}
	
	private static List<NewMessage> testData;
	
	static {
		testData = Reader
				.of(NewMessage.class)
				.from(Exceptions.wrap(RuntimeException::new).get(() -> new File(FrameworkConstant.getTestDataExcelPath())))
				.skipHeaderRow(true)
				.list();
	}
	
	public static List<NewMessage> getTestData() {
		
		return testData;
	}
	
	public static <T>List<T> getTestData(T testData) {
		
		return Reader
				.of(testData.getClass())
				.from(Exceptions.wrap(RuntimeException::new).get(() -> new File(FrameworkConstant.getTestDataExcelPath())))
				.skipHeaderRow(true)
				.list();
	}
}
