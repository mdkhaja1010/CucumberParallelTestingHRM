package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager
{
    WebDriver driver;
    public WebDriverWait explicitWait;
    public final int TIMEOUT = 10;
    public final int Page_Load_Timeout = 20;

    public WebDriver initializeDriver()
    {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
      //  WebDriver driver = new ChromeDriver(options);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Page_Load_Timeout));
        return driver;
    }

    public void openPage(String url)
    {
        driver.get(url);
    }

    public String getCurrentPageUrl()
    {
      return driver.getCurrentUrl();
    }

    public void tearDown()
    {
        driver.quit();
    }

}
