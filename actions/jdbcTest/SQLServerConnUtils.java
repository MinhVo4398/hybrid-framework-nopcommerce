package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerConnUtils {
    public static Connection getSQLServerConnection() {
        String hostName = "localhost";
        String sqlInstanceName ="SQLEXPRESS";
        String database="automationtest";
        String userName = "sa";
        String password = "automationfc";

        return getSQLServerConnection(hostName, sqlInstanceName, database , userName, password);
    }

    public static Connection getSQLServerConnection (String hostName, String sqlInstanceName, String database, String  userName, String password) {
        Connection conn = null;
        try {

          //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Cấu trúc URL Connection danh cho MySQL

            String connectionURL ="jdbc:sqlserver://" + hostName + ":1433"  + ";instance=" + sqlInstanceName + ";databaseName=" + database +";encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionURL, userName, password);
        }catch (Exception e){
            e.getStackTrace();
        }
        return conn;
    }
}
