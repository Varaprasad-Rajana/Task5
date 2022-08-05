package org.example.testCases;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.example.utilities.ReadConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @BeforeTest

    public void setup()
    {
        System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
        driver=new ChromeDriver();

        logger = Logger.getLogger("ebanking");
       // PropertyConfigurator.configure("log4j.properties");

    }
    @AfterTest
    public void tearDown() throws IOException {

        driver.quit();
    }
    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname +System.currentTimeMillis()+ ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot taken");
    }

        public String randomestring()
        {
            String generatedstring= RandomStringUtils.randomAlphabetic(8);
            return (generatedstring);
        }

        public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }
    }