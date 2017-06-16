package id.web.indraguna.usersbook.Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.web.indraguna.usersbook.Data.User;

/**
 * Created by indra on 6/15/17.{}
 */

public class UserJSONParser {
    static List<User> userList;

    public static List<User> parseData(String content) {
        JSONArray user_array = null;
        User user = null;
        try {
            user_array = new JSONArray(content);
            userList = new ArrayList<>();

            for (int i = 0; i < user_array.length(); i++){
                JSONObject obj = user_array.getJSONObject(i);
                user = new User();

                user.setName(obj.getString("name"));
                user.setUsername(obj.getString("username"));

                userList.add(user);
            }
            return userList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
