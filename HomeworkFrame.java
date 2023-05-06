package abc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeworkFrame {
    WebDriver driver;
    @Test(priority = 1)
    void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test(priority = 2)
    void computer() {
        //Select the computer link
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
    }
    @Test(priority = 3)
    void desktop() {

        //Select the desktop link
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();
        //Select the item
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a/img")).click();
    }

    @Test(priority = 4)
    void cart() {
        driver.findElement(By.id("add-to-cart-button-3")).click();
        WebElement title = driver.findElement(By.id("add-to-cart-button-3"));
        Assert.assertTrue(title.isDisplayed(), "product added ");
    }
    @Test(priority = 5)
    void shopping() {
        driver.findElement(By.className("cart-label")).click();
        driver.findElement(By.className("qty-input")).clear();
    }
    @Test(priority = 6)
    void update() {
        driver.findElement(By.className("qty-input")).sendKeys("3");
        driver.findElement(By.xpath("//*[@id=\"updatecart\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();
        driver.findElement(By.id("checkout")).click();
    }
    @Test(priority = 7)
    void guest() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }
    @Test(priority = 8)
    void shipment() throws InterruptedException {
        driver.findElement(By.id("ShipToSameAddress")).click();
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_FirstName\"]")).sendKeys("Hiral");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_LastName\"]")).sendKeys("Patel");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Email\"]")).sendKeys("hiral123@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]")).sendKeys("United Kingdom");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]")).sendKeys("London");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]")).sendKeys("2,Bancroft Road");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]")).sendKeys("HA2 5ND");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]")).sendKeys("08976856477");
        driver.findElement(By.name("save")).click();

    }
    @Test(priority = 9)
    void shippingMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/button[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("method-name")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 10)
    void paymentMethod() throws InterruptedException {
        driver.findElement(By.id("paymentmethod_1")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"CreditCardType\"]")).sendKeys("visa");
        driver.findElement(By.xpath("//*[@id=\"CardholderName\"]")).sendKeys("H patel");
        Thread.sleep(1000);
        driver.findElement(By.id("CardNumber")).sendKeys("4659446678073231");
        Thread.sleep(3000);
        driver.findElement(By.id("ExpireMonth")).sendKeys("2");
        driver.findElement(By.xpath("//*[@id=\"ExpireYear\"]")).sendKeys("2024");
        driver.findElement(By.xpath("//*[@id=\"CardCode\"]")).sendKeys("453");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 11)
    void confirmOrder() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();
        Thread.sleep(3000);
        driver.close();
    }

}



