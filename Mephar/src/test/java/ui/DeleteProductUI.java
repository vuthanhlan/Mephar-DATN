package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteProductUI {
    WebDriver driver;
    public DeleteProductUI(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getDelete() { return driver.findElement(By.xpath("(//span[contains(text(),'Xoá')])[2]/parent::button"));}

}
