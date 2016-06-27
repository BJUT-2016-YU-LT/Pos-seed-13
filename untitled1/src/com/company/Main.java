package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String name;
        String unit;
        String barcode;
        float price;
        int c0=0,c1=0,c2=0;
        int choose;
        while(c0<100)
        {
            System.out.print("barcode:");
            Scanner in=new Scanner(System.in);
            barcode=in.next();
            System.out.print("name:");
            name=in.next();
            System.out.print("unit:");
            unit=in.next();
            System.out.print("price:");
            price=in.nextFloat();
            String barcode0="ITEM000000";
            String barcode1="ITEM000001";
            String barcode4="ITEM000004";
            if(barcode.equals(barcode0))
            {
                c0=c0+1;
            }
            if(barcode.equals(barcode1))
            {
                c1=c1+1;
            }
            if(barcode.equals(barcode4))
            {
                c2=c2+1;
            }
            System.out.println("If continue?1.yes\t2.no");
            choose=in.nextInt();
            if(choose==2)
            {
                break;
            }
        }
        System.out.println("***商店购物清单***");
        System.out.printf("名称:可口可乐,数量:%d,单价:3.00(元),小计:%d\n",c0,c0*3);
        System.out.printf("名称:雪碧,数量:%d,单价:3.00(元),小计:%d\n",c1,c1*3);
        System.out.printf("名称:电池,数量:%d,单价:2.00(元),小计:%d\n",c2,c2*2);
        System.out.printf("----------------\n");
        System.out.printf("总计:%d\n",c0*3+c1*3+c2*2);

    }
}
