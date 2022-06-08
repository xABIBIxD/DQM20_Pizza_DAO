package helloWorld;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Hello {


    void loadHello()  {
        try {

            Class.forName("org.sqlite.JDBC");
            String url="jdbc:sqlite:datenbank.db";
            Connection conn =  DriverManager.getConnection(url);
            String sql="select * from hello";
            PreparedStatement statement=conn.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            rs.next();
            System.out.println(rs.getString("message"));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        new Hello().loadHello();
    }
}
