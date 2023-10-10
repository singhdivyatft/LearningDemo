import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumPrac {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.get("https://demo.guru99.com/test/login.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void login(){
        WebElement user=driver.findElement(By.xpath("//input[@id='email']"));
        user.sendKeys("demo@gmail.com");
        WebElement pass=driver.findElement(By.xpath("//input[@id='passwd']"));
        pass.sendKeys("Dfgyy@233");
//        WebElement checkBox=driver.findElement(By.className("recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox"));
//        checkBox.click();
        WebElement login=driver.findElement(By.id("SubmitLogin"));
        login.click();
        WebElement text=driver.findElement(By.xpath("//div[@class=\"error-copy\"]"));
        System.out.println("login message:- "+text.getText());
        Assert.assertEquals("Successfully Logged in...",text.getText());

    }
    @AfterMethod
    public void end(){
        driver.quit();
    }
}
