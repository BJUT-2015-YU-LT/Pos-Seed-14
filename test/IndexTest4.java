import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2016/1/10.
 */
public class IndexTest4 {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getName()
     */
    @Test
    public void testGetName() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: setName(String name)
     */
    @Test
    public void testSetName() throws Exception {
//TODO: Test goes here...
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
     * Method: getUnit()
     */
    @Test
    public void testGetUnit() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: setUnit(String unit)
     */
    @Test
    public void testSetUnit() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: getPrice()
     */
    @Test
    public void testGetPrice() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: setPrice(double price)
     */
    @Test
    public void testSetPrice() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: getDiscount()
     */
    @Test
    public void testGetDiscount() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: setDiscount(double discount)
     */
    @Test
    public void testSetDiscount() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: isPromotion()
     */
    @Test
    public void testIsPromotion() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: setPromotion(boolean promotion)
     */
    @Test
    public void testSetPromotion() throws Exception {
//TODO: Test goes here...
    }


    @Test
    public void testName() throws Exception {

    }

    /**
     * Method: read(List<Index> indexList)
     */
    /**
     * Method: read(List<Index> indexList)
     */
    @Test
    public void testRead() throws Exception {
//TODO: Test goes here...
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("index4.txt"),"GBK"));
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
                } else if (childKey.equals("promotion")) {
                    index.setPromotion(Boolean.parseBoolean(jChildObject.get(childKey).toString()));
                }
                }
                   System.out.println(index.getName() + "," +  index.getUnit() + "," + (float) index.getPrice()+","+index.isPromotion());

                  assertThat("可口可乐", is(index.getName()));
                  assertThat("瓶", is(index.getUnit()));
                  assertThat(3.0, is(index.getPrice()));
                  assertThat(true, is(index.isPromotion()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}






