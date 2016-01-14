
import java.util.ArrayList;

import java.lang.String;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class Maintest{

    @Test
    public void testMain() throws Exception {

    }

    @Test
    public void testIndex() throws Exception {

    }

    @Test
    public void testReadFile() throws Exception {

    }
    @Test
    public void test() throws Exception{
        String inputString = " [\n" +
                "    {\n" +
                "        barcode: 'ITEM000000',\n" +
                "        name: '可口可乐',\n" +
                "        unit: '瓶',\n" +
                "        price: 3.00\n" +
                "    },\n" +
                "    {\n" +
                "        barcode: 'ITEM000000',\n" +
                "        name: '可口可乐',\n" +
                "        unit: '瓶',\n" +
                "        price: 3.00\n" +
                "    },\n" +
                "    {\n" +
                "        barcode: 'ITEM000000',\n" +
                "        name: '可口可乐',\n" +
                "        unit: '瓶',\n" +
                "        price: 3.00\n" +
                "    },\n" +
                "    {\n" +
                "        barcode: 'ITEM000000',\n" +
                "        name: '可口可乐',\n" +
                "        unit: '瓶',\n" +
                "        price: 3.00\n" +
                "    },\n" +
                "    {\n" +
                "        barcode: 'ITEM000000',\n" +
                "        name: '可口可乐',\n" +
                "        unit: '瓶',\n" +
                "        price: 3.00\n" +
                "    },\n" +
                "    {\n" +
                "        barcode: 'ITEM000001',\n" +
                "        name: '雪碧',\n" +
                "        unit: '瓶',\n" +
                "        price: 3.00\n" +
                "    },\n" +
                "    {\n" +
                "        barcode: 'ITEM000001',\n" +
                "        name: '雪碧',\n" +
                "        unit: '瓶',\n" +
                "        price: 3.00\n" +
                "    },\n" +
                "    {\n" +
                "        barcode: 'ITEM000004',\n" +
                "        name: '电池',\n" +
                "        unit: '个',\n" +
                "        price: 2.00\n" +
                "    }\n" +
                "]\n";
        List<Item> expected = new ArrayList<Item>();
        String[] item1 = {"ITEM000000", "可口可乐", "瓶", "3.00"};
        String[] item2 = {"ITEM000001", "雪碧", "瓶", "3.00"};
        String[] item3 = {"ITEM000004", "电池", "个", "2.00"};
        expected.add(new Item(item1));
        expected.add(new Item(item1));
        expected.add(new Item(item1));
        expected.add(new Item(item1));
        expected.add(new Item(item1));
        expected.add(new Item(item2));
        expected.add(new Item(item2));
        expected.add(new Item(item3));
        List<Item> actual = Main.getShoppingCart(inputString);
        assertThat(expected.size(), is(actual.size()));
        for (int i = 0; i < expected.size(); i++) {
            assertThat(expected.get(i).getBarcode(), is(actual.get(i).getBarcode()));
            assertThat(expected.get(i).getDiscount(), is(actual.get(i).getDiscount()));
            assertThat(expected.get(i).getUnit(), is(actual.get(i).getUnit()));
            assertThat(expected.get(i).getName(), is(actual.get(i).getName()));
            assertThat(expected.get(i).getPrice(), is(actual.get(i).getPrice()));
        }

    }
}
