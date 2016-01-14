package item;
import org.json.JSONObject;
import java.io.*;
import java.util.Iterator;
import java.util.List;
public class Users implements Serializable {
    private String name;
    private String vip;
    private String code;
    private int score;
    public Users() {
    }
    public Users(String[] a) {
        setCode(a[0]);
        setName(a[1]);
        setVip(a[2]);
    }
    public void read(List<Users> user) {
        try {
            //读用户会员信息
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
            //读购物积分文件
            BufferedReader bufferedReader_ = new BufferedReader(new FileReader("UserScore.txt"));
            StringBuilder stringBuilder_ = new StringBuilder();
            String data_;
            do {
                data_ = bufferedReader_.readLine();
                if (data_ != null) {
                    stringBuilder_.append(data_);
                }
            } while (data_ != null);
            bufferedReader_.close();
            JSONObject jObject = new JSONObject(stringBuilder_.toString());
            Iterator userCodes = jObject.keys();
            while (userCodes.hasNext()) {
                String userCode = (String) userCodes.next();
                for (int i = 0; i < user.size(); i++) {
                    if (user.get(i).getCode().equals(userCode)) {
                        user.get(i).setScore(jObject.getJSONObject(userCode).getInt("score"));
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScore(String username, int score) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("UserScore.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String data;
            do {
                data = bufferedReader.readLine();
                if (data != null) {
                    stringBuilder.append(data);
                }
            } while (data != null);
            bufferedReader.close();
            JSONObject jObject = new JSONObject(stringBuilder.toString());
            String userCode = null;
            Iterator userCodes = jObject.keys();
            while (userCodes.hasNext()) {
                userCode = (String) userCodes.next();
                if (username.equals(jObject.getJSONObject(userCode).getString("name")) || username.equals(jObject.getJSONObject(userCode).getString("name").replaceAll(" ", ""))) {
                    break;
                }
            }
            jObject.getJSONObject(userCode).put("score", score);
            BufferedWriter jWriter = new BufferedWriter(new FileWriter("UserScore.txt"));
            jObject.write(jWriter);
            jWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
