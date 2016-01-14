package item;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import java.lang.String;
import java.util.List;

public class Index implements Serializable {
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private double discount;
    private double vipDiscount;
    private boolean promotion;

    public Index() {
        setDiscount(1);
        setVipDiscount(1);
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
    
    //添加Index索引文件功能
    public Index(List<Index> indexList) {
        System.out.println("输入索引文件:" );
        Scanner in = new Scanner(System.in);
        StringBuilder inputStr = new StringBuilder();
        do {
            inputStr.append(in.nextLine());
        } while (!inputStr.toString().replaceAll(" ", "" ).endsWith("}}" ));
        String a = inputStr.toString();
        String c[] = a.substring(0, a.length() - 2).split("}," );
        for (String d : c) {
            Index index = new Index(d.replaceAll("\\'\\:|\\{|\\'|name|unit|price|discount|promotion| |\\'|\\,|，", "").split(":"));
            indexList.add(index);
        }
        indexList.sort(new SortIndex());
    }
    //手动删除功能
    public void deleteIndex(List<ProductList> productList, String index) {
        for (int n = 0; n < productList.size(); n++) {
            if (productList.get(n).getBarcode().equals(index)) {
                productList.remove(n);
                System.out.println("索引已删除");
            } else {
                System.out.println("该索引不存在");
            }
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

    public double getVipDiscount() {
        return vipDiscount;
    }

    public void setVipDiscount(double vipDiscount) {
        this.vipDiscount = vipDiscount;
    }



    public void read(List<Index> indexList) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Index.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String data = null;
            do {
                data = bufferedReader.readLine();
                if (data != null) {
                    stringBuilder.append(data);
                }
            } while (data != null);
            JSONObject jObject = new JSONObject(stringBuilder.toString());
            Iterator keys = jObject.keys();
            while (keys.hasNext()) {
                Index index = new Index();
                String barcode = (String) keys.next();
                index.setBarcode(barcode);
                JSONObject jChildObject = jObject.getJSONObject(barcode);
                Iterator childKeys = jChildObject.keys();
                while (childKeys.hasNext()) {
                    String childKey = (String) childKeys.next();
                    if (childKey.equals("unit")) {
                        index.setUnit(jChildObject.get(childKey).toString());
                    } else if (childKey.equals("price")) {
                        index.setPrice(Double.parseDouble(jChildObject.get(childKey).toString()));
                    } else if (childKey.equals("name")) {
                        index.setName(jChildObject.get(childKey).toString());
                    } else if (childKey.equals("discount")) {
                        index.setDiscount(Double.parseDouble(jChildObject.get(childKey).toString()));
                    } else if (childKey.equals("promotion")) {
                        index.setPromotion(Boolean.parseBoolean(jChildObject.get(childKey).toString()));
                    } else if (childKey.equals("vipDiscount")) {
                        index.setVipDiscount(Double.parseDouble(jChildObject.get(childKey).toString()));
                    }
                }
                indexList.add(index);
            }
            Collections.sort(indexList, new Comparator<Index>() {
                @Override
                public int compare(Index o1, Index o2) {
                    Index s1 = (Index) o1;
                    Index s2 = (Index) o2;
                    return s1.getBarcode().compareTo(s2.getBarcode());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class SortIndex implements Comparator {
    public int compare(Object o1, Object o2) {
        Index s1 = (Index) o1;
        Index s2 = (Index) o2;
        return s1.getBarcode().compareTo(s2.getBarcode());
    }
}
