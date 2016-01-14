/**
 * Created by Administrator on 2016/1/13.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import item.*;
import main.*;

public class ProductListTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getBarcode()
     */
    @Test
    public void testGetBarcode() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: setBarcode(String barcode)
     */
    @Test
    public void testSetBarcode() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: deleteProductList(List<Index> indexList, String index)
     */
    @Test
    public void testDeleteProductList() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: read(List<ProductList> productList)
     */
    @Test
    public void testRead() throws Exception {
//TODO: Test goes here...
        try {
            ProductList productList = new ProductList();

            BufferedReader bufferedReader = new BufferedReader(new FileReader("PL.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            do {
                String data = bufferedReader.readLine();
                stringBuilder.append(data);
            } while (!stringBuilder.toString().replaceAll(" ", "").endsWith("}"));
            String input = stringBuilder.toString();
            String c[] = input.replaceAll(" |\n|\t|\\{|\\}|'user':|'|items", "").split(",:");
            for (int n = 0; n < c.length; n++) {
                if (n == 0) {
                    productList.setUserName(c[0]);
                } else {
                    String[] item = c[1].replaceAll("\\[|\\]", "").split(",");
                    for (String d : item) {
                        productList.getBarcode().add(d);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
