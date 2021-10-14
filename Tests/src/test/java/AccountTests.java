import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTests extends TestBase {
    HomeScreen homeScreen;
    AddAccountPage accountPage;
    TransactionsListPage transactionsPage;

    @Test
    public void addEditDeleteAccount()
    {
        homeScreen = new HomeScreen(driver);
        accountPage = new AddAccountPage(driver);
        transactionsPage = new TransactionsListPage(driver);
        String str1="Test";
        String str2="edit";

        //add new account
        homeScreen.clickSettings();
        homeScreen.clickAccountsPanel();
        homeScreen.clickAddAccount();
        accountPage.insertAccountName(str1);
        accountPage.insertInitialAmount("100");
        driver.hideKeyboard();
        accountPage.selectAccountImage();
        accountPage.clickAddBtn();
        homeScreen.waitForBalanceVisibility();

        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance $100.00");

        //edit the added account
        homeScreen.clickBalanceAmount();
        transactionsPage.clickTransaction();
        transactionsPage.clickExistingAmount();
        accountPage.insertAccountName(str2);
        accountPage.insertInitialAmount("50");
        accountPage.clickBackBtn();
        homeScreen.waitForBalanceVisibility();

        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance $50.00");
        Assert.assertEquals(transactionsPage.transactionCategory.getText(), "Balance 'edit'");

        //delete the added account
        transactionsPage.clickTransaction();
        transactionsPage.clickExistingAmount();
        accountPage.clickDeleteBtn();
        driver.switchTo().alert().accept();
        homeScreen.waitForBalanceVisibility();

        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance $0.00");

        tearDown();
    }
}
