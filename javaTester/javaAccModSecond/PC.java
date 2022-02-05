package javaAccModSecond;

import javaAccModFirst.Computer;

public class PC extends Computer {
    /**
     * Kế thừa cũng k xài dc
     *    System.out.println(comp.ramProductName); // Kington
     */

    // Protected - PC kế thừa thì sử dụng dc  (dù khác package)
    public void showCPUProductName() {
        cpuProductName = "Intel";
        System.out.println(cpuProductName);

        setCpuProductName("AMD");
        System.out.println(cpuProductName);

        //Property
        vgaSize =6;
        System.out.println(vgaSize);

        //Method
        setVgaSize(4);
        System.out.println(vgaSize);
    }




}