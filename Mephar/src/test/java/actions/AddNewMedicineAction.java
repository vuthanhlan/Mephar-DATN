package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.AddNewProductPageUI;
import ui.NavigatePageUI;

import java.time.Duration;

public class AddNewMedicineAction {
    WebDriver driver;
    AddNewProductPageUI addNewProductPageUI;
    NavigatePageUI navigatePageUI;

    public AddNewMedicineAction(WebDriver driver) {
        this.driver = driver;
        this.addNewProductPageUI = new AddNewProductPageUI(driver);
        this.navigatePageUI = new NavigatePageUI(driver);
    }
    public void navigateToAddNewMedicinePage() throws InterruptedException {

        navigatePageUI.getLinkProduct().click();
        navigatePageUI.getLinkListProduct().click();
        navigatePageUI.getButtonAddProduct().click();
//        wait.until(ExpectedConditions.elementToBeClickable(addNewProductPageUI.getButtonAddProduct())).click();
        Thread.sleep(1000);
        navigatePageUI.getLinkAddNewMedicine().click();

    }
    public void inputData(String code, String Barcode, String Name, String SummaryName,String group,String RouteOfUse,String location, String ImportPrice, String sellingPrice, String weight, String Unit) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addNewProductPageUI.getTextCode().sendKeys(code);
        addNewProductPageUI.getTextBarcode().sendKeys(Barcode);
        addNewProductPageUI.getTextMedicineName().click();
        WebElement MedicineName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+Name+"')]/parent::div")));
        MedicineName.click();

        addNewProductPageUI.getTextSummaryName().sendKeys(SummaryName);
        addNewProductPageUI.getTextGroup().click();
        WebElement SubGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+group+"')]")));
        SubGroup.click();

        addNewProductPageUI.getRouteOfUse().click();
        WebElement RoutOfUse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+RouteOfUse+"')]")));
        RoutOfUse.click();

        addNewProductPageUI.getTextLocation().click();
        WebElement SubLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+location+"')]")));
        SubLocation.click();
        addNewProductPageUI.getTextImportPrice().sendKeys(String.valueOf(ImportPrice));
        addNewProductPageUI.getTextSellingPrice().sendKeys(String.valueOf(sellingPrice));
        addNewProductPageUI.getTextWeight().sendKeys(String.valueOf(weight));
        addNewProductPageUI.getTextBasicUnit().sendKeys(Unit);

    }

    public void clickButtonLuu(){
        addNewProductPageUI.getButtonLuu().click();
    }
}
