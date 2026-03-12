import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ClockTimerTest {

    private static AndroidDriver driver;
    private static WebDriverWait wait;

    // Elements
    @AndroidFindBy(xpath = "//*[@text='Timer' or @text='טיימר' or @content-desc='Timer']")
    private WebElement timerTab;

    @AndroidFindBy(xpath = "//*[@text='1']")
    private WebElement digit1;

    @AndroidFindBy(xpath = "//*[@text='0']")
    private WebElement digit0;

    @AndroidFindBy(accessibility = "Start")
    private WebElement startButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'timer_time')]")
    private List<WebElement> timerDisplay;

    @BeforeAll
    public static void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setAppPackage("com.google.android.deskclock")
                .setAppActivity("com.android.deskclock.DeskClock")
                .setAutomationName("UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testTimerCountdown() throws InterruptedException {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        // 1. מעבר לטאב טיימר
        wait.until(ExpectedConditions.elementToBeClickable(timerTab)).click();

        // 2. הגדרת זמן (למשל 10:00)
        digit1.click();
        digit0.click();
        digit0.click();
        digit0.click();

        String timeBefore = timerDisplay.get(0).getText();

        // 3. הפעלה
        startButton.click();

        // 4. המתנה של 30 שניות
        Thread.sleep(30000);

        // 5. וידוא שהזמן השתנה
        String timeAfter = timerDisplay.get(0).getText();
        Assertions.assertNotEquals(timeBefore, timeAfter, "הזמן לא השתנה!");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) driver.quit();
    }
}