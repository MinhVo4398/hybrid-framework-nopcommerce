package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {


    public static Connection getMyConnection() throws SQLException, ClassCastException {
        return MySQLConnUtils.getMySQLConnection();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        System.out.println("Get connection....");

        // Lấy ra đối tượng Connection kết nối vào Databse
        Connection conn = MySQLTestConnection.getMyConnection();

        System.out.println("Open connection:" + conn);

        Statement statement = conn.createStatement();

        String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name, Emp.Dept_Id From Employee Emp;";

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt kết quả trả về
        while (rs.next()) {
            // Di chuyển con trỏ chuột xuống bản ghi kế tiếp
            int empId = rs.getInt(1);
            String empFirstName = rs.getString(2);
            String empLastName = rs.getString("Last_Name");

            System.out.println("----------------");
            System.out.println("Emp Id:" + empId);
            System.out.printf("Emp Firstname:" + empFirstName);
            System.out.println("Emp Lastname:" + empLastName);
        }

        // Đóng kết nối
        conn.close();
        System.out.printf("-----------Closed connection");



    }
}
