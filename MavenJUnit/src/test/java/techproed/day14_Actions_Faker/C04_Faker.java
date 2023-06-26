package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C04_Faker extends TestBase {
    @Test
    public void faker() {
         /*
    Faker class'ından sahte verileri kullanabilmek için obje oluşturmamız gerekir
     */
        Faker faker = new Faker();

        //faker objesini kullanarak bir isim yazdıralım
        System.out.println("Isim : "+faker.name().firstName());

        //faker objesini kullanarak bir lastName yazdıralım
        System.out.println("Soyİsim : "+faker.name().lastName());

        //faker objesini kullanarak bir fullName yazdıralım
        System.out.println("fullname :"+ faker.name().fullName());

        //faker objesini kullanarak bir adress yazdıralım
        System.out.println("adres :" + faker.address().fullAddress());

        //faker objesini kullanarak bir tel_no yazdıralım
        System.out.println("tel no :"+ faker.phoneNumber().cellPhone());

        //Rastgele 15 haneli bir numara yazdıralım
        System.out.println("Rastgele 15 haneli bir numara : "+faker.number().digits(15));

        //Meslek pozisyonu
        System.out.println(faker.job().position());
    }
}
