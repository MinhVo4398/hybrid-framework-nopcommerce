package javaAccModSecond;

import javaAccModFirst.Computer;

public class Workstation {
    public static void main(String[] args) {
        Computer comp = new Computer();

        //Property
        comp.vgaSize =6;
        System.out.println(comp.vgaSize);

        //Method
        comp.setVgaSize(4);
        System.out.println(comp.vgaSize);

        /**
         * Khac package k truy cập dc -> bị lỗi
         *      comp.ramProductName = "Kington";
         *         System.out.println(comp.ramProductName); // Kington
         *     //Method
         *         comp.setRamProductName("Kingmax");
         *         System.out.println(comp.ramProductName);  //Kingmax
         */

        /**Biến protected k dc truy cập bên ngoài package, ko bởi class con (kế thừa)
         *  //Property
         *         comp.cpuProductName = "Intel";
         *         System.out.println(comp.cpuProductName);
         *         //Method
         *         comp.setCpuProductName("AMD");
         *         System.out.println(comp.cpuProductName);
         */
    }




}