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
    public WebElement getSubMedicineName(String Name){return driver.findElement(By.xpath("//div[contains(text(),'"+Name+"')]/parent::div"));}
    public WebElement getRouteOfUse(){return driver.findElement(By.xpath("(//span[contains(text(),'Đường dùng')])[2]/parent::div"));}
    public WebElement getSubRouteOfUse(String RouteOfUse){return driver.findElement(By.xpath("//div[contains(text(),'"+RouteOfUse+"')]"));}


    //Merchandise
    public WebElement getTextMerchandiseName(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập tên hàng hóa')]"));}
    public WebElement getTextInventor(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Tồn kho')]"));}
    public WebElement getTextPacking(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Quy cách đóng gói')]"));}
    public WebElement getTextBrand(){return driver.findElement(By.xpath("//span[contains(text(),'Nhập tên hãng')]/parent::div"));}
    public WebElement getSubRouteBrand(String brand){return driver.findElement(By.xpath("//div[contains(@title,'"+brand+"')]"));}
    public WebElement getTextManufacturingCountry(){return driver.findElement(By.xpath("//span[contains(text(),'Nhập tên nước')]/parent::div"));}
    public WebElement getSubManufacturingCountry(String country){return driver.findElement(By.xpath("//div[contains(text(),'"+country+"')]"));}

    //Same
    public WebElement getTextImportPrice(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập giá vốn')]"));}
    public WebElement getTextSellingPrice(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập giá bán')]"));}
    public WebElement getTextBasicUnit(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập đơn vị cơ bản')]"));}
    public WebElement getTextCode() {return driver.findElement(By.xpath("//input[contains(@placeholder,'Mã hàng tự động')]"));}
    public WebElement getTextBarcode() {return driver.findElement(By.xpath("//input[contains(@placeholder,'Mã vạch tự động')]"));}
    public WebElement getTextSummaryName() {return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập tên viết tắt')]"));}

    public WebElement getTextGroup() {return driver.findElement(By.xpath("//span[contains(text(),'Nhóm sản phẩm')]/parent::div"));}
    public WebElement getSubGroup(String group) {return driver.findElement(By.xpath("//div[contains(text(),'"+group+"')]"));}

    public WebElement getTextLocation() {return driver.findElement(By.xpath("//span[contains(text(),'Vị trí sản phẩm')]/parent::div"));}
    public WebElement getSubLocation(String location) {return driver.findElement(By.xpath("//div[contains(text(),'"+location+"')]"));}

    public WebElement getTextWeight(){return driver.findElement(By.xpath("//input[contains(@placeholder,'Nhập trọng lượng')]"));}


    public WebElement getButtonAddUnit(){return driver.findElement(By.xpath("//div[contains(text(),'Thêm đơn vị')]/parent::div"));}

    public WebElement getButtonLoadImage(){return driver.findElement(By.xpath("//span[contains(text(),'Tải ảnh lên')]/parent::div/parent::div"));}

    public WebElement getButtonLuu(){return driver.findElement(By.xpath("//span[text()='Lưu']/parent::button"));}

    public WebElement getActualProductName(){return driver.findElement(By.xpath("//table//tr[2]/td[4]"));}
    public WebElement getActualInventor(){return driver.findElement(By.xpath("//table//tr[2]/td[7]"));}
    public WebElement getActualSellingPrice(){return driver.findElement(By.xpath("//table//tr[2]/td[9]"));}
    public static String getMessageSuccessful(){return "//div[contains(@class,'ant-message-notice-content')]";}
    public static String getMessageRequire(){return "//p[contains(text(),'Đây là trường bắt buộc!')]";}

    public static String getDuplicateBarcodeToastXpath(String barcode) {
        return "//span[contains(text(),'Mã vạch " + barcode + " đã tồn tại.')]";
    }
    public static String getDuplicateCodeToastXpath(String code) {
        return "//span[contains(text(),'Mã hàng " + code + " đã tồn tại.')]";
    }
}
