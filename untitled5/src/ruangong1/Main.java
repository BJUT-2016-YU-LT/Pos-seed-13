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
        String discountt;
        String vipp;
        String x;
        float price;
        float discount=1;
        float vip = 1;
        int code;
        int i;
        int[] h=new int[1000000];
        int[] c=new int[1000000];
        boolean[] d=new boolean[10000];
        String[] e=new String[10000];
        for(i=0;i<10000;i++)
        {
            d[i]=false;
            e[i]=null;
        }
        Scanner in=new Scanner(System.in);
        in.next();
        while(true)
        {
            barcode=in.next();
            if(barcode.charAt(0)!="'".charAt(0))break;
            barcode=barcode.substring(1,barcode.length()-2);

            in.next();
            code=(((int)(barcode.charAt(7)))-48)+(((int)(barcode.charAt(6)))-48)*10+(((int)(barcode.charAt(5)))-48)*100+(((int)(barcode.charAt(4)))-48)*1000;
            in.next();
            name=in.next();
            name=name.substring(1,name.length()-2);
            e[code]=name;
            in.next();
            x=in.next();
            if(x.charAt(0)=='f')d[code]=false;
            else d[code]=true;
            in.next();
        }
        for(i=0;i<1000000;i++)
        {
            h[i]=0;
        }
        goods[] a=new goods[1000000];
        in.next();
        while(true)
        {
            barcode=in.next();
            if(barcode.charAt(0)!="'".charAt(0))break;
            barcode=barcode.substring(1,barcode.length()-2);
            in.next();
            in.next();
            name=in.next();
            name=name.substring(1,name.length()-2);
            in.next();
            unit=in.next();
            unit=unit.substring(1,unit.length()-2);
            in.next();
            pricee=in.next();
            if(pricee.charAt(pricee.length()-1)==',')
                pricee=pricee.substring(0,pricee.length()-1);
            x=in.next();
            if(x.length()>=2 && (x.charAt(0)=='d' || x.charAt(1)=='d'))
            {
                discountt=in.next();
                if(discountt.charAt(discountt.length()-1)==',')
                    discountt=discountt.substring(0,discountt.length()-1);
                discount=(float)(((float)((int)((discountt.charAt(3))-48)))*0.01)+(float)(((float)((int)((discountt.charAt(2))-48)))*0.1)+(float)((int)((discountt.charAt(0))-48));
            }
            else if(x.length()>=2 && (x.charAt(0)=='p' || x.charAt(1)=='p'))
            {
                in.next();
                discount=-1;
            }
            else if(x.length()>=2 && (x.charAt(0)=='v' || x.charAt(1)=='v'))
            {
                vipp=in.next();
                if(vipp.charAt(vipp.length()-1)==',')
                    vipp=vipp.substring(0,vipp.length()-1);
                vip=(float)(((float)((int)((vipp.charAt(3))-48)))*0.01)+(float)(((float)((int)((vipp.charAt(2))-48)))*0.1)+(float)((int)((vipp.charAt(0))-48));
                discount=1;
            }
            else
            {
                code=(((int)(barcode.charAt(9)))-48)+(((int)(barcode.charAt(8)))-48)*10+(((int)(barcode.charAt(7)))-48)*100+(((int)(barcode.charAt(6)))-48)*1000+(((int)(barcode.charAt(5)))-48)*10000+(((int)(barcode.charAt(4)))-48)*100000;
                price=(float)(((float)((int)((pricee.charAt(3))-48)))*0.01)+(float)(((float)((int)((pricee.charAt(2))-48)))*0.1)+(float)((int)((pricee.charAt(0))-48));
                a[code]=new goods(barcode,name,unit,price,discount,vip);
                continue;
            }
            x=in.next();
            if(x.length()>=2 && (x.charAt(0)=='d' || x.charAt(1)=='d'))
            {
                discountt=in.next();
                if(discountt.charAt(discountt.length()-1)==',')
                    discountt=discountt.substring(0,discountt.length()-1);
                discount=(float)(((float)((int)((discountt.charAt(3))-48)))*0.01)+(float)(((float)((int)((discountt.charAt(2))-48)))*0.1)+(float)((int)((discountt.charAt(0))-48));
                in.next();
            }
            else if(x.length()>=2 && (x.charAt(0)=='p' || x.charAt(1)=='p'))
            {
                in.next();
                discount=-1;
                in.next();
            }
            else if(x.length()>=2 && (x.charAt(0)=='v' || x.charAt(1)=='v'))
            {
                vipp=in.next();
                if(vipp.charAt(vipp.length()-1)==',')
                    vipp=vipp.substring(0,vipp.length()-1);
                vip=(float)(((float)((int)((vipp.charAt(3))-48)))*0.01)+(float)(((float)((int)((vipp.charAt(2))-48)))*0.1)+(float)((int)((vipp.charAt(0))-48));
                in.next();
            }
            code=(((int)(barcode.charAt(9)))-48)+(((int)(barcode.charAt(8)))-48)*10+(((int)(barcode.charAt(7)))-48)*100+(((int)(barcode.charAt(6)))-48)*1000+(((int)(barcode.charAt(5)))-48)*10000+(((int)(barcode.charAt(4)))-48)*100000;
            /*if(h[code]==0)
            {*/
            price=(float)(((float)((int)((pricee.charAt(3))-48)))*0.01)+(float)(((float)((int)((pricee.charAt(2))-48)))*0.1)+(float)((int)((pricee.charAt(0))-48));
            a[code]=new goods(barcode,name,unit,price,discount,vip);
            	/*h[code]++;
            }
            else
            {
            	h[code]++;
            }*/
        }
        in.next();
        in.next();
        name=in.next();
        name=name.substring(1,name.length()-2);
        boolean pd=true;
        int j;
        for(i=0;i<10;i++)
        {
            if(e[i]!=null && e[i].length()==name.length())
            {
                for(j=0;j<e[i].length();j++)
                {
                    if(e[i].charAt(j)!=name.charAt(j))
                    {
                        pd=false;
                        break;
                    }
                }
            }
            if(pd==true)
                break;
        }
        in.next();
        in.next();
        while(true)
        {
            barcode=in.next();
            if(barcode.charAt(0)!="'".charAt(0))break;
            if(barcode.charAt(barcode.length()-1)==',')
                barcode=barcode.substring(1,barcode.length()-2);
            else
                barcode=barcode.substring(1,barcode.length()-1);
            code=(((int)(barcode.charAt(9)))-48)+(((int)(barcode.charAt(8)))-48)*10+(((int)(barcode.charAt(7)))-48)*100+(((int)(barcode.charAt(6)))-48)*1000+(((int)(barcode.charAt(5)))-48)*10000+(((int)(barcode.charAt(4)))-48)*100000;
            h[code]++;
        }
        in.next();
        System.out.println("***商店购物清单***");
        float total=0;
        float save=0;
        float totalcount=0;
        float count;
        for(i=0;i<1000000;i++)
        {
            if(h[i]>0)
            {
                if(a[i].Getdiscount()==-1)
                {
                    count=(float)(a[i].Getprice()*(int)(h[i]/3));
                    System.out.printf("名称:%s,数量:%d%s,单价:%.2f(元),小计:%.2f(元)\n",a[i].Getname(),h[i],a[i].Getunit(),a[i].Getprice(),a[i].Getprice()*(h[i]-h[i]/3));
                    total+=(float)(a[i].Getprice()*(h[i]-h[i]/3));
                    totalcount+=count;
                    c[i]=h[i]/3;
                }
                else
                {
                    if(pd==false)
                    {
                        System.out.printf("名称:%s,数量:%d%s,单价:%.2f(元),小计:%.2f(元)\n",a[i].Getname(),h[i],a[i].Getunit(),a[i].Getprice(),a[i].Getprice()*h[i]*a[i].Getdiscount());
                        total+=(float)(a[i].Getprice()*h[i]*a[i].Getdiscount());
                        save+=(float)(a[i].Getprice()*h[i]*(1-a[i].Getdiscount()));
                    }
                    else
                    {
                        System.out.printf("名称:%s,数量:%d%s,单价:%.2f(元),小计:%.2f(元)\n",a[i].Getname(),h[i],a[i].Getunit(),a[i].Getprice(),a[i].Getprice()*h[i]*a[i].Getdiscount()*a[i].Getvip());
                        total+=(float)(a[i].Getprice()*h[i]*a[i].Getdiscount()*a[i].Getvip());
                        save+=(float)(a[i].Getprice()*h[i]*(1-a[i].Getdiscount()*a[i].Getvip()));
                    }
                }
            }
        }
        /*System.out.printf("名称:可口可乐,数量:%d,单价:3.00(元),小计:%d\n",c0,c0*3);
        System.out.printf("名称:雪碧,数量:%d,单价:3.00(元),小计:%d\n",c1,c1*3);
        System.out.printf("名称:电池,数量:%d,单价:2.00(元),小计:%d\n",c2,c2*2);*/
        boolean pdd=false;
        for(i=0;i<1000000;i++)
        {
            if(c[i]>0)
            {
                if(pdd==false)
                {
                    System.out.printf("----------------\n");
                    System.out.printf("挥泪赠送商品：\n");
                    pdd=true;
                }
                System.out.printf("名称:%s,数量:%d%s\n",a[i].Getname(),c[i],a[i].Getname());
            }
        }
        System.out.printf("----------------\n");
        System.out.printf("总计:%.2f(元)\n",total);
        System.out.printf("节省:%.2f(元)\n",save+totalcount);
        System.out.printf("********************\n");
    }
    public static class goods
    {
        private String barcode;
        private String name;
        private String unit;
        private float price;
        private float discount;
        private float vip;
        goods(String a,String b,String c,float d,float e,float f)
        {
            barcode=a;
            name=b;
            unit=c;
            price=d;
            discount=e;
            vip=f;
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
        public float Getvip()
        {
            return vip;
        }
    }

}
