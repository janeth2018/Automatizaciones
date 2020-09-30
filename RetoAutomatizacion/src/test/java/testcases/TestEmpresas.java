package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.Empresas;
import utils.Utilities;

public class TestEmpresas {
    Empresas homePag = new Empresas();

    @BeforeMethod
    public void beforeMethod (){
        Utilities.openUrl("https://www.banistmo.com/wps/portal/banistmo/personas/");
    }

    @Test
    public void testLogInSuccessfully (){
        homePag.eP();
    }

    @AfterMethod
    public void afterMethod (){
        Utilities.closeExplorer();
        Utilities.closeProcess();
    }
}
