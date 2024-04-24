package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addUserTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qausersignup.ccbp.tech/");
        WebElement name = driver.findElement(By.cssSelector("input#name"));
        name.sendKeys("rahul");
        WebElement email = driver.findElement(By.cssSelector("input#email"));
        email.sendKeys("rahul@example.com");
        WebElement submit = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submit.submit();
        WebElement successPara = driver.findElement(By.cssSelector("p[id ^= 'success']"));
        String currentPara = successPara.getText();
        String expectedPara = "New user added successfully!";
        if (currentPara.equals(expectedPara)){
            System.out.println("Success Message Displayed");
        }else {
            System.out.println("Success Message Missing");
        }
        WebElement clear = driver.findElement(By.cssSelector("span[id ^= 'clear']"));
        clear.click();
        submit.click();
        WebElement emailRequired = driver.findElement(By.cssSelector("p[id ^= 'name']"));
        String errorText1 = emailRequired.getText();
        WebElement nameRequired = driver.findElement(By.cssSelector("p[id ^= 'email']"));
        String errorText2 = nameRequired.getText();
        String errorMsg = "Required*";
        if (errorText1.equals(errorMsg) && errorText2.equals(errorMsg)){
            System.out.println("Errors displayed correctly");
        }else {
            System.out.println("Errors not displayed correctly");
        }
        driver.quit();
    }
}
