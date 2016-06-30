package ruangong1;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        String name;
        String unit;
        String barcode = null;
        String pricee;
        float price;
        float discount;
        int code;
        int i;
        int[] h=new int[1000000];
        for(i=0;i<1000000;i++)
        {
            h[i]=0;
        }
        goods[] a=new goods[1000000];
        int j=0;
        while(true)
        {
            if(j<5) {
                barcode = "ITEM000000";
                name = "可口可乐";
                unit = "瓶";
                pricee = "3.00";
                discount=1;
            }
            else if(j==5)
            {
                barcode="ITEM000001";
                name="雪碧";
                unit="瓶";
                pricee="3.00";
                discount=(float) 0.8;
            }
            else if(j==6)
            {
                barcode="ITEM000001";
                name="雪碧";
                unit="瓶";
                pricee="3.00";
                discount=(float) 0.8;
            }
            else
            {
                barcode="ITEM000004";
                name="电池";
                unit="个";
                pricee="2.00";
                discount=(float)0.5;
            }
            code=(((int)(barcode.charAt(9)))-48)
                    +(((int)(barcode.charAt(8)))-48)*10
                    +(((int)(barcode.charAt(7)))-48)*100
                    +(((int)(barcode.charAt(6)))-48)*1000
                    +(((int)(barcode.charAt(5)))-48)*10000
                    +(((int)(barcode.charAt(4)))-48)*100000;
            if(h[code]==0)
            {
                price=(float)(((float)((int)((pricee.charAt(3))-48)))*0.01)
                        +(float)(((float)((int)((pricee.charAt(2))-48)))*0.1)
                        +(float)((int)((pricee.charAt(0))-48));
                a[code]=new goods(barcode,name,unit,price,discount);
                h[code]++;
            }
            else
            {
                h[code]++;
            }
            if(j==7)
            {
                break;
            }
            j++;
        }
        System.out.println("***商店购物清单***");
        float total=0;
        float save=0;
        for(i=0;i<1000000;i++)
        {
            if(h[i]>0)
            {
                System.out.printf("名称:%s,数量:%d%s,单价:%.2f(元),小计:%.2f(元)\n",a[i].Getname(),h[i],a[i].Getunit(),a[i].Getprice(),a[i].Getprice()*h[i]*a[i].Getdiscount());
                total+=(float)(a[i].Getprice()*h[i]*a[i].Getdiscount());
                save+=(float)(a[i].Getprice()*h[i]*(1-a[i].Getdiscount()));
            }
        }
        /*System.out.printf("名称:可口可乐,数量:%d,单价:3.00(元),小计:%d\n",c0,c0*3);
        System.out.printf("名称:雪碧,数量:%d,单价:3.00(元),小计:%d\n",c1,c1*3);
        System.out.printf("名称:电池,数量:%d,单价:2.00(元),小计:%d\n",c2,c2*2);*/
        System.out.printf("----------------\n");
        System.out.printf("总计:%.2f(元)\n",total);
        System.out.printf("节省:%.2f(元)\n",save);
        System.out.printf("********************\n");
    }
    public static class goods
    {
        private String barcode;
        private String name;
        private String unit;
        private float price;
        private float discount;
        goods(String a,String b,String c,float d,float e)
        {
            barcode=a;
            name=b;
            unit=c;
            price=d;
            discount=e;
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
        public float Getdiscount()
        {
            return discount;
        }
    }

}
