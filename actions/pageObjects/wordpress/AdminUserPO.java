package pageObjects.wordpress;

import commons.BasePage;
import jdbcTest.MySQLConnUtils;
import jdbcTest.MySQLTestConnection;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.AdminUserPageUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminUserPO extends BasePage {
    WebDriver driver;

    public AdminUserPO (WebDriver driver) {
        this.driver = driver;
    }

    public int getUserNumberAtUI() {
        waitForElementVisible(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
         String totalNumber =   getElementText(driver,AdminUserPageUI.TOTAL_NUMBER_TEXT);
        //totalNumber = 2 items ==> String, dung split tach ra index roi convert qua kiểu int
        String totalArray[] = totalNumber.split(" "); // dựa vào khoảng trắng tách thành 1 index => tách dc 2 element
        totalNumber = totalArray[0];
      //  System.out.println(totalArray[0]); // 2 (Kiểu String)
        // Convert qua kiểu Int
        return  Integer.parseInt(totalNumber);


    }


    public int getUserNumberAtDB()  {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        Statement statement ;
        List<Integer> totalUsers = new ArrayList<Integer>();

        try {
            statement = conn.createStatement();
            String sql ="SELECT * FROM `wp_users` ";
            ResultSet rs = statement.executeQuery(sql);
            // Duyệt kết quả trả về
            while (rs.next()) {
                // Di chuyển con trỏ chuột xuống bản ghi kế tiếp

                totalUsers.add(rs.getInt(1));
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                // Mỗi lần add là in ra size, lần cuối cùng là 3
                System.out.println("Total User (List) =" + totalUsers.size());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn !=null) {
                    conn.close();
                }

            } catch (SQLException e) {
               e.printStackTrace();
            }
        }

        return totalUsers.size();

    }

}
