package pageObjects.wordpress;

import commons.BasePage;
import jdbcTest.MySQLConnUtils;
import jdbcTest.MySQLTestConnection;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.AdminUserPageUI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminUserPO extends BasePage {
    WebDriver driver;

    public AdminUserPO(WebDriver driver) {
        this.driver = driver;
    }

    public int getUserNumberAtUI() {
        waitForElementVisible(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
        String totalNumber = getElementText(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
        //totalNumber = 2 items ==> String, dung split tach ra index roi convert qua kiểu int
        String totalArray[] = totalNumber.split(" "); // dựa vào khoảng trắng tách thành 1 index => tách dc 2 element
        totalNumber = totalArray[0];
        //  System.out.println(totalArray[0]); // 2 (Kiểu String)
        // Convert qua kiểu Int
        return Integer.parseInt(totalNumber);


    }


    public int getUserNumberAtDB() {
        Connection conn = MySQLConnUtils.getMySQLConnection();
        Statement statement;
        List<Integer> totalUsers = new ArrayList<Integer>();

        try {
            statement = conn.createStatement();
            String sql = "SELECT * FROM `wp_users` ";
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
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return totalUsers.size();

    }

    public boolean checkTotalRecordMemorySizeFromDB(String categoryId, String memorySize, String role) {
        Connection conn = ultilities.MySQLConnUtils.getMySQLConnection();
        String sql = "";
        if (role.equals("roleAdmin")) {
            sql = "SELECT DISTINCT COUNT(attribute15) as memorySize FROM estore_inventory where category_id = ? AND attribute 15 =? ORDER BY attribute15";
        } else {
            sql = "SELECT DISTINCT COUNT(attribute15) as memorySize FROM estore_inventory where category_id = ? AND status ='AGENT-STORE-AVAILABLE' AND attribute 15 =? ORDER BY attribute15";

        }
        int i = 0;

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, categoryId);
            statement.setString(2, memorySize);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                i = rs.getInt("memorySize");
            }
            if (i == 3) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


            return false;

        }
    }
}