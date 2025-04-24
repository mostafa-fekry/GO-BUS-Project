package Listensers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(TestListeners.class);

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: " + result.getName());
        logger.error("Reason: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test ignored : " + result.getName());
    }
}


