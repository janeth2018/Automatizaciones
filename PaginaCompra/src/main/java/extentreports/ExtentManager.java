package extentreports;

import com.relevantcodes.extentreports.ExtentReports;
import utils.Utilities;

public class ExtentManager {

    public static ExtentReports extent;

    public static synchronized ExtentReports getReporter() {

        if (extent == null) {
            String strWorkingDir = System.getProperty("user.dir");
            extent = new ExtentReports(strWorkingDir + "/ExtentReports/ReportResults" +
                    Utilities.getDateYYYYMMDDHHMMSS() + ".html", true);
        }

        return extent;
    }
}
