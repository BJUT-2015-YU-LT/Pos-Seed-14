package item;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public List<Item>  shoppingCart = new ArrayList<Item>();
    public String vip;
    public int score;
    public void add(Item item) {
        if (shoppingCart.size() == 0) {
            shoppingCart.add(item);
        } else if (shoppingCart.get(shoppingCart.size() - 1).getBarcode().equals(item.getBarcode())) {
            shoppingCart.get(shoppingCart.size() - 1).setNum(shoppingCart.get(shoppingCart.size() - 1).getNum() + 1);
        } else {
            shoppingCart.add(item);
        }
    }
}
