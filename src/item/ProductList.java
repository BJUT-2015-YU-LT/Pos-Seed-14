package item;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by 可 on 2016/1/5.
 */
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


    public void read() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("product4_2.txt"));
            String data;
            data = bufferedReader.readLine();
            while((data= bufferedReader.readLine())!=null && !data.equals("]")){
                this.barcode.add(data.substring(5, 15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


