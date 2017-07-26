package com.stc.roster.po;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import reporting.ExtentUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseSetup {


    public WebDriver driver;
    private static String chromedriverPath = "chromedriver.exe";
    private static String geckodriverPath = "geckodriver.exe";


    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src//main//properties//Properties.prop");

        prop.load(fis);
        String appURL = prop.getProperty("HOST");
        String browserType = prop.getProperty("BROWSERTYPE");

        if (browserType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromedriverPath);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver = new ChromeDriver(capabilities);
        } else if (browserType.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", geckodriverPath);
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
//        ExtentUtil.fetchTest().log(Status.INFO,  browserType + " is launching");
        driver.get(appURL);
        return driver;
    }

    public void takeScreenshot() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("TestScreenshots");

        prop.load(fis);
        String ssloc = prop.getProperty("SCREENSHOT");
        File srcImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(srcImage,new File(ssloc));
        ExtentUtil.fetchTest().addScreenCaptureFromPath(ssloc);
    }
}
