package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ExtentReportManager;
import reporting.ExtentTestManager;

import java.io.File;

public class Listeners implements ITestListener {

    private String reportPath = System.getProperty("user.dir")+ File.separator+ "reports"+File.separator+
            ExtentReportManager.getReportNameWithTimeStamp();
    private static ExtentReports extentReports;

    public void onStart(ITestContext context) {
        extentReports = ExtentReportManager.createReport(reportPath,"API Report","Test Report");
    }

    public void onFinish(ITestContext context) {
        if(extentReports!=null)
            extentReports.flush();
    }

    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extentReports.createTest(result.getTestClass().getName()+"-"+result.getMethod().getMethodName());
        ExtentTestManager.setExtentTest(extentTest);
    }

}
