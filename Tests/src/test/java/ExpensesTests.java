import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class ExpensesTests extends TestBase {
    HomeScreen homeScreen;
    AddNewExpensesPage addExpensePage;
    TransactionsListPage transactionsPage;

    @Test(priority = 1)
    //add new expense
    public void addExpense() throws IOException {
        Android_setup();
        homeScreen = new HomeScreen(driver);
        addExpensePage = new AddNewExpensesPage(driver);
        homeScreen.clickAddExpense();
        addExpensePage.clickFiveBtn();
        addExpensePage.clickChooseCategoryBtn();
        addExpensePage.clickExpenseCategory();
        Assert.assertEquals(homeScreen.balanceAmount.getText(), "Balance -$5.00");
    }
    @Test(priority = 2, dependsOnMethods = {"addExpense"})
    //edit an added expense
    public void editExpense() {
        homeScreen = new HomeScreen(driver);
        addExpensePage = new AddNewExpensesPage(driver);
        transactionsPage = new TransactionsListPage(driver);
        homeScreen.waitForBalanceVisibility();
        homeScreen.clickBalanceAmount();
        transactionsPage.clickTransaction();
        transactionsPage.clickExistingAmount();
        addExpensePage.clearField();
        addExpensePage.clickNineBtn();
        addExpensePage.clickBackBtn();
        homeScreen.waitForBalanceVisibility();
        Assert.assertEquals(homeScreen.balanceAmount.getText(), "Balance -$9.00");
    }
    @Test(priority = 3, dependsOnMethods = {"addExpense", "editExpense"})
    //delete the added expense
    public void deleteExpense() {
        homeScreen = new HomeScreen(driver);
        addExpensePage = new AddNewExpensesPage(driver);
        transactionsPage = new TransactionsListPage(driver);
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
