package main;
import item.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        double sum = 0;
        double discount = 0;
        int line = 0;
        String item1[][] = new String[7][4];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("G:\\1.txt"),"GBK"));
            String str = "";
            //while(br.readLine()!=null)
             //  line++;
            //line/=4;
            //item1 = new String[line][4];
            for(int m=0;m<item1.length;m++)
                for(int n=0;n<item1[m].length && (str = br.readLine())!= null;n++) {
                    item1[m][n] = str;
                    System.out.print(str);
                }

            br.close();
        //    String[][] item1 = {{"ITEM000000", "可口可乐", "瓶", "3.00"},
        //            {"ITEM000000", "可口可乐", "瓶", "3.00"},
        //            {"ITEM000000", "可口可乐", "瓶", "3.00"},
        //            {"ITEM000000", "可口可乐", "瓶", "3.00"},
        //            {"ITEM000001", "雪碧", "瓶", "3.00"},
        //            {"ITEM000001", "雪碧", "瓶", "3.00"},
        //            {"ITEM000004", "电池", "个", "2.00","0.8"}};
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("***商店购物清单***\n");
       // System.out.println(line);
        System.out.println("************\n");
        //Date date = new Date();
        //SimpleDateFormat f = new SimpleDateFormat("YYYY年MM月DD日 kk:mm:ss");
       // System.out.println("打印时间:" + f.format(date));
        System.out.println();
        List<Item> Shoppingcart = new ArrayList<Item>();
        int i,j;
       // boolean flag = false;
        if (Shoppingcart.size() == 0)
            Shoppingcart.add(new Item(item1[0]));
        for(i=1;i<7;i++) {
                for (j = 0; j < Shoppingcart.size(); j++) {
                    if (Shoppingcart.get(j).getName().equals(item1[i][1])) {
                        Shoppingcart.get(j).setNum(Shoppingcart.get(j).getNum() + 1);
                        break;
                    }
                    if (j == Shoppingcart.size()-1) {
                        Shoppingcart.add(new Item(item1[i]));
                        break;
                    }
                }
        }

        for (i = 0; i < Shoppingcart.size(); i++) {

            System.out.println("名称：" + Shoppingcart.get(i).getName() + "," + "数量：" + Shoppingcart.get(i).getNum() + Shoppingcart.get(i).getUnit() + "," + "单价：" +
                    Shoppingcart.get(i).getPrice() + "," + "(元)" + "," + "小计" + Shoppingcart.get(i).getTotal() + "(元)");
           //for(j=0;j<Shoppingcart.get(i).getNum();j++)
                sum += Shoppingcart.get(i).getTotal();
            discount+=Shoppingcart.get(i).getTotalDiscount();
        }
        System.out.println("************\n");
        System.out.println("总计：￥" + sum);
        System.out.println("总计：￥" + (float)discount);
    }
}



