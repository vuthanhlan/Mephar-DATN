package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AddNewProductPageUI;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class AddNewMerchandiseAction {
    WebDriver driver;
    AddNewProductPageUI addNewProductPageUI;

    public AddNewMerchandiseAction(WebDriver driver) {
        this.driver = driver;
        addNewProductPageUI = new AddNewProductPageUI(driver);
    }
    public void navigateToAddNewMerchandisePage() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addNewProductPageUI.getLinkProduct().click();
        addNewProductPageUI.getLinkListProduct().click();
        addNewProductPageUI.getButtonAddProduct().click();
//        wait.until(ExpectedConditions.elementToBeClickable(addNewProductPageUI.getButtonAddProduct())).click();
        Thread.sleep(1000);
        addNewProductPageUI.getLinkAddNewMerchandise().click();
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
    public void inputAllData(String code, String Barcode, String Name, String SummaryName, int ImportPrice, int sellingPrice, float weight, String Packing, int inventor, String Unit) throws InterruptedException {
        addNewProductPageUI.getTextCode().sendKeys(code);
        Thread.sleep(1000);
        addNewProductPageUI.getTextBarcode().sendKeys(Barcode);
        Thread.sleep(1000);
        addNewProductPageUI.getTextMerchandiseName().sendKeys(Name);
        addNewProductPageUI.getTextSummaryName().sendKeys(SummaryName);
        addNewProductPageUI.getTextGroup().click();
        addNewProductPageUI.getSubGroup().click();
        addNewProductPageUI.getTextImportPrice().sendKeys(String.valueOf(ImportPrice));
        addNewProductPageUI.getTextSellingPrice().sendKeys(String.valueOf(sellingPrice));
        addNewProductPageUI.getTextWeight().sendKeys(String.valueOf(weight));
        addNewProductPageUI.getTextPacking().sendKeys(Packing);
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
