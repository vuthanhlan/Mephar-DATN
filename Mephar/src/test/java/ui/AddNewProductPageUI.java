package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewProductPageUI {
    WebDriver driver;
    public AddNewProductPageUI(WebDriver driver) {this.driver = driver;}
    public WebElement getButtonListProduct(){return driver.findElement(By.xpath("//span[contains(text(),'Danh sách sản phẩm')]")); }

}
