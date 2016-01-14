/**
 * Created by Administrator on 2016/1/13.
 */

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

public class IndexTest {

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
    @Test
    public void testgetVipDiscount() throws Exception {
//TODO: Test goes here...
    }
    @Test
    public void testsetVipDiscount() throws Exception {
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

    /**
     * Method: deleteIndex(List<ProductList> productList, String index)
     */
    @Test
    public void testDeleteIndex() throws Exception {
//TODO: Test goes here...
    }

    @Test
    public void testName() throws Exception {

    }

    /**
     * Method: read(List<Index> indexList)
     */
    @Test
    public void testRead() throws Exception {
//TODO: Test goes here...
        List<Index> indexList = new ArrayList<Index>();
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
                    }else if (childKey.equals("promotion")) {
                        index.setPromotion(Boolean.parseBoolean(jChildObject.get(childKey).toString()));
                    }
                    else if (childKey.equals("vipDiscount")) {
                        index.setVipDiscount(Double.parseDouble(jChildObject.get(childKey).toString()));
                    }
                }
                indexList.add(index);
                Collections.sort(indexList, new Comparator<Index>() {
                    @Override
                    public int compare(Index o1, Index o2) {
                        Index s1 = (Index) o1;
                        Index s2 = (Index) o2;
                        return s1.getBarcode().compareTo(s2.getBarcode());
                    }
                });

            }
            for(Index index : indexList)
            {
                System.out.println(index.getName() + "," +  index.getUnit() + "," + (float) index.getPrice() + "," +index.getDiscount()+","+index.isPromotion()+","+index.getVipDiscount());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    }


