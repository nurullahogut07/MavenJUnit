import java.sql.*; // * ile butun sql leri import etmis olduk

public class ExecuteQuery01 {

    public static void main(String[] args) throws SQLException {
        // statemnet lari olusturmaliyiz ilk
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Fenerli4406");
        Statement statement=connection.createStatement();

        // 1) ornek ; region_id si 1 olan  country_name degerlerini cagirin
        String sql1 ="select country_name from countries where region_id=1 " ;
        boolean r1 =statement.execute(sql1);
        System.out.println("r1 = " + r1); // true DQl ile data cagirdik cunku

        // Datayi cagirip okumak icin executeQuery methodunu kullanmaliyiz ,execute() methodu sadece true yada false doner

       ResultSet resultSet= statement.executeQuery(sql1); // data yi okumak istedigimiz icin "executeQuery" kullaniriz bu da bize 'ResultSet ' verir
       while (resultSet.next()){  // next ile bir sonraki data'yi okumak icin yazariz
           System.out.println(resultSet.getString("country_name")); // parantez icine hangi satiri istiyorsak onu yazmaliyiz

       }
        // 2.ornek region_id nin 2 den buyuk oldugu country_id ve country name degerlerini cagirin
        String sql2 ="select country_id , country_name from countries where region_id >2" ;
       ResultSet rset2 =statement.executeQuery(sql2);

       while(rset2.next()){ // next ile bir sonraki data oldugu surece ilerler sartimiz budur while icin
           System.out.println(rset2.getString("country_id") + rset2.getString("country_name"));
       }

       //3 . ornek number_of_employes degeri en dusuk olan satirin tum degerlerini alin
        String sql3 ="select * from companies where number_of_employees=(select min (number_of_employees )from companies )" ;
       ResultSet rset3=statement.executeQuery(sql3) ;

       while (rset3.next()){
           System.out.println(rset3.getObject(1) +" --"+ rset3.getObject(2)+"-- " + rset3.getObject(3)); //1-2-3 yerine sutun ismide yazilabilir
       }
       connection.close();
       statement.close();


    }
}
