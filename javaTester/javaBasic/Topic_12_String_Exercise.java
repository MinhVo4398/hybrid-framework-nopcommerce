package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_String_Exercise {
    String courseName = "Automation Testing Advance";

    @Test
    public void TC_01() {
        char courseNameArr[] = courseName.toCharArray();
        int countUpper =0;
        int countLower =0;
        int countNumber =0;

        for (char charecter: courseNameArr) {
            // Uppercase
            if(charecter <='Z' && charecter >='A') {
                countUpper++;
            }

            //Lowercase
            if(charecter <='z' && charecter >='a') {
                countLower++;
            }

            //Number
            if(charecter <='9' && charecter >='0') {
                countNumber++;
            }

        }
        System.out.println("count  of uppercase ="+countUpper); // 3 (3 kí tự in hoa)
        System.out.println("Count of lowercase ="+countLower); // 21 (21 kí tự thường)
        System.out.println("count of number ="+countNumber); // 0 (kí tự số )
            


    }

    @Test
    public void TC_02 () {
        char couseNameArr[] = courseName.toCharArray();
        int count =0;
        for(char c :couseNameArr) {
            if(c=='a') {
                count++;
            }
        }
        System.out.println(count); // 2 (có 2 kí tự a)
        System.out.println("Chuỗi có chứa từ Testing hay ko = "+ courseName.contains("Testing")); //true
    }

    @Test
    //Reverse a String
    public void TC_03() {
        char couseNameArr[] = courseName.toCharArray();

        for (int i = couseNameArr.length -1; i>0; i--) {

            System.out.print(couseNameArr[i]);
        }


    }
}
