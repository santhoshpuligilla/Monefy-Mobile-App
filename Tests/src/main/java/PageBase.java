import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    //class for page setting up and essential methods
    AppiumDriver driver;
    public static final long wait_duration= 10;

    public PageBase( AppiumDriver appiumDriver){

        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver),this);
        driver=appiumDriver;
    }

    public void waitElementVisibility(MobileElement element)
    {
        WebDriverWait wait=new WebDriverWait(driver,wait_duration);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clrTextField(MobileElement element)
    {
        waitElementVisibility(element);
        element.clear();
    }

    public void clickBtn(MobileElement element)
    {
        waitElementVisibility(element);
        element.click();
    }

    public void fillTxtField(MobileElement element, String txt)
    {
        waitElementVisibility(element);
        element.sendKeys(txt);
    }
}