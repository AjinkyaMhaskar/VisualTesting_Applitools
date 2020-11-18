# Selenium WebDriver, BDD(Cucumber), Visual testing

## Tools:

- Eclipse
- Maven
- TestNG
- Selenium WebDriver
- Cucumber

## Maven dependencies: 
- Selenium WebDriver
- Cucumber
- TestNG
- Extent report

#### Application URLs:
##### V1 Branch
>https://demo.applitools.com/tlcHackathonMasterV1.html

##### Dev Branch with bugs
>https://demo.applitools.com/tlcHackathonDev.html

##### Production Branch
>https://demo.applitools.com/tlcHackathonMasterV2.html

## Features:

- Crisp & Clear maven folder structures
- CucumberOptions with detailed explanation of using "tags", "glue"
- Screenshots on failure feature in CucumberRunner class
- TestNG Annotations/hooks like "Before, "BeforeSuite", "AfterClass", "AfterMethod", "AfterSuit" etc.
- Descriptive pom.xml and testng.xml
- For visual testing, Integration with [APPLITOOLS](https://applitools.com/)
- Method to read data from configuration properties file
- Cross browser functionality implemented using [Applitools Ultrafast Grid](https://applitools.com/docs/topics/sdk/vg-configuration.html?Highlight=grid)

## BDD Style Development:

- Feature File - src.test.java.feature.Part1.feature
- Test Runner - src.test.java.runner.TestRunner.java
- Step Defination - src.test.java.seleniumgluecode.Part1.java
- Static data File - configs.Configurations.property

### Pre-requisite:

````
Navigate to dataProviders.ConfigFileReader.java, Edit getBaseURL & getMainPageTitle input attributes with respect to base URL.
```

### To Run: 

````
Navigate to testng.xml, Right-click and Run As "TestNG Suite".
```

### Cross Browser Devices and Emulator integration: 

````
- Chrome (1200 x 800)
- Firefox (1200 x 800)
- Edge Chromium (1200 x 800)
- Safari (1200 x 800)
- iPhone X
```

## Explanation:
Test script receive its data from the property file. teardown method is used after every script failure, Screen shots are recorder for every method under "\applitool\target\screenshots". Once the test execution finish, Admin should navigate to Applitools dash-board to review test results. 
