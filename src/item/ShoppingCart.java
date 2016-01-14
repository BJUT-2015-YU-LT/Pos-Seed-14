package item;

import java.util.ArrayList;

/**
 * Created by 可 on 2016/1/6.
 */
public class ShoppingCart {
    private ArrayList<Item> cart = new ArrayList<Item>();

    public ShoppingCart(){}

    public void add(Item item) {
        this.cart.add(item);
    }

    public ArrayList<Item> getCart() {
        return cart;
    }
}
