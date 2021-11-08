# Monefy
Monefy is a money management app. 
Appium is used to test Monefy.

The following are the dependencies needed to install Appium

    Node.js
    Java
    Appium Server
    Appium Client Libraries
    Selenium Libraries
    Android Studio
    Maven
    TestNG
    Then clone the repo: git clone https://github.com/hala-samir/Monefy.git
    Then after downloading the project and its depedancies of the maven file (pom.xml)
    Now we can run the test suite from a command line : mvn test

# Scenarios
  The automated scenarios here are the most used scenarios which have a business impact
  in case of failure with priority serious and high:
  
  ### Test cases:
      1. A user can CRUD income (Priority: serious).
      2. A user can CRUD expense (Priority: serious).
      3. A user can CRUD account (Priority: high).
      4. Settings (like changing language, changing categories' name, changing currency)(Priority: medium).
      5. Search (search field, search by date) (Priority: medium).
      6. Filter balance by day, by month or by year (Priority: medium).
      
  ### The possibilities of automating the selected test cases on different levels:
    The main test levels are unit testing, integration testing, system testing, and acceptance testing.
    We can here apply a test pyramid and its testing levels on automation 
    (E2E test, integration tests and unit tests).
    
    1. E2E testing: 
    
        E2E tests like the already implemented in this repo.
        
        Pros:
         - Mimic a real user action and his journey through the app.
         - Give indicatory for the app status.
         - Can be use for regression testing and smoke testing before releasing.
         
         Cons:
         - Slow execution.
         - Flakiness
         
    2. Integration testing:
    
        It can not be applied from the app itself or APK. APIs are required here to check how it
        works(checking APIs calls and responses) and calling between each other.
        
        Pros:
          - Fast execution. 
          - Keep an eye on data transfering and handing, so issues are exposed and easy to be cought.
          
        Cons:
          - It can not check the UI and can not mimic a user behaviour with the app., so we can not 
          depend only on it to check the app behavior.
          
    3. Unit testing:
         It can not be applied from the app itself or APK. Unit testing is responible for testing a single unit 
         or component of a software(like functions).
          
         Pros:
          - Provides better and clean code.
          - It helps to let a code be easy to refactor.
          
         Cons:
          - It can not check the UI and can not mimic a user behaviour with the app., so we can not 
          depend only on it to check the app behavior.
          
  
    
# The approach used in testing and  why this tech stack:
### Page Factory Model 
  The used approach here is page object model (POM) and page factory. POM can offer smooth handing. 
  If there are changes in UI have been done so, a tester will fix only the page object classes to updated
  the changed element instead of fixing a changed element in each test uses it(if POM is not used).
### Maven 
  Maven is also used to manage a project's build, reporting and documentation from a central piece
  of information and a project will be easy shared without having to lots of manual libararies downloading.
### Appium 
  Appium is an opensource mobile testing tool. It is a plateform independent so, it can be used on any machine
  and it does not need any enhancing in a tested application, so a developer does not need to customize his app. 
  to be tested by appium.
  Appium supported mini programming languages like Java, Javascript, C#, PHP, Python and Ruby.
  Appium can test native mobile apps, hybrid mobile apps and browser apps.
  Appium can be used with muliple framworks like data driven framwork and behavior driven.
        
        
        
  
    
