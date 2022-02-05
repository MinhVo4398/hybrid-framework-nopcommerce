package javaAccModFirst;

public  class Computer {
    //property
    private int ssdSize; // global variable
    String ramProductName;  //default

    protected String cpuProductName;
    public int vgaSize;

    void setRamProductName(String ramProduct ) {
        ramProductName = ramProduct;

    }

    protected void setCpuProductName(String cpuProduct) {
        cpuProductName =cpuProduct;

    }

    public void setVgaSize(int vgaSize) {
        this.vgaSize = vgaSize;
    }



    //Method
//    private void  setSsdSize(int ssdSize) {
//        this.ssdSize = ssdSize; // dùng this để nó hiểu là lấy biến global trên gán cho biến cục bộ, nếu tên biến truyền vào khác thì k cần dùng this cũng dc
//    }

    private void setSsdSize(int ssd_size) {
        ssdSize = ssd_size;
    }


    public static void main(String[] args) {
        Computer comp = new Computer();
        //Property
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
        comp.ssdSize = 500;
        System.out.println(comp.ssdSize);

        //Method
        comp.setSsdSize(600);
        System.out.println(comp.ssdSize);

        //Property
        comp.vgaSize =6;
        System.out.println(comp.vgaSize);

        //Method
        comp.setVgaSize(4);
        System.out.println(comp.vgaSize);

    }
}