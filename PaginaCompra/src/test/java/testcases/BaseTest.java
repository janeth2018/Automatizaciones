package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pom.HomePage;
import utils.Utilities;
import extentreports.ExtentTestManager;

public class BaseTest {
    public HomePage objHomePage;

    @BeforeMethod
    public void beforeMethod(){
        Utilities.openUrl("http://live.guru99.com/index.php");
        objHomePage = new HomePage();
    }

    @AfterMethod
    public void afterMethod(){
        Utilities.closeExplorer();
        Utilities.closeProcess();
        ExtentTestManager.endTest();
    }

}
