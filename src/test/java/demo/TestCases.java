package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation.
     * Follow `testCase01` `testCase02`... format or what is provided in
     * instructions
     */

    @Test
    public void testCase01() throws InterruptedException {
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameElement=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[1]"))));
        Wrappers.enterText(nameElement, "Crio Learner");
        String epochTime = Wrappers.getEpochTime();
        String message = "I want to be the best QA Engineer! " + epochTime;
        System.out.println(message);
        WebElement whyUPracticeAutomation=driver.findElement(By.xpath("//textarea"));
        Wrappers.enterText(whyUPracticeAutomation, message);
        List<WebElement> allRadioExperiences=driver.findElements(By.xpath("//div[@class='SG0AAe']//span[@dir='auto']"));
        //0 - 2,3 - 5,6 - 10,> 10 
        Wrappers.clickOnRadioBtn(allRadioExperiences, "> 10");
         
        String[] checkBoxText={"Java","Selenium","TestNG"};
        for(int i=0;i<checkBoxText.length;i++){
            WebElement checkbox= driver.findElement(By.xpath("//span[text()='"+checkBoxText[i]+"']"));
            Wrappers.clickOnCheckboxesUsingXpath(checkbox);
        }
        
        
        // Wrappers.clickOnCheckboxes(checkbox, "Selenium");
        // Wrappers.clickOnCheckboxes(checkbox, "TestNG");
        // for(WebElement e: checkbox){
        //     String eleText = e.getText();
        //     if(eleText.equalsIgnoreCase("Java")||eleText.equalsIgnoreCase("Selenium")||eleText.equalsIgnoreCase("TestNG")){
        //         e.click();
        //     }
        // }
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox'][@jsname='W85ice']")));
        dropdown.click();
     
        // Wait for the "Ms" option to be visible and click it
        WebElement msOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option'][@data-value='Ms']")));
        msOption.click();
     //xpath with not contains - //div[contains(@class,'ncFHed')]//span[not(contains(text(),'Choose'))]
     ////div[contains(@class,'ncFHed')]
        
        // WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox'][@jsname='W85ice']")));
        // Wrappers.clickOnDropDown(dropdown);
     

        // // Wait for the "Ms" option to be visible and click it
        // List<WebElement> allDropdownValues=driver.findElements(By.xpath("//div[contains(@class,'ncFHed')]//span[not(contains(text(),'Choose'))]"));
        // Wrappers.selectValueFromDropDown(allDropdownValues,"Ms");
        //WebElement msOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option'][@data-value='Ms']")));
        //msOption.click();
        
        Thread.sleep(5000);
     // Get current date minus 7 days dynamically
        String formattedDate=Wrappers.currentDateMinus7();
        // Enter date
        WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));
        dateField.sendKeys(formattedDate);
        System.out.println(dateField);
     
        // Enter time 07:30
        WebElement hourField = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebElement minuteField = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        
        Wrappers.enterText(hourField, "7");
        Wrappers.enterText(minuteField, "30");
        // Enter "7" in the Hour field
        //hourField.sendKeys("7");
     
        // Enter "30" in the Minute field
        // minuteField.sendKeys("30");
        //amPmDropdown.click();
     
        // Submit the form
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Submit')]"))));
        Wrappers.clickOnBtn(submitButton);
        //submitButton.click();
     
        // Wait and capture success message
        WebElement successMessage = driver
                .findElement(By.xpath("//div[contains(text(),'Thanks for your response, Automation Wizard!')]"));
     
        if (successMessage.isDisplayed()) {
            System.out.println("Form submitted successfully! Message: " + successMessage.getText());
        }
     

    }

    /*
     * Do not change the provided methods unless necessary, they will help in
     * automation and assessment
     */
    @BeforeTest
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest() {
        driver.close();
        driver.quit();

    }
}