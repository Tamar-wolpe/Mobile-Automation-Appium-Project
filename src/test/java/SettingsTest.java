import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SettingsTest {

    private static AndroidDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setAppPackage("com.android.settings")
                .setAppActivity("com.android.settings.Settings")
                .setAutomationName("UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testSettingsNavigation() {
        // גלילה ל-System ולחיצה [cite: 102]
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"System\"))";
        driver.findElement(AppiumBy.androidUIAutomator(scrollElement)).click();

        // לחיצה על About emulated device
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[contains(@text,'About')]"))).click();

        // וידוא שהגענו לדף הנכון
        Assertions.assertTrue(driver.getPageSource().contains("Android version") ||
                driver.getPageSource().contains("Model"));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}