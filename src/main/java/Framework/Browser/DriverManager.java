package Framework.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    
    private static WebDriver driver;

    private static WebDriver getManagerDriver(TypeBrowser type) {
        
        switch(type) {
        
        case CHROME:
            
           WebDriverManager.chromedriver().setup();
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--remote-allow-origins=*");
           options.addArguments("--start-maximized");
           options.addArguments("--incognito");
           driver = new ChromeDriver(options);
           break;
           
        case EDGE:
           
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*");
            edgeOptions.addArguments("--start-maximized");
            edgeOptions.addArguments("--incognito");
            driver = new EdgeDriver(edgeOptions);
            break;
            
        case FIREFOX:
            
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
            
        case HEADLESS:
            
            WebDriverManager.chromedriver().setup();
            ChromeOptions headlessOptions = new ChromeOptions();
            headlessOptions.addArguments("--remote-allow-origins=*");
            headlessOptions.addArguments("--headless");
            headlessOptions.addArguments("--window-size(1366,768)");
            driver = new ChromeDriver(headlessOptions);
            break;
            
        
        }
       return driver;
    }
    
    public static WebDriver getDriver(TypeBrowser type) {
        
        if(driver==null) {
            
            driver = getManagerDriver(type);
        }
        return driver;
    }
    
    public static void quitDriver() {
        
        if(driver!=null) {
            
            driver.quit();
            driver = null;
        }
    }
}
