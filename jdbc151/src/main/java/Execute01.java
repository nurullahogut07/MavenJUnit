import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Adım: Driver'a kaydol ==> JDBC 4 sonrası gerek yoktur.
        Class.forName("org.postgresql.Driver");

        //2. Adım: Database'e bağlan
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Fenerli4406");

        //3.Adim Statement olustur (methodlara ulasabimek icin )
        Statement statement=connection.createStatement();

        //4.Adim Query calistir
        /*
        1) execute() methodu DDL(create ,drop,alter,table) ve DQl (select) ile kullanilir
        2) Eger execute() methodu DDL ile kullanilirsa hep "false "dondurur cunku DDl ile data cagirilmaz
        3)Eger execute() methodu DQL ile kullanilirsa data dondugunde "true "data donmediginde "false"verir .
         */
       // 1.ornek = workers adinda bir table olustur ver worker_id, worker_name , worker_salary sutunlarini ekle
        String sql1 ="create table workers( worker_id varchar(20),worker_name varchar(20),worker_salary int )" ;
       boolean r1 = statement.execute(sql1);

        System.out.println("r1 = "+ r1); // false
        
        //2> ORNEK table a worker_address sutunu ekleyin
        String sql2 ="Alter table workers add worker_address varchar(100)";
       boolean r2 =statement.execute(sql2);
        System.out.println("r2 = " + r2);  // false

        // 3.ORNEK worrkers tablesini silin
        String sql3="Drop table workers";
        boolean r3 =statement.execute(sql3);
        System.out.println("r3 = " + r3); // false

        // 5 ADIM BAGLANTIYI KAPATMA
        connection.close();
        statement.close();
    }
}