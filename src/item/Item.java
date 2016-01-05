package item;
/**
 * Created by Administrator on 2016/1/5.
 */
import java.io.Serializable;


public class Item implements Serializable {


    private String barcode;
    private String name;
    private String unit;
    private double price;
    private int num;
    private double discount;
    private boolean promotion;


    public Item() {
    }
    public Item(String barcode,String name,String unit,String price,String discount) {
        setBarcode(barcode);
        setName(name);
        setUnit(unit);
        setPrice(Double.parseDouble(price));
        setDiscount(Double.parseDouble(discount));
        setNum(1);
    }

    public Item(String barcode,String name,String unit,String price) {
        setBarcode(barcode);
        setName(name);
        setUnit(unit);
        setPrice(Double.parseDouble(price));
        setDiscount(1);
        setNum(1);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        if (this.isPromotion() && this.getNum() >= 2) {
            setNum(getNum() + 1);
            return (getNum() - 1) * getPrice() * getDiscount();
        } else
            return getNum() * getPrice() * getDiscount();
    }
    public double getTotalDiscount() {
        return getNum() * getPrice() * (1-getDiscount());
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }
}
