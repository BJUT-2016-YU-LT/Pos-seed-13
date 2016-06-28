
public class goods {
    private String barcode;
    private String name;
    private String unit;
    private float price;
    goods(String a,String b,String c,float d)
    {
        barcode=a;
        name=b;
        unit=c;
        price=d;
    }
    public String Getbarcode()
    {
        return barcode;
    }
    public String Getname()
    {
        return name;
    }
    public String Getunit()
    {
        return unit;
    }
    public float Getprice()
    {
        return price;
    }

}
