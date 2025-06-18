package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

    //  WebDriver driver;
    //  public Wrappers(WebDriver driver){
    //     this.driver = driver;
    //  }
     public static void enterText(WebElement ele,String text){
        try{
            ele.clear();
            ele.sendKeys(text);
        }
        catch(Exception e)
        {
            System.out.println("Exception in entering text to : " + ele + "with text as :" + text);
        }
     }

     public static String getEpochTime(){
        long epoch = System.currentTimeMillis()/1000; //Returns epoch in seconds
        String epochTime = String.valueOf(epoch);
        return epochTime;
     }

     public static void clickOnRadioBtn(List<WebElement> radioBtns,String radioBtnName){
        try{
        for(WebElement radio:radioBtns){
            //We can use parameterized xpath as well: //span[contains(text(),'"+radioBtnName+"')]
            if(radio.getText().equals(radioBtnName)){
                radio.click();
                break;
            }
        }
    }
    catch(Exception e){
        System.out.println("Unable  to click on radio button");
    }
     }

     public static void clickOnCheckboxes(List<WebElement> checkboxes, String checkBoxName){
       try{
        for(WebElement checkbox:checkboxes){
        if(checkbox.getText().equals(checkBoxName)){
            checkbox.click();
        }
       }
    }
    catch(Exception e){
        System.out.println("Unable to click on checkbox");
    }
     }

     public static void clickOnCheckboxesUsingXpath(WebElement checkboxeEle){
        try{
         
            checkboxeEle.click();       
           }
     catch(Exception e){
         System.out.println("Unable to click on checkbox");
     }
      }

     public static void selectValueFromDropDown(WebElement ele,String dropDownValue){

     }

     public static String currentDateMinus7(){
        LocalDateTime dateMinus7 = LocalDateTime.now().minusDays(7);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = dateMinus7.format(myFormatObj);
    return formattedDate;
    }

    public static void clickOnBtn(WebElement ele){
        try{
        ele.click();
        }
        catch(Exception e){
            System.out.println("Unable to click on button");;
        }
    }

}
