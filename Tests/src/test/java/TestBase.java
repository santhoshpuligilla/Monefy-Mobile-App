import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public  static AppiumDriver driver;
    @BeforeTest
    //desired capabilities are sent from a client to appium server
    public void Android_setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("deviceName","AndroidEmulator");
        caps.setCapability("app",System.getProperty("user.dir")+"/APKS/com.monefy.app.lite_2021-09-27.apk");
        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

// close a driver after test
    @AfterTest
    public void tearDown()
    {
        if(null!=driver)
        {
            driver.quit();
        }
    }
}