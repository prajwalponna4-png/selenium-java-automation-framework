package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    static ExtentReports extent;
    static ExtentTest test;

    public static void createTest(String testName) {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        test = extent.createTest(testName);
    }

    public static void log(String message) {
        test.info(message);
    }

    public static void flushReport() {
        extent.flush();
    }
}