package main;

import item.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Index> indexList = new ArrayList<Index>();
        List<Item> promotion = new ArrayList<Item>();
        List<Users> user = new ArrayList<Users>();

        ShoppingCart shoppingCart = new ShoppingCart();
        Index index = new Index();
        ProductList product = new ProductList();
        Users users = new Users();

        index.read(indexList);
        product.read();
        users.read(user);

        int i = 0;
        for (Users username : user) {
            if (username.getName().equals(product.getUserName())) {
                shoppingCart.vip = username.getVip();
                shoppingCart.score = username.getScore();
                break;
            }
            i++;
        }
        if (i == user.size()) {
            System.out.println("没有这个用户!");
        }
        i = 0;
        for (String barcode : product.getBarcode()) {
            if (barcode.equals(indexList.get(i).getBarcode())) {
                Item item = new Item(indexList.get(i));
                shoppingCart.add(item);
            } else {
                while (++i < indexList.size()) {
                    if (barcode.equals(indexList.get(i).getBarcode())) {
                        Item item = new Item(indexList.get(i));
                        shoppingCart.add(item);
                        break;
                    }
                }
                if (i >= indexList.size()) {
                    System.out.println("Barcode not found.");
                }
            }
        }
        double sum = 0;
        double discount = 0;

        for (Item a : shoppingCart.shoppingCart) {
            if (!shoppingCart.vip.equals("true")) {
                sum += a.getTotal();
                discount += a.getTotalDiscount();
            } else {
                sum += a.getVipTotal();
                discount += a.getVipTotalDiscount();
            }
        }

        System.out.println("***商店购物清单***");
        System.out.println("************");
        if (shoppingCart.score <= 200) {
            shoppingCart.score += (int) (sum / 5);
        } else if (shoppingCart.score > 200 && shoppingCart.score <= 500) {
            shoppingCart.score += (int) (sum / 5) * 3;
        } else if (shoppingCart.score > 500) {
            shoppingCart.score += (int) (sum / 5) * 5;
        }
        users.setScore(product.getUserName(), shoppingCart.score);
        System.out.println("会员编号："+product.getUserName()+"   "+"购物积分:"+shoppingCart.score);
        System.out.println("--------------------");
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月DD日 kk:mm:ss");
        System.out.println("打印时间:" + f.format(date));
        System.out.println("--------------------");
        sum = 0;
        discount = 0;

        for (Item a : shoppingCart.shoppingCart) {
            if (a.isPromotion() && a.getNum() >= 2) {
                promotion.add(a);
            }
            if (!shoppingCart.vip.equals("true")) {
                System.out.println(a.getName() + "，" +"数量：" +a.getNum() + a.getUnit() + "，" +"单价：" + String.format("%.2f",a.getPrice())+"(元)，小计：" + String.format("%.2f",a.getTotal())+"(元)");
                sum += a.getTotal();
                discount += a.getTotalDiscount();
            } else {
                System.out.println(a.getName() + "，" + "数量："+a.getNum() + a.getUnit() + "，" +"单价：" +String.format("%.2f",a.getPrice())+"(元)，小计：" + String.format("%.2f",a.getVipTotal())+"(元)");
                sum += a.getVipTotal();
                discount += a.getVipTotalDiscount();
            }
        }
        if (!promotion.isEmpty()) {
            System.out.println("--------------------");
            System.out.println("挥泪赠送");
            for (Item a : promotion) {
                System.out.println(a.getName() + "\t1" + a.getUnit());
            }
        }
        System.out.println("************");
        System.out.println("总计：" + String.format("%.2f",sum)+"(元)");
        System.out.println("节省：" + String.format("%.2f",discount)+"(元)");
    }
}

