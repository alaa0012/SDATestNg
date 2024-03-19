package SDA.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {
    /*
         TestBase Class: It is a class created using Java OOP concepts to avoid repeatedly writing setup and teardown methods in each test class.
        - Classes that accept TestBase as a parent do not need to create their own driver, setup(), and teardown() methods; they inherit and use them from the parent class.
        - Since TestBase is generally in a different package than the tests, we need to make the driver public or protected to be able to use it. We chose protected since we will use it mainly from child classes.
        - To prevent creating an object of this class, which we only want to be used through inheritance in child classes, we can make this class abstract.

        - By making it abstract, we prevent the instantiation of objects from the TestBase Class.
        We will use TestBase Class only by inheriting it with the extends keyword.
        Therefore, we choose the protected access modifier for the driver variable we created.
         */
    protected static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }

    }

    public static class TestBaseExtendReport {

        protected WebDriver driver;

        protected static ExtentReports extentReports;

        protected static ExtentSparkReporter extentHtmlReporter;

        protected static ExtentTest extentTest; // Our object that keeps track of whether our test has passed or failed. It is also used for taking screenshots.



        @BeforeMethod
        public void setup(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            extentReports = new ExtentReports();
            // A date string is created for the file we will save
            String currentDate = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
            String filePath = System.getProperty("user.dir") + "/test-output/reports/testReport_"+currentDate+".html";

            // Object to create an HTML report is initialized with the file path
            extentHtmlReporter = new ExtentSparkReporter(filePath);
            // Our extent report object for reporting is linked with the HTML reporter
            extentReports.attachReporter(extentHtmlReporter);
            // Additional optional information related to the report is provided
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("Browser", "Chrome");
            extentReports.setSystemInfo("Tester", "Tester CW");

            // Configurations for the HTML report that we want to display
            extentHtmlReporter.config().setDocumentTitle("jUnit_Report");
            extentHtmlReporter.config().setReportName("Test run report");
            // Starting the test
            extentTest = extentReports.createTest(getClass().getSimpleName() + " - " + Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        @AfterMethod
        public void teardown(){
            driver.quit();
            extentReports.flush();
        }

        @AfterClass
        public static void afterClass() {
            //   extentReports.flush();
        }

    }
}