public class Test01 {
    public static void main(String[] args) {

        // otomasyon testi yapabilmemiz icin test framwork'e ihtiyacimiz var (junit,testng,cucumber gibi )
       // bunun icin maven dan hangisini kullanacaksak linki kopyalamaliyiz


        // NORMAL TEST
        String str ="Merhaba" ;

        if (str.contains("er")){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }



    }
}
