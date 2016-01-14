/**
 * Created by Administrator on 2016/1/10.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class ProductListTest3 {

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
            BufferedReader bufferedReader = new BufferedReader(new FileReader("4.txt"));
            String data;
            data = bufferedReader.readLine();
            while((data= bufferedReader.readLine())!=null && !data.equals("]")){
                productList.getBarcode().add(data.substring(5, 15));
            }
            assertThat("ITEM000000", equalTo(productList.getBarcode().get(0)));
            assertThat("ITEM000000", equalTo(productList.getBarcode().get(1)));
            assertThat("ITEM000000", equalTo(productList.getBarcode().get(1)));
            assertThat("ITEM000000", equalTo(productList.getBarcode().get(2)));
            assertThat("ITEM000000", equalTo(productList.getBarcode().get(4)));
            assertThat("ITEM000001", equalTo(productList.getBarcode().get(5)));
            assertThat("ITEM000001", equalTo(productList.getBarcode().get(6)));
            assertThat("ITEM000004", equalTo(productList.getBarcode().get(7)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
