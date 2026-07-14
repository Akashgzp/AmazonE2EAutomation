package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;

import reports.ExtentManager;
import utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getExtentReport();

    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Execution Started");

    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String path = ScreenshotUtils.captureScreenshot(
                result.getMethod().getMethodName());

        try {

            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("Report Generated");

    }

}