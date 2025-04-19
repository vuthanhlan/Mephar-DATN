package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AddNewProductPageUI;
import ui.NavigatePageUI;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class AddNewMerchandiseAction {
    WebDriver driver;
    AddNewProductPageUI addNewProductPageUI;
    NavigatePageUI navigatePageUI;

    public AddNewMerchandiseAction(WebDriver driver) {
        this.driver = driver;
        addNewProductPageUI = new AddNewProductPageUI(driver);
        navigatePageUI = new NavigatePageUI(driver);
    }
    public void navigateToAddNewMerchandisePage() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navigatePageUI.getLinkProduct().click();
        navigatePageUI.getLinkListProduct().click();
        navigatePageUI.getButtonAddProduct().click();
//        wait.until(ExpectedConditions.elementToBeClickable(addNewProductPageUI.getButtonAddProduct())).click();
        Thread.sleep(1000);
        navigatePageUI.getLinkAddNewMerchandise().click();
    }
    public void inputRequireData(String MerchandiseName, int sellingPrice, int inventor, String Unit) {
        addNewProductPageUI.getTextMerchandiseName().sendKeys(MerchandiseName);
        addNewProductPageUI.getTextSellingPrice().sendKeys(String.valueOf(sellingPrice));
        addNewProductPageUI.getTextInventor().sendKeys(String.valueOf(inventor));
        addNewProductPageUI.getTextBasicUnit().sendKeys(Unit);

    }
    public void loadImage() throws AWTException {
        // Click vào nút "Tải ảnh lên"
        addNewProductPageUI.getButtonLoadImage().click();

        // Copy đường dẫn file vào clipboard
        String filePath = "C:\\Users\\Vu Thanh Lan\\Downloads\\background\\anh24.jpg";
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot = new Robot();

        // Nhấn Ctrl + V để dán đường dẫn file
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Nhấn Enter để chọn file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }



    public void inputData(String code, String Barcode, String Name, String SummaryName,String group,String location, String ImportPrice, String sellingPrice, String weight, String Packing,String brand,String country, String inventor, String Unit) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addNewProductPageUI.getTextCode().sendKeys(code);
        addNewProductPageUI.getTextBarcode().sendKeys(Barcode);
        addNewProductPageUI.getTextMerchandiseName().sendKeys(Name);
        addNewProductPageUI.getTextSummaryName().sendKeys(SummaryName);
        addNewProductPageUI.getTextGroup().click();
        WebElement SubGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+group+"')]")));
        SubGroup.click();
        addNewProductPageUI.getTextLocation().click();
        WebElement SubLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+location+"')]")));
        SubLocation.click();

        addNewProductPageUI.getTextImportPrice().sendKeys(String.valueOf(ImportPrice));
        addNewProductPageUI.getTextSellingPrice().sendKeys(String.valueOf(sellingPrice));
        addNewProductPageUI.getTextWeight().sendKeys(String.valueOf(weight));
        addNewProductPageUI.getTextPacking().sendKeys(Packing);
        addNewProductPageUI.getTextBrand().click();
        WebElement SubBrand = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@title,'"+brand+"')]")));
        SubBrand.click();

        addNewProductPageUI.getTextManufacturingCountry().click();
        WebElement SubCountry = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+country+"')]")));
        SubCountry.click();
        addNewProductPageUI.getTextInventor().sendKeys(String.valueOf(inventor));
        addNewProductPageUI.getTextBasicUnit().sendKeys(Unit);

    }
    public void clickButtonLuu(){
        addNewProductPageUI.getButtonLuu().click();
    }

//    public void setAddNewMerchandiseWithRequiredFields(){
//        navigateToAddNewMerchandisePage();
//        inputRequireData("Thuốc dạ dày",25000,1500,"vỉ");
//        clickButtonLuu();
//    }
}
