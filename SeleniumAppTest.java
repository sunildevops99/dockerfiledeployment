import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
public class SeleniumAppTest {
        public static void main(String[] args) throws IOException, InterruptedException {
System.setProperty("webdriver.chrome.driver", "/home/ubuntu/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-extensions"); // disabling extensions
                chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
                chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
                chromeOptions.addArguments("--headless");
                 WebDriver driver = new ChromeDriver(chromeOptions);
                driver.get("http://localhost:8091/notificationapp-1/devices");
              //  Thread.sleep(1000);

                if (driver.getPageSource().contains("ac:00:00:01")) {
                        System.out.println("Output Received on Deployed Application : SUCCESS");
//System.out.println(driver.getPageSource());
String yourtext= driver.findElement(By.tagName("body")).getText() ;
System.out.println("OUTPUT : "+yourtext);
                } else {
                        System.out.println("Fail");
System.out.println(driver.getPageSource());
                }
                driver.quit();

        }
}
