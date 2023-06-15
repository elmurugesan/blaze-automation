package com.frm.config;

import java.net.URL;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

import com.frm.config.converter.StringToRunModeTypeConverter;
import com.frm.config.converter.StringToURLConverter;
import com.frm.config.converter.StringToBooleanConverter;
import com.frm.config.converter.StringToBrowserTypeConverter;
import com.frm.config.converter.StringToRemoteTypeConverter;
import com.frm.enums.BrowserType;
import com.frm.enums.RemoteType;
import com.frm.enums.RunMode;

@LoadPolicy(Config.LoadType.MERGE)

@Sources({"system:properties",
	"system:env",
	"file:${user.dir}/src/test/resources/config/FrameworkConfig.properties"})
public interface FrameworkConfig extends Config {

	@Key("environment")
	String environment();
	
	@Key("${environment}.url")
	String url();
	
	@DefaultValue("CHROME")
	@Key("browser")
	@ConverterClass(StringToBrowserTypeConverter.class)
	BrowserType browserName();
	
	@Key("browserVersion")
	String browserVersion();
	
	@DefaultValue("LOCAL")
	@Key("runmode")
	@ConverterClass(StringToRunModeTypeConverter.class)
	RunMode runMode();
	
	@Key("remoteType")
	@ConverterClass(StringToRemoteTypeConverter.class)
	RemoteType remoteType();
	
	@Key("seleniumgridurl")
	@ConverterClass(StringToURLConverter.class)
	URL seleniumGridURL();
	
	@Key("overrideextentreportfile")
	@ConverterClass(StringToBooleanConverter.class)
	Boolean overrideExtentReportFile();
	
	@Key("attachscreenshotforpass")
	@ConverterClass(StringToBooleanConverter.class)
	Boolean attachScreenshotForPass();
	
	@Key("attachscreenshotforfail")
	@ConverterClass(StringToBooleanConverter.class)
	Boolean attachScreenshotForFail();
	
	@Key("attachscreenshotforskip")
	@ConverterClass(StringToBooleanConverter.class)
	Boolean attachScreenshotForSkip();
	
}
