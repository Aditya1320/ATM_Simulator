package bank.management;
import java.sql.*;
public class DataConn
{
    Connection con;
    static Statement s;
    public DataConn()
    {
        try {
            
            con = DriverManager.getConnection("jdbc:mysql:///atmsimulator","root","aditya");
            s = con.createStatement();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
