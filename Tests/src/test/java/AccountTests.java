import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTests extends TestBase {
    HomeScreen homeScreen;
    AddAccountPage accountPage;
    TransactionsListPage transactionsPage;
    String str1="Test";
    String str2="edit";

    @Test(priority = 1)
    //add new account
    public void addAccount() {
        homeScreen = new HomeScreen(driver);
        accountPage = new AddAccountPage(driver);
        transactionsPage = new TransactionsListPage(driver);
        homeScreen.clickSettings();
        homeScreen.clickAccountsPanel();
        homeScreen.clickAddAccount();
        accountPage.insertAccountName(str1);
        accountPage.insertInitialAmount("100");
        driver.hideKeyboard();
        accountPage.selectAccountImage();
        accountPage.clickAddBtn();
        homeScreen.waitForBalanceVisibility();
        Assert.assertEquals(homeScreen.balanceAmount.getText(), "Balance $100.00");
    }
    @Test(priority = 2, dependsOnMethods = {"addAccount"})
    //edit the added account
    public void editAccount() {
        homeScreen.clickBalanceAmount();
        transactionsPage.clickTransaction();
        transactionsPage.clickExistingAmount();
        accountPage.insertAccountName(str2);
        accountPage.insertInitialAmount("50");
        accountPage.clickBackBtn();
        homeScreen.waitForBalanceVisibility();
        Assert.assertEquals(homeScreen.balanceAmount.getText(), "Balance $50.00");
        Assert.assertEquals(transactionsPage.transactionCategory.getText(), "Balance 'edit'");
    }
    @Test(priority = 3, dependsOnMethods = {"addAccount","editAccount"})
    //delete the added account
    public void deleteAccount() {
        transactionsPage.clickTransaction();
        transactionsPage.clickExistingAmount();
        accountPage.clickDeleteBtn();
        driver.switchTo().alert().accept();
        homeScreen.waitForBalanceVisibility();
        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance $0.00");
        tearDown();
    }
}
