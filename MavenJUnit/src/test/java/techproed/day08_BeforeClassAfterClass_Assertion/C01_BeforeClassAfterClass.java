package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    before classs ve after class methodlari static olmak zorundadir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her clasttan once BeforeClass methodu bir kez calisir");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("her classtan AfterCLass  methodu  sonra bir kez calisir");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("her methoddan sonra after methodu  bir kez calisir ");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("her methoddan once befora methodu bir kez calisir");
    }

    @Test
    public void name1() {
        System.out.println("test01 calisti");
    }

    @Test
    public void name2() {
        System.out.println("test02 calisti");
    }

    @Test
    public void name3() {
        System.out.println("test03 calisti");
    }
}
