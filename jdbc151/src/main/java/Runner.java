import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        // database'e baglan
        JDBCUtils.connectToDatabase() ;

        // statement olustur
        JDBCUtils.createStatement();

        //query calistir
        String sql1 ="create table workers( worker_id varchar(20),worker_name varchar(20),worker_salary int )" ;
        JDBCUtils.execute(sql1) ;


    }
}
