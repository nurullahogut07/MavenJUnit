import org.junit.Test;

import static org.junit.Assert.*;

public class JunitTest01 {

    // main method kullanmiyoruz ,test methodlari void olmak zorundadir
    @Test
    public void test01(){  // 2 sininde gecmesi lazim testten
        assertEquals(1,1); //  assertEquals(); parantez icinde ki parametreler birbirine esitse test gecer degilse kalir
        assertTrue("Merhaba ".contains("a"));   //  assertTrue();  parantez icinde ki kosul dogruysa test gecer degilse kalir .\
        assertFalse(1>2); // parantez icinde ki kosul  yanlis sa test gecer .
    }


}
