package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {
    WebDriver driver ;  // diger methodlarda kullanabilmek icin burada olusturduk
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void techproTest() {
        driver.get("https://techproeducation.com");

    }

    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() {
        driver.close();

    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her class tan once bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class tan sonra bir kez calisir");
    }
}
