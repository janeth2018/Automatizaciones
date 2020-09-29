package pom;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import extentreports.ExtentTestManager;
import org.openqa.selenium.By;
import utils.Utilities;

public class HomePage {
    private final By TV = By.linkText("TV");
    private final By ADDTOCART = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span");
    private final By COUNTRY = By.name("country_id");
    private final By STATE = By.name("region");

    public HomePage homePage(String strCountry, String strState, ExtentTest objTestReport){
        Utilities.click(TV);
        Utilities.wt(2000);
        Utilities.click(ADDTOCART);
        Utilities.wt(2000);
        Utilities.select(COUNTRY, strCountry);
        Utilities.wt(2000);
        Utilities.type(STATE, strState);

        Utilities.wt(2000);

        if (Utilities.isElementPresent(TV)){
            objTestReport.log(LogStatus.PASS, "HomePage test passed",
                    ExtentTestManager.getTest().addBase64ScreenShot(Utilities.base64Screenshot()));
        }
        return this;
    }
}