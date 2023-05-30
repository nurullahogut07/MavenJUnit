import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.* ;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Fenerli4406");
        Statement statement=connection.createStatement();

        // 1.ornek number of employees degeri ortalama calisan sayisindan az olan numberof employees degerlerini 16000 olarak update edin

        String sql1=" update companies set number_of_employees =16000\n" +
                "\twhere number_of_employees <(select avg(number_of_employees) from companies )" ;
       int guncellenenSatirSayisi= statement.executeUpdate(sql1) ; //executeupdate methodu int deger dondurur
        System.out.println("guncellenen satir sayisi ="+ guncellenenSatirSayisi);

        // guncelleme sonrasi datayi cagirmak icin DQL(select) kullaniriz
        String sql2="Select * from companies";
        ResultSet resultSet2 =statement.executeQuery(sql2);

        while (resultSet2.next()){
            System.out.println(resultSet2.getObject("company_id")+"--"+resultSet2.getObject("company")+"--"+resultSet2.getObject("number_of_employees"));
        }



        connection.close();
        statement.close();
    }
}
