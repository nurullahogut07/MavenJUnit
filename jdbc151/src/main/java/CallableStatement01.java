import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Fenerli4406");
        Statement statement = connection.createStatement();

        //1.ornek = selamlama yapan bir funcition i callable statement ile cagiriniz
        /*
        CALLABLE STATEMENT ADIMLARI

         */
        //1.ADIm = Function i olusturan kodu yaziniz
       String sql= "create or replace function selamlama (x text ) returns text as $$ \n" +
               " begin return 'Merhaba ' || x ||', nasilsin ?' ; end ; $$ language plpgsql;" ;

       //2.ADIM Function kodunu calistiriniz
        statement.execute(sql);

        //3.ADIM =  function i cagir
        CallableStatement callableStatement =connection.prepareCall("{? = call selamlama(?)}");     // ? ilki return type , 2.si parametre  , call=select

        //4.ADIM = return icin registerOutParameter(); methodunu , parametreler icin ise setString(),setInt gibi methodlari kullaniniz
        callableStatement.registerOutParameter(1,Types.VARCHAR);
        callableStatement.setString(2,"Ali");

        //5.ADIM = execute methodu ile  callableStatement cegirip
        callableStatement.execute();

        //6 ADIM  Sonucu okumak icin  callableStatement'tan data turunu(resultset icinde donmez , callebleStatement icinden alirizi) cagiriyoruz
        System.out.println(callableStatement.getObject(1));


        //ornek 2 =iki sayiyi toplayan bir function yaziniz ve calleble statement ile cagiriniz
        //1.adim
        String sql2="create or replace function toplama(x int ,y int) returns numeric \n" +
                "as \n" +
                "$$\n" +
                "begin\n" +
                "\n" +
                "return x + y ;\n" +
                "\n" +
                "end \n" +
                "$$ \n" +
                "language plpgsql;";

        //2.adim
        statement.execute(sql2); // database de olustu

        //3.adim
        CallableStatement callableStatement2 =connection.prepareCall("{? = call toplama(?, ?)}"); // (?, ?) x ve y degeri oldugu icin 2 tane koyduk

        //4.adim
        callableStatement2.registerOutParameter(1,Types.NUMERIC);
        callableStatement2.setInt(2,5);
        callableStatement2.setInt(3,15);

        //5.adim
        callableStatement2.execute();

        //6.adim
        System.out.println(callableStatement2.getBigDecimal(1));






        connection.close();
        statement.close();

    }
}
