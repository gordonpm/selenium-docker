package io.gordonpm.listener;

import io.gordonpm.tests.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot driver = (TakesScreenshot) result.getTestContext().getAttribute(Constants.DRIVER);
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)"); // scroll to bottom of the page so pagination is visible
        String screenshot = driver.getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat = "<img src='data:image/png;base64,%s' />";
        String htmlImage = String.format(htmlImageFormat, screenshot);
        Reporter.log(htmlImage);
    }
}
