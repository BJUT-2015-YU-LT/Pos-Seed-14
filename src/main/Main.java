package main;
import item.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double sum = 0;
        double discount = 0;
        JSONArray jsonArray = ReadFile();
        List<Item> Shoppingcart = new ArrayList<Item>();
        String name,barcode,unit,price,dis;
        int i,j,k;
        for(k=0;k<jsonArray.size();k++)
        {
            JSONObject json = jsonArray.getJSONObject(k);
            barcode = json.getString("barcode");
            name = json.getString("name");
            unit = json.getString("unit");
            price = json.getString("price");
            dis = json.getString("discount");
            Item item;
            if(!dis.equals("1"))
                 item = new Item(barcode, name, unit,price ,dis);
            else
                 item = new Item(barcode, name, unit, price);
            if (Shoppingcart.size()==0)
                Shoppingcart.add(item);
            else{
                for (j = 0; j < Shoppingcart.size(); j++) {
                    if (Shoppingcart.get(j).getBarcode().equals(barcode)) {
                        Shoppingcart.get(j).setNum(Shoppingcart.get(j).getNum() + 1);
                        break;
                    }
                    if (j == Shoppingcart.size() - 1) {
                        Shoppingcart.add(item);
                        break;
                    }
                }
           }
        }
        System.out.println("***商店购物清单***\n");
        System.out.println("************\n");
        System.out.println();
        for (i = 0; i < Shoppingcart.size(); i++) {
            System.out.println("名称：" + Shoppingcart.get(i).getName() + "," + "数量：" + Shoppingcart.get(i).getNum() + Shoppingcart.get(i).getUnit() + "," + "单价：" +
                    Shoppingcart.get(i).getPrice() + "," + "(元)" + "," + "小计" + (float)Shoppingcart.get(i).getTotal() + "(元)");
                sum += Shoppingcart.get(i).getTotal();
            discount+=Shoppingcart.get(i).getTotalDiscount();
        }
        System.out.println("************\n");
        System.out.println("总计：￥" + sum);
        System.out.println("折扣总计：￥" + (float)discount);
    }
    public static JSONArray ReadFile()
    {
        StringBuffer sb = new StringBuffer();
        String str = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("2.txt"),"GBK"));
            while((str=br.readLine())!=null)
                sb.append(str);
            str = sb.toString();
            br.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        JSONArray jsonArray = JSONArray.fromObject(str);
        return jsonArray;
    }

    public static List<Item> getShoppingCart(String inputStr) {
        List<Item> shoppingCart = new ArrayList<Item>();
        String name,barcode,unit,price;
        JSONArray jsonArray = JSONArray.fromObject(inputStr);
        for(int k=0;k<jsonArray.size();k++)
        {
            JSONObject json = jsonArray.getJSONObject(k);
            barcode = json.getString("barcode");
            name = json.getString("name");
            unit = json.getString("unit");
            price = json.getString("price");
            Item item = new Item(barcode, name, unit, price);
            shoppingCart.add(item);
        }
        return shoppingCart ;
    }
}



