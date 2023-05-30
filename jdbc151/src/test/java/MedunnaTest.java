import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class MedunnaTest {
       /*
 Given
   User connects to the database
   (Kullanıcı veritabanına bağlanır)

 When
   User sends the query to get the region ids from "countries" table
   (Kullanıcı, 'countries' table'dan 'region id' almak üzere query gönderir )

 Then
   Assert that the number of region ids greater than 1 is 17.
   (1'den büyük region id'lerin sayısının 17 olduğunu doğrula )

 And
   User closes the connection
*/
       @Test
       public void medunnaTest() throws SQLException {
           //     User connects to the database
           //     (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6))
        JDBCUtils.connectToMedunnaDatabase() ;
        JDBCUtils.createStatement();

          // User sends the query to get the region ids from "countries" table
        String sql ="select * from room where room_number =326556421 " ;
           ResultSet resultSet= JDBCUtils.executeQuery(sql);

          // Assert that the number of region ids greater than 1 is 17.
        resultSet.next() ;  // next kizarir throws atmamiz lazim
        assertEquals("123.00",resultSet.getString(5)); // 5 yerine price da yazabiliriz data da ki sutun adi olarak
        assertEquals("Database Test İçin Oluşturuldu",resultSet.getString(6));
        assertEquals("mark_twain",resultSet.getString("created_by"));


    }




}
