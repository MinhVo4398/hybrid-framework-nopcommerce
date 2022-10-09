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

        // Tạo ra 1 đối tượng của Statement
        Statement statement = conn.createStatement();

      //  String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name, Emp.Dept_Id From Employee Emp;";

        String sql ="SELECT * FROM `wp_users` ";
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        ResultSet rs = statement.executeQuery(sql);

        // Duyệt kết quả trả về
        while (rs.next()) {
            // Di chuyển con trỏ chuột xuống bản ghi kế tiếp
            int userID = rs.getInt(1);
            String userLogin = rs.getString(2);
            String userEmail = rs.getString("user_email");

            System.out.println("----------------");
            System.out.println("User Id:" + userID);
            System.out.println("User login:" + userLogin);
            System.out.println("User email:" + userEmail);
        }

        // Đóng kết nối
        conn.close();
        System.out.printf("-----------Closed connection");



    }
}
