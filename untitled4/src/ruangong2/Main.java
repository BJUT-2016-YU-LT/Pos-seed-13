package ruangong2;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String name;
        String unit;
        String barcode;
        float price;
        int code;
        int i;
        int[] h=new int[1000000];
        int[] c=new int[1000000];
        for(i=0;i<1000000;i++)
        {
            h[i]=0;
            c[i]=0;
        }
        goods[] a=new goods[1000000];
        int choose;
        Scanner in=new Scanner(System.in);
        while(true)
        {
            System.out.print("barcode:");
            barcode=in.next();
            System.out.print("name:");
            name=in.next();
            System.out.print("unit:");
            unit=in.next();
            System.out.print("price:");
            price=in.nextFloat();
            code=(((int)(barcode.charAt(0)))-48)+(((int)(barcode.charAt(1)))-48)*10+(((int)(barcode.charAt(2)))-48)*100+(((int)(barcode.charAt(3)))-48)*1000+(((int)(barcode.charAt(4)))-48)*10000+(((int)(barcode.charAt(5)))-48)*100000;
            a[code]=new goods(barcode,name,unit,price);
            System.out.println("If continue?1.yes\t2.no");
            choose=in.nextInt();
            if(choose==2)
            {
                break;
            }
        }
        System.out.println("请输入购买商品列表");
        while(true)
        {
            barcode=in.next();
            code=(((int)(barcode.charAt(0)))-48)+(((int)(barcode.charAt(1)))-48)*10+(((int)(barcode.charAt(2)))-48)*100+(((int)(barcode.charAt(3)))-48)*1000+(((int)(barcode.charAt(4)))-48)*10000+(((int)(barcode.charAt(5)))-48)*100000;
            h[code]++;
            choose=in.nextInt();
            if(choose==2)
            {
                break;
            }
        }
        System.out.printf("***商店购物清单***\n");
        System.out.printf("打印时间：2016年06月27日 08:41:05\n");
        System.out.printf("----------------\n");
        float total = 0;
        float totalcount=0;
        float count;
        for(i=0;i<1000000;i++)
        {
            if(h[i]>0)
            {
                count=(float)(a[i].Getprice()*(int)(h[i]/3));
                System.out.printf("名称:%s,数量:%d%s,单价:%.2f(元),小计:%.2f(元)\n",a[i].Getname(),h[i],a[i].Getunit(),a[i].Getprice(),a[i].Getprice()*(h[i]-h[i]/3));
                total+=(float)(a[i].Getprice()*h[i]);
                totalcount+=count;
                c[i]=h[i]/3;
            }
        }
        /*System.out.printf("名称:可口可乐,数量:%d,单价:3.00(元),小计:%d\n",c0,c0*3);
        System.out.printf("名称:雪碧,数量:%d,单价:3.00(元),小计:%d\n",c1,c1*3);
        System.out.printf("名称:电池,数量:%d,单价:2.00(元),小计:%d\n",c2,c2*2);*/
        System.out.printf("----------------\n");
        System.out.printf("挥泪赠送商品：\n");
        for(i=0;i<1000000;i++)
        {
            if(c[i]>0)
            {
                System.out.printf("名称:%s,数量:%d%s\n",a[i].Getname(),c[i],a[i].Getname());
            }
        }
        System.out.printf("----------------\n");
        System.out.printf("总计:%.2f\n",total);
        System.out.printf("节省:%.2f\n",totalcount);
        System.out.printf("******************\n");
    }
    public static class goods
    {
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

}
