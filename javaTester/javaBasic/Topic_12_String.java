package javaBasic;

import org.openqa.selenium.Keys;

public class Topic_12_String {
    public static void main(String[] args) {
       // System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
      //  WebDriver driver = new FirefoxDriver();
    /*
          String s1 ="Cat";
        s1 = "Dog"; // sẽ tạo ra 1 vùng nhớ mới (chuỗi mới - chứ nó k cập nhật giá trị vùng nhớ cũ)
        String s2 = s1;

        String s3= new String("Cat");

        System.out.println(s1==s2); // true
        System.out.println(s1==s3); //false
        System.out.println(s2==s3); //false

        System.out.println(s2.equals(s3)); // true -> equals chỉ so sánh giá trị, ko so sánh vùng nhớ

     */



        String schoolName = "Automation Testing";
        String courseName = "AUTOMATION TESTING";
        String schoolAddess = "Ho Chi Minh city";

        System.out.println("Độ dài ="+ schoolName.length());
        System.out.println("Lấy ra 1 kí tự =" +schoolName.charAt(0));
        System.out.println("Lấy ra 1 kí tự =" +schoolName.charAt(1));
        System.out.println("Nối 2 chuỗi = "+ schoolName.concat(schoolAddess));
        System.out.println("Nối 2 chuỗi = " + schoolName + schoolAddess);

        //Kiểm tra tuyệt đối
        System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals(schoolAddess));
        System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối =" + schoolName.equals("Automation Testing Advanced"));

        System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals(courseName)); // equals phân biệt hoa vs thường

        //Multi browsers
        System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối =" + schoolName.equalsIgnoreCase(courseName)); // true, không phân biệt hoa thường

        //startsWith/ endsWith/ contains
        System.out.println("Có bắt đầu = 1 kí tự/ 1 chuỗi kí =" + schoolName.startsWith("A")); //true
        System.out.println("Có bắt đầu = 1 kí tự/ 1 chuỗi kí =" + schoolName.startsWith("Automation")); //true
        System.out.println("Có bắt đầu = 1 kí tự/ 1 chuỗi kí =" + schoolName.startsWith("T")); //false

        System.out.println("Có chứ 1 kí tự/chuỗi kí tự =" +schoolName.contains("Automation"));
        System.out.println("Có chứ 1 kí tự/chuỗi kí tự =" +schoolName.contains("T"));
        System.out.println("Có chứ 1 kí tự/chuỗi kí tự =" +schoolName.contains("Testing"));
        System.out.println("Có chứ 1 kí tự/chuỗi kí tự =" +schoolName.contains("Advanced"));

        System.out.println("Có chứ 1 kí tự/chuỗi kí tự =" +schoolName.endsWith("g"));    //true
        System.out.println("Có chứ 1 kí tự/chuỗi kí tự =" +schoolName.endsWith("Testing"));  //true
        System.out.println("Có chứ 1 kí tự/chuỗi kí tự =" +schoolName.endsWith("Automation")); //false

        System.out.println("=====================================================");

        System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi ="+schoolName.indexOf("utomation")); //1
        System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi ="+schoolName.indexOf("A"));    //0
        System.out.println("Vị trí của 1 kí tự/ chuỗi kí tự trong chuỗi ="+schoolName.indexOf("Testing")); //1

        System.out.println("=====================================================");
        System.out.println("Tách 1 kí tự / chuỗi kí tự trong chuỗi ="+schoolName.substring(11)); //Testing
        System.out.println("Tách 1 kí tự / chuỗi kí tự trong chuỗi ="+schoolName.substring(11,15)); //Test

        // Split: Tách chuỗi thành 1 mảng dựa vào kí tự/chuỗi kí tự
        //Alert
        String result = "Viewing 48 of 132 results";
        String results[] = result.split(" "); // dựa vào khoảng trắng tách thành 1 index => tách dc 5 element


            System.out.println(results[1]); // 48

        //Replace
        String productPrice = "$100.00";
        productPrice =  productPrice.replace("$","");
        System.out.println(productPrice); // 100.00 (kiểu string)

        // convert string sang số thực
        // Sắp xếp nó: Sort Data (Asc/Desc)
        float  productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF); //100.0 (kiểu số thực)

        // Convert float về lại String
        productPrice =  String.valueOf(productPriceF);
        System.out.println(productPrice);
        System.out.println("===================================================================");

        String osName = System.getProperty("os.name");
        System.out.println(osName); // Windows 10
        //Windows 10 = windows 10 (toLowerCase())
        // Handle multiples OS: MAC/ Windows (Actions - keys - Ctr/Command)
        if(osName.toLowerCase().contains("windows")) {
            Keys key = Keys.CONTROL;
        }
        else {
            Keys key = Keys.COMMAND;
        }

        //Multiple browsers:  toUpperCase
        //firefox = FIREFOX(Enum)

       // String driverInstanceName = driver.toString();
       // System.out.println(driverInstanceName);
        //FirefoxDriver: firefox on WINDOWS (d6279f90-e762-4859-9021-a47f8f2b46be)
        //Close browser / driver

//        if(driverInstanceName.contains("internetexplorer")) {
//            //Sleep cứng thêm 5s sau mỗi sự kiện chuyển page
//        }

        // Khoảng trắng/ xuống dòng / tab
        String helloWorldText = " \n  \t Hello World!         " ;
        System.out.println(helloWorldText);
        System.out.println(helloWorldText.trim());

        helloWorldText = " ";
        System.out.println("Empty = "+ helloWorldText.isEmpty()); //false
       System.out.println("Blank =" + helloWorldText.isBlank()); //true

        // Dynamic locator
        // Đại diện cho 1 chuỗi: %s
        // %b %t %d
        String dynamicButtonXpath = "//button[@id='%s']";

        System.out.println("Click to Login button ="+ String.format(dynamicButtonXpath, "login"));
        System.out.println("Click to Search button ="+ String.format(dynamicButtonXpath, "search"));
        System.out.println("Click to Register button ="+ String.format(dynamicButtonXpath, "register"));


    }
}
