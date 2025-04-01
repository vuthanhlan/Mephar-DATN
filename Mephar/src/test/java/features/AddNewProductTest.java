package features;

import actions.AddNewMerchandiseAction;
import actions.LoginAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.AddNewProductPageUI;
import untils.ExcelUntils;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;


public class AddNewProductTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginAction login;
    AddNewMerchandiseAction addNewProduct;
    AddNewProductPageUI addNewProductPageUI;
    String excelFilePath="productData.xlsx";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        login = new LoginAction(driver);
        addNewProduct = new AddNewMerchandiseAction(driver);
        addNewProductPageUI = new AddNewProductPageUI(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mephar-sit.acdtech.asia/auth/sign-in/");
    }
    @Test
    public void testAddNewProductSuccessfulWithRequiredFields() throws InterruptedException, AWTException {
        List<Map<String, String>> excelData = ExcelUntils.readExcelData(excelFilePath, "Danh sách sản phẩm");
        //B1: Login
        login.Login();
        //B2: Navigate to add new Merchandise page
        addNewProduct.navigateToAddNewMerchandisePage();
        //B3: Input required fields
        for(int i=0; i<1; i++){
            Map<String, String> rowData = excelData.get(i);
            addNewProduct.inputRequireData(rowData.get("Tên sản phẩm"), parseInt(rowData.get("Giá bán")), parseInt(rowData.get("Tồn kho")),rowData.get("Đơn vị cơ bản"));
        }
        //B4: Click button Luu
        addNewProduct.clickButtonLuu();
        Thread.sleep(2000);
        //B5: Observe
        WebElement ActualName = addNewProductPageUI.getActualProductName();
        WebElement ActualInventor = addNewProductPageUI.getActualInventor();
        WebElement ActualSellingPrice = addNewProductPageUI.getActualSellingPrice();
        for(int i=0; i<1; i++){
            Map<String, String> rowData = excelData.get(i);
            Assert.assertEquals(ActualName.getText(),rowData.get("Tên sản phẩm"));
            Assert.assertEquals(ActualInventor.getText().replace(",","").trim(), rowData.get("Tồn kho"));
            Assert.assertEquals(ActualSellingPrice.getText().replace("đ","").replace(",","").trim(), rowData.get("Giá bán"));
        }
    }

    @Test
    public void testAddNewProductSuccessfulWithAllFields() throws InterruptedException, AWTException {
        List<Map<String, String>> excelData1 = ExcelUntils.readExcelData(excelFilePath, "Danh sách sản phẩm");
        login.Login();

        addNewProduct.navigateToAddNewMerchandisePage();
        Thread.sleep(2000);
        for(int i=2; i<3; i++){
            Map<String, String> rowData = excelData1.get(i);
            addNewProduct.inputAllData(rowData.get("Mã hàng"),rowData.get("Mã vạch"),rowData.get("Tên sản phẩm"),rowData.get("Tên viết tắt"), parseInt(rowData.get("Giá vốn")), parseInt(rowData.get("Giá bán")),Float.parseFloat(rowData.get("Trọng lượng")),rowData.get("Quy cách đóng gói"),parseInt(rowData.get("Tồn kho")),rowData.get("Đơn vị cơ bản"));
        }

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
