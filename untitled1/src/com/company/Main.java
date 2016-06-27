package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String name;
        String unit;
        String barcode;
        float price;
        int code;
        int i;
        int[] h=new int[1000000];
        for(i=0;i<1000000;i++)
        {
            h[i]=0;
        }
        goods[] a=new goods[1000000];
        int choose;
        while(true)
        {
            Scanner in=new Scanner(System.in);
            System.out.print("barcode:");
            barcode=in.next();
            System.out.print("name:");
            name=in.next();
            System.out.print("unit:");
            unit=in.next();
            System.out.print("price:");
            price=in.nextFloat();
            code=(((int)(barcode.charAt(9)))-48)
                    +(((int)(barcode.charAt(8)))-48)*10
                    +(((int)(barcode.charAt(7)))-48)*100
                    +(((int)(barcode.charAt(6)))-48)*1000
                    +(((int)(barcode.charAt(5)))-48)*10000
                    +(((int)(barcode.charAt(4)))-48)*100000;
            if(h[code]==0)
            {
                a[code]=new goods(barcode,name,unit,price);
                h[code]++;
            }
            else
            {
                h[code]++;
            }
            System.out.println("If continue?1.yes\t2.no");
            choose=in.nextInt();
            if(choose==2)
            {
                break;
            }
        }
        System.out.println("***商店购物清单***");
        float total = 0;
        for(i=0;i<1000000;i++)
        {
            if(h[i]>0)
            {
                System.out.printf("名称:%s,数量:%d%s,单价:%.2f(元),小计:%.2f(元)\n",a[i].Getname(),h[i],a[i].Getunit(),a[i].Getprice(),a[i].Getprice()*h[i]);
                total+=(float)(a[i].Getprice()*h[i]);
            }
        }
        /*System.out.printf("名称:可口可乐,数量:%d,单价:3.00(元),小计:%d\n",c0,c0*3);
        System.out.printf("名称:雪碧,数量:%d,单价:3.00(元),小计:%d\n",c1,c1*3);
        System.out.printf("名称:电池,数量:%d,单价:2.00(元),小计:%d\n",c2,c2*2);*/
        System.out.printf("----------------\n");
        System.out.printf("总计:%.2f\n",total);

    }
}
