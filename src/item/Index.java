package item;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/1/5.
 */
public class Index implements Serializable {
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private double discount;
    private boolean promotion;

    public Index() {
        setDiscount(1);
    }

    public Index(String a[]) {
        setBarcode(a[0]);
        setName(a[1]);
        setUnit(a[2]);
        setPrice(Double.parseDouble(a[3]));
        if (a.length == 5) {
            if (a[4].equals("true")) {
                setPromotion(true);
                setDiscount(1);
            } else {
                setPromotion(false);
                setDiscount(Double.parseDouble(a[4]));
            }
        } else {
            setDiscount(1);
            setPromotion(false);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

}
