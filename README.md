# SeleniumTestNGframeworkByme
This is an automation testing framework using TestNG Selenium4 Log4j.
It is reusable for any website.
Now I am mainly using it to test an website under development.
Website under development is "https://www.aspiringtester.com (developing myself using php,html,css,bootstraps).
EXTENT REPORTING has been included in addition to normal testNG reporting.
SCREEN SHOT mechanism has been worked out in such a way that screen shot of failed case will be attached to the html extent report.
Logging has been included using log4j . I am still working on that.I will extend this to send an automatic log-report to the mentioned email id.
In this framework PageObject model is used.So far, only contact page object is created.But in future each page object will be created to test the website end to end.
Here data driven testing mechanism using testNG @DataProvider is used for contact page.
here one test case is set to fail to check that the testing framework is working.
My aim is to use this framework for regression testing conituously as I am making lots of changes in this website at the moment.
In future this framework can be used for any website after making small changes regarding the relevant webElements and web pages.
