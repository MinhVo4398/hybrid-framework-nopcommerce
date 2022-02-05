package javaAccModFirst;

public class Laptop    {
    public static void main(String[] args) {
        Computer comp = new Computer();
        comp.ramProductName = "Kington";
        System.out.println(comp.ramProductName); // Kington
        //Method
        comp.setRamProductName("Kingmax");
        System.out.println(comp.ramProductName);  //Kingmax

        //Property
        comp.cpuProductName = "Intel";
        System.out.println(comp.cpuProductName);
        //Method
        comp.setCpuProductName("AMD");
        System.out.println(comp.cpuProductName);

        //Property
        comp.vgaSize =6;
        System.out.println(comp.vgaSize);

        //Method
        comp.setVgaSize(4);
        System.out.println(comp.vgaSize);


    }

}