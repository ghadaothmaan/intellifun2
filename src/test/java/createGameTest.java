
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class createGameTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/home";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateGame() throws Exception {
    driver.get(baseUrl + "/home");
    driver.findElement(By.linkText("login")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("coach");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("123");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.xpath("//p[2]/a/button")).click();
    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    driver.findElement(By.cssSelector("a > button")).click();
    driver.findElement(By.id("type")).clear();
    driver.findElement(By.id("type")).sendKeys("Math");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.id("questionhead")).clear();
    driver.findElement(By.id("questionhead")).sendKeys("1+1 =");
    driver.findElement(By.id("questionhead")).clear();
    driver.findElement(By.id("questionhead")).sendKeys("1+1 = ?");
    driver.findElement(By.id("choice1")).clear();
    driver.findElement(By.id("choice1")).sendKeys("2");
    driver.findElement(By.id("choice2")).clear();
    driver.findElement(By.id("choice2")).sendKeys("11");
    driver.findElement(By.id("choice3")).clear();
    driver.findElement(By.id("choice3")).sendKeys("1");
    driver.findElement(By.id("choice4")).clear();
    driver.findElement(By.id("choice4")).sendKeys("10");
    driver.findElement(By.id("correctAnswer")).clear();
    driver.findElement(By.id("correctAnswer")).sendKeys("2");
    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    driver.findElement(By.id("questionhead")).clear();
    driver.findElement(By.id("questionhead")).sendKeys("1 * 1 = ?");
    driver.findElement(By.id("choice1")).clear();
    driver.findElement(By.id("choice1")).sendKeys("1");
    driver.findElement(By.id("choice2")).clear();
    driver.findElement(By.id("choice2")).sendKeys("2");
    driver.findElement(By.id("choice1")).clear();
    driver.findElement(By.id("choice1")).sendKeys("11");
    driver.findElement(By.id("correctAnswer")).clear();
    driver.findElement(By.id("correctAnswer")).sendKeys("1");
    driver.findElement(By.xpath("//button[@value='finish']")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
