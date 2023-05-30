import java.sql.*;

public class JDBCUtils {
    //Tekrarli yapilacak islemlerin methodlari bulunaccak
    static Connection connection ;  // connection i kullanabilmek icin disarda olusturduk ve static olmasini sagladik
    private static Statement statement ;
    private  static  ResultSet resultSet ;

    // Database'e baglanma methodu
    public static Connection connectToDatabase(){
                                     // getConnection() hata verdigi icin try catch uyguladik
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fenerli4406");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection ;
    }
      // Medunna Database baglanma methodu
      public static Connection connectToMedunnaDatabase(){
         // (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6))
          // getConnection() hata verdigi icin try catch uyguladik
          try {
              connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "Medunna_pass_@6");
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
          return connection ;
      }

        //statment olusturan method
    public static Statement createStatement(){
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  statement ;
    }
    //execute methodu ile query calistiran method
    public static boolean execute(String sql){
        try {
            return statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //executequery methodu ile query calistiran method
    public static ResultSet executeQuery(String sql) {
        try {
            resultSet= statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet ;
    }
    //Baglantiyi  kapatan method
    public static void closeConnection(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
