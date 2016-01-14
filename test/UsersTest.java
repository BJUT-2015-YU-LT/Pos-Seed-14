/**
 * Created by Administrator on 2016/1/13.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import item.*;
import main.*;

public class UsersTest {

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
     * Method: getVip()
     */
    @Test
    public void testGetVip() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: setVip(String vip)
     */
    @Test
    public void testSetVip() throws Exception {
//TODO: Test goes here...
    }

    /**
     * Method: read(List<Users> user)
     */
    @Test
    public void testRead() throws Exception {
//TODO: Test goes here...

        try {
            List<Users> user = new ArrayList<Users>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("User.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String data = null;
            do {
                data = bufferedReader.readLine();
                if (data != null) {
                    stringBuilder.append(data);
                }
            } while (data != null);
            data = stringBuilder.toString().replaceAll("\"name\"|\"isVip\"|':|',| |\n|\t|\\{|'|\"", "");
            String c[] = data.substring(0, data.length() - 2).split("},");
            for (String d : c) {
                Users users = new Users(d.split(":"));
                user.add(users);
            }
            assertThat("true", equalTo(user.get(0).getVip()));
            assertThat("false", equalTo(user.get(1).getVip()));
            assertThat("true", equalTo(user.get(2).getVip()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
