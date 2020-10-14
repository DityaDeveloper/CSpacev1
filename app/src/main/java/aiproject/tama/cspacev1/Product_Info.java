package aiproject.tama.cspacev1;

public class Product_Info {


    private String name;
    private String tempat;
    private String ulasan;

    public Product_Info() {
    }

    public Product_Info( String name,  String ulasan, String tempat) {
        this.name = name;
        this.tempat = tempat;
        this.ulasan = ulasan;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getUlasan() {
        return ulasan;
    }

    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }

}