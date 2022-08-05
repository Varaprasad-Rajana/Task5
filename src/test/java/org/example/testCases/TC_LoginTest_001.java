package org.example.testCases;

import org.example.pageObjects.LoginPage;
import org.example.utilities.ReadXLSdata;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseTest {
    @Test(dataProvider = "signindata",dataProviderClass = ReadXLSdata.class)
    public void loginTestWithDP(String username, String password) throws IOException {
        System.out.println("username :::::"+username+":::Password::::"+password);
        driver.get(baseURL);
        logger.info("URL is opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEnterUserName(username);
       logger.info("Entered username");
        loginPage.setEnterPassword(password);
       logger.info("Entered password");

           loginPage.clickSubmit();
if(isAlertPresent()){
    driver.switchTo().alert().accept();

}

           if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
               Assert.assertTrue(true);
               logger.info("Login test passed");
           } else {
               captureScreen(driver, "loginTest_");
               Assert.assertTrue(false);
               logger.info("Login test failed");
           }

    }

public boolean isAlertPresent(){
        try{
          driver.switchTo().alert();
          return  true;
        }catch (NoAlertPresentException noAlertPresentException){
            return  false;
        }
}


}
