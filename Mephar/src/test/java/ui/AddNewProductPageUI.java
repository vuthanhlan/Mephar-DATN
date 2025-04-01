package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewProductPageUI {
    WebDriver driver;
    public AddNewProductPageUI(WebDriver driver) {this.driver = driver;}
    public WebElement getLinkProduct(){return driver.findElement(By.xpath("//span[contains(text(),'Sản phẩm')]"));}
    public WebElement getLinkListProduct(){return driver.findElement(By.xpath("//span[contains(text(),'Danh sách sản phẩm')]")); }
    public WebElement getButtonAddProduct(){return driver.findElement(By.xpath("//span[contains(text(),'Thêm mới')]/ancestor::button"));}
    public WebElement getLinkAddNewMedicine(){return driver.findElement(By.xpath("//span[contains(text(),'Thêm mới thuốc')]/parent::li"));}
    public WebElement getLinkAddNewMerchandise(){return driver.findElement(By.xpath("//span[contains(text(),'Thêm mới hàng hóa')]/parent::li"));}


    //Medicine
    public WebElement getTextMedicineName(){return driver.findElement(By.xpath("//span[contains(text(),'Nhập tên thuốc')]/parent::div"));}
    public WebElement getRouteOfUse(){return driver.findElement(By.xpath("//span[contains(text(),'Đường dùng')]/parent::div"));}
    public WebElement getSubRouteOfUse(){return driver.findElement(By.xpath("//div[contains(text(),'uống')]"));}

    //Merchandise
    public WebElement getTextMerchandiseName(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập tên hàng hóa')]"));}
    public WebElement getTextInventor(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Tồn kho')]"));}
    public WebElement getTextPacking(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Quy cách đóng gói')]"));}


    //Same
    public WebElement getTextImportPrice(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập giá vốn')]"));}
    public WebElement getTextSellingPrice(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập giá bán')]"));}
    public WebElement getTextBasicUnit(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập đơn vị cơ bản')]"));}
    public WebElement getTextCode() {return driver.findElement(By.xpath("//input[contains(@placeholder,'Mã hàng tự động')]"));}
    public WebElement getTextBarcode() {return driver.findElement(By.xpath("//input[contains(@placeholder,'Mã vạch tự động')]"));}
    public WebElement getTextSummaryName() {return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập tên viết tắt')]"));}

    public WebElement getTextGroup() {return driver.findElement(By.xpath("//span[contains(text(),'Nhóm sản phẩm')]/parent::div"));}
    public WebElement getSubGroup() {return driver.findElement(By.xpath("//div[contains(text(),'NHOM1')]"));}

    public WebElement getTextLocation() {return driver.findElement(By.xpath("//span[contains(text(),'Vị trí sản phẩm')]/parent::div"));}
    public WebElement getSubLocation() {return driver.findElement(By.xpath("//div[contains(text(),'TT2')]"));}

    public WebElement getTextWeight(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập trọng lượng')]"));}


    public WebElement getButtonAddUnit(){return driver.findElement(By.xpath("//div[contains(text(),'Thêm đơn vị')]/parent::div"));}

    public WebElement getButtonLoadImage(){return driver.findElement(By.xpath("//span[contains(text(),'Tải ảnh lên')]/parent::div/parent::div"));}

    public WebElement getButtonLuu(){return driver.findElement(By.xpath("//span[text()='Lưu']/parent::button"));}

    public WebElement getActualProductName(){return driver.findElement(By.xpath("//table//tr[2]/td[4]"));}
    public WebElement getActualInventor(){return driver.findElement(By.xpath("//table//tr[2]/td[7]"));}
    public WebElement getActualSellingPrice(){return driver.findElement(By.xpath("//table//tr[2]/td[9]"));}
}
