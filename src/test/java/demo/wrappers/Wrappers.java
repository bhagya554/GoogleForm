package demo.wrappers;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Wrappers {
   
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

    public static void clickOnDropDown(WebElement ele){
        try{
            ele.click();
        }
        catch(Exception e){
            System.out.println("Unble to click on drop down ele: " + ele);
        }
    }

     public static void selectValueFromDropDown(List<WebElement> addressingValues,String dropDownTxt){
        for(WebElement drop:addressingValues){
            if(drop.getText().equals(dropDownTxt)){
                drop.click();
                break;
            }
        }
     }

     public static String currentDateMinus7(){
        LocalDateTime dateMinus7 = LocalDateTime.now().minusDays(7);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = dateMinus7.format(myFormatObj);
        System.out.println("Date minus 7: " + formattedDate);
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

    public static boolean handleAlert(ChromeDriver driver){
        boolean status = false;
        driver.switchTo().alert().dismiss();
        status=true;
        return status;
    }
}
