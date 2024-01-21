package reporting;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ReportLogger {

    public static void pass(String log) {
        ExtentTestManager.getExtentTest().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void fail(String log) {
        ExtentTestManager.getExtentTest().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void info(String log) {
        ExtentTestManager.getExtentTest().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }

    public static void warning(String log) {
        ExtentTestManager.getExtentTest().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }
}
