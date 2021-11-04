import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class ExpensesTests extends TestBase {
    HomeScreen homeScreen;
    AddNewExpensesPage addExpensePage;
    TransactionsListPage transactionsPage;

    @Test
    public void addEditDeleteExpense() throws IOException {
        Android_setup();
        homeScreen = new HomeScreen(driver);
        addExpensePage = new AddNewExpensesPage(driver);
        transactionsPage = new TransactionsListPage(driver);
        //add new expense
        homeScreen.clickAddExpense();
        addExpensePage.clickFiveBtn();
        addExpensePage.clickChooseCategoryBtn();
        addExpensePage.clickExpenseCategory();
        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance -$5.00");
        //edit an added expense
        homeScreen.waitForBalanceVisibility();
        homeScreen.clickBalanceAmount();
        transactionsPage.clickTransaction();
        transactionsPage.clickExistingAmount();
        addExpensePage.clearField();
        addExpensePage.clickNineBtn();
        addExpensePage.clickBackBtn();
        homeScreen.waitForBalanceVisibility();
        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance -$9.00");
        //delete the added expense
        transactionsPage.clickTransaction();
        transactionsPage.clickExistingAmount();
        addExpensePage.clickDeleteBtn();
        homeScreen.waitForBalanceVisibility();
        homeScreen.clickBalanceAmount();
        homeScreen.waitForBalanceVisibility();
        Assert.assertEquals(homeScreen.balanceAmount.getText(),"Balance $0.00");
        tearDown();
    }
}
