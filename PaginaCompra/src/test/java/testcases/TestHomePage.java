package testcases;

import com.relevantcodes.extentreports.ExtentTest;
import extentreports.ExtentTestManager;
import org.testng.annotations.Test;
import pom.HomePage;

public class TestHomePage extends BaseTest{
    public HomePage objHomePage = new HomePage();

    @Test
    public void test (){
        ExtentTest objTestReport = ExtentTestManager.startTest("Abrir Página", "Abrir Página");
        objHomePage.homePage("Colombia", "Medellin", objTestReport);
        ExtentTestManager.endTest();
    }

}