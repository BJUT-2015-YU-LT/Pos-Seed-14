package item;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductList implements Serializable {
    private List<String> barcode;
    private String userName;

    public ProductList() {
        barcode = new ArrayList<String>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getBarcode() {
        return barcode;
    }

    public void setBarcode(List<String> barcode) {
        this.barcode = barcode;
    }

    public void deleteProductList(List<Index> indexList, String index) {
        for (int n = 0; n < indexList.size(); n++) {
            if (indexList.get(n).getBarcode().equals(index)) {
                indexList.remove(n);
                System.out.println("商品已删除");
            } else {
                System.out.println("商品不存在");
            }
        }
    }

    public void read() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("ProductList.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            do {
                String data = bufferedReader.readLine();
                stringBuilder.append(data);
            } while (!stringBuilder.toString().replaceAll(" ", "").endsWith("}"));
            String input = stringBuilder.toString();
            String c[] = input.replaceAll(" |\n|\t|\\{|\\}|'user':|'|’|items", "").split(",:");
            for (int n = 0; n < c.length; n++) {
                //   product.setBarcode(d);
                //  productList.add(product);
                if (n == 0) {
                    this.setUserName(c[0]);
                } else {
                    String[] item = c[1].replaceAll("\\[|\\]", "").split(",");
                    for (String d : item) {
                        this.getBarcode().add(d);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
