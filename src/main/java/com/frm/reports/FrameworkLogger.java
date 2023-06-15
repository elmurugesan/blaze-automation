package com.frm.reports;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiConsumer;

import com.frm.enums.LogType;

public final class FrameworkLogger {

	private FrameworkLogger() {}
	
	private static BiConsumer<String, Boolean> PASS = (message, isScreenshotNeeded) -> ExtentLogger.pass(message, isScreenshotNeeded);
	private static BiConsumer<String, Boolean> FAIL = (message, isScreenshotNeeded) -> ExtentLogger.fail(message, isScreenshotNeeded);
	private static BiConsumer<String, Boolean> SKIP = (message, isScreenshotNeeded) -> ExtentLogger.skip(message, isScreenshotNeeded);
	private static BiConsumer<String, Boolean> INFO = (message, isScreenshotNeeded) -> ExtentLogger.info(message);
	
	private static BiConsumer<String, Boolean> PASS_CONSOLE = (message, isScreenshotNeeded) -> System.out.println("PASS ---> "+message);
	private static BiConsumer<String, Boolean> FAIL_CONSOLE = (message, isScreenshotNeeded) -> System.out.println("FAIL ---> "+message);
	private static BiConsumer<String, Boolean> SKIP_CONSOLE = (message, isScreenshotNeeded) -> System.out.println("SKIP ---> "+message);
	private static BiConsumer<String, Boolean> INFO_CONSOLE = (message, isScreenshotNeeded) -> System.out.println("INFO ---> "+message);
	
	private static BiConsumer<String, Boolean> PASS_EXTENT_AND_CONSOLE = PASS.andThen(PASS_CONSOLE);
	private static BiConsumer<String, Boolean> FAIL_EXTENT_AND_CONSOLE = FAIL.andThen(FAIL_CONSOLE);
	private static BiConsumer<String, Boolean> SKIP_EXTENT_AND_CONSOLE = SKIP.andThen(SKIP_CONSOLE);
	private static BiConsumer<String, Boolean> INFO_EXTENT_AND_CONSOLE = INFO.andThen(INFO_CONSOLE);
	
	private static Map<LogType, BiConsumer<String, Boolean>> MAP = new EnumMap<>(LogType.class);
	
	static {
		MAP.put(LogType.PASS, PASS);
		MAP.put(LogType.FAIL, FAIL);
		MAP.put(LogType.SKIP, SKIP);
		MAP.put(LogType.INFO, INFO);
		MAP.put(LogType.PASS_CONSOLE, PASS_CONSOLE);
		MAP.put(LogType.FAIL_CONSOLE, FAIL_CONSOLE);
		MAP.put(LogType.SKIP_CONSOLE, SKIP_CONSOLE);
		MAP.put(LogType.INFO_CONSOLE, INFO_CONSOLE);
		MAP.put(LogType.PASS_EXTENT_AND_CONSOLE, PASS_EXTENT_AND_CONSOLE);
		MAP.put(LogType.FAIL_EXTENT_AND_CONSOLE, FAIL_EXTENT_AND_CONSOLE);
		MAP.put(LogType.SKIP_EXTENT_AND_CONSOLE, SKIP_EXTENT_AND_CONSOLE);
		MAP.put(LogType.INFO_EXTENT_AND_CONSOLE, INFO_EXTENT_AND_CONSOLE);
	}
	
	public static void log(LogType logType, String message, boolean isScreenshotNeeded) {
		MAP.get(logType).accept(message, isScreenshotNeeded);
	}
}
