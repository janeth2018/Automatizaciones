package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.Banistmo;
import utils.Utilities;


public class TestBanistmo {
    Banistmo homePag = new Banistmo();

    @BeforeMethod
    public void beforeMethod (){
        Utilities.openUrl("https://www.banistmo.com/wps/portal/banistmo/personas/");
    }

    @Test
    public void testLogInSuccessfully (){
        homePag.bN();
    }

    @AfterMethod
    public void afterMethod (){
        Utilities.closeExplorer();
        Utilities.closeProcess();
    }
}
