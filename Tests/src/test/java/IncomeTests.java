import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class IncomeTests extends TestBase {
    HomeScreen homeScreen;
    AddNewIncomePage addIncomePage;
    TransactionsListPage transactionsPage;

    @Test
    public void addEditDeleteIncome() throws IOException {
        Android_setup();
        homeScreen = new HomeScreen(driver);
        addIncomePage = new AddNewIncomePage(driver);
        transactionsPage = new TransactionsListPage(driver);
        //add new income
        homeScreen.clickAddIncome();
        addIncomePage.clickFiveBtn();
        addIncomePage.clickChooseCategoryBtn();
        addIncomePage.clickDepositsCategory();
        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance $5.00");
        //edit the added income
        homeScreen.waitForBalanceVisibility();
        homeScreen.clickBalanceAmount();
        transactionsPage.clickTransaction();
        transactionsPage.clickExistingAmount();
        addIncomePage.clearField();
        addIncomePage.clickNineBtn();
        addIncomePage.clickBackBtn();
        homeScreen.waitForBalanceVisibility();
        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance $9.00");
        //delete the added income
        transactionsPage.clickTransaction();
        transactionsPage.clickExistingAmount();
        addIncomePage.clickDeleteBtn();
        homeScreen.clickBalanceAmount();
        homeScreen.waitForBalanceVisibility();
        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance $0.00");
        tearDown();
    }
}
