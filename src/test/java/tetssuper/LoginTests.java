package tetssuper;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.SplashScreen;

public class LoginTests extends Configuration {

    @Test
    public void registrationSuccess(){
        int index = (int) (System.currentTimeMillis()/1000)%3600;


        boolean isRegistrationSuccess = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("wick" + index + "@mail.com")
                .fillPassword("Ww12345$")
                .clickLoginButton()
                .skipWizard()
                .isPlusButtonPresent();

        Assert.assertTrue(isRegistrationSuccess);
    }

    @Test
    public void loginSuccess(){

        boolean isLoginSuccess = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("wick@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginButton()
                .skipWizard()
                .isPlusButtonPresent();

        Assert.assertTrue(isLoginSuccess);


    }

    @AfterMethod
    public void postCondition(){
        new HomeScreen(driver)
                .openMenu()
                .logOut()
                .isLoginButtonPresent();



    }
}
