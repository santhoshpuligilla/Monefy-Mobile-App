import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddNewAccountPage extends PageBase{

    public AddNewAccountPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    @AndroidFindBy(id="editTextCategoryName")
    AndroidElement accountNameField;

    public void enterAccountName(String name)
    {
        clrTextField(accountNameField);
        fillTxtField(accountNameField,name);
    }


}
