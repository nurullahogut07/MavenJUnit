import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Fenerli4406");
        Statement statement=connection.createStatement();

        // 1.ornek companies tablosundan en yuksek ikinci number_of_employees degeri olan company ve number_of_employees degerlerini cagirin
        System.out.println("1.yol");
        String sql1 ="select company , number_of_employees from companies order by number_of_employees desc offset 1 limit 1" ;
        ResultSet resultSet=statement.executeQuery(sql1);
        while (resultSet.next()){  //resultset son satira gelip "false" aldiktan sonra kapanir,kapali resultset uzerinden islem yapilamaz
            System.out.println(resultSet.getObject(1)+"--"+resultSet.getObject(2));
        }
        //2.yol sub query kullarak , 2 tane sonuc varsa
        System.out.println("2.yol");
        //(karisik degil 18000 i bulmak icin ilk en yuksek olan maasi bulduk sonra ondan kucuk olani aldik
        String sql2="SELECT company, number_of_employees FROM companies WHERE number_of_employees = (SELECT MAX(number_of_employees) FROM companies\n" +
                "WHERE number_of_employees < (SELECT MAX(number_of_employees) FROM companies))" ;
        ResultSet resultSet2 =statement.executeQuery(sql2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getObject("company")+"--"+resultSet2.getObject("number_of_employees"));
        }


        connection.close();
        statement.close();
    }
}
