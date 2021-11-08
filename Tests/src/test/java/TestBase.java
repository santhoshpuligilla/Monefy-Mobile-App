import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class TestBase {
    public  static AppiumDriver driver;
    String projectPath= System.getProperty("user.dir");
    @BeforeTest
    //desired capabilities are sent from a client to appium server
    public void Android_setup() throws IOException {
        DesiredCapabilities caps= new DesiredCapabilities();
        Properties prop= new Properties();
        InputStream inputStream= new FileInputStream(projectPath+"/src/test/config/config.properties");
        prop.load(inputStream);
        String app = prop.getProperty("app");
        caps.setCapability("platformName", prop.getProperty("app"));
        caps.setCapability("platformVersion", prop.getProperty("platformVersion"));
        caps.setCapability("deviceName",prop.getProperty("deviceName"));
        caps.setCapability("app",projectPath+"/APKS/com.monefy.app.lite_2021-09-27.apk");
        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

// close a driver after test
    @AfterClass
    public void tearDown()
    {
        if(null!=driver)
        {
            driver.quit();
        }
    }
}