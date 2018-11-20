package com.fap.speak24;

import android.util.Log;

import com.fap.speak24.model.User;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParseHelper {
    public static List<User> parse(String html){
        List<User> users = new ArrayList<>();
        try {
            Document doc = Jsoup.parse(html);
            // #partners .userListBody table tr
            Elements userListBody = doc.select("table.raport_data");
            Elements status = doc.select("tr.evenC,tr.oddC");

            for(int i=0; i <userListBody.size(); i++){
                try {
                    Element element = userListBody.get(i);
                    Element element1 = status.get(i);

                    Elements tds = element.select("td");

                    User user = new User();
                    String nick = tds.get(1).text();
                    user.setNick(nick);
                    String sex = tds.get(2).select("img").first().attr("alt");
                    user.setSex(sex);
                    String level = tds.get(3).select("img").first().attr("alt");
                    user.setLevel(level);

                    String age = tds.get(4).text();
                    user.setAge(age);

                    String country = tds.get(5).select("img").first().attr("alt");
                    user.setCountry(country);

                    String topic = tds.get(6).text();
                    user.setTopic(topic);

                    String skype = tds.get(7).select("a").first().attr("href");
                    user.setSkype(skype);

                    String statusx = element1.select("td").first().text();
                    user.setStatus(statusx);
                    Log.e("âDSA", "DSADSA");

                    users.add(user);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
