import java.sql.*;

public class PreparedStatetment01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fenerli4406");
        Statement statement = connection.createStatement();

        //ornek1 = prepared statement kullanarak company adi IBM olan number_of_employees degerini 9999 olarak guncelleyin

        // prepared statement olusturmak icin

        // 1.adim = prepared statement query olusturduk yani ? yaptik
        String sql = " update companies set number_of_employees =?\n" +
                "\t where company=?";  // ? ile parametledik
        //2.adim=prepared statement objesi olusturma
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //3.adim = prepared statement objesi ile setInt gibi methodlarla parametrelerin yero=ine koymak istedigimiz degerleri yerlestiririz
        preparedStatement.setInt(1, 9999);
        preparedStatement.setString(2, "IBM");

        //4.adim= Query i calistiracagiz
        int guncellenenSatirSayisi = preparedStatement.executeUpdate();
        System.out.println("GuncellenenSatirSayisi =" + guncellenenSatirSayisi);

        String sql2 = "Select * from companies";
        ResultSet resultSet = statement.executeQuery(sql2);

        while (resultSet.next()) {
            System.out.println(resultSet.getObject(1) + "--" + resultSet.getObject(2) + "--" + resultSet.getObject(3));
        }
        //2.ornek = prepared statement kullanarak company adi Casper olan number_of_employees degerini 10000 olarak guncelleyin
        preparedStatement.setInt(1, 10000);
        preparedStatement.setString(2, "CASPER");

        int guncellenenSatirSayisi2 = preparedStatement.executeUpdate();
        System.out.println("GuncellenenSatirSayisi =" + guncellenenSatirSayisi2);

        ResultSet resultSet2 = statement.executeQuery(sql2);
        while (resultSet2.next()) {
            System.out.println(resultSet2.getObject(1) + "--" + resultSet2.getObject(2) + "--" + resultSet2.getObject(3));
        }
            connection.close();
            statement.close();
        }
    }

