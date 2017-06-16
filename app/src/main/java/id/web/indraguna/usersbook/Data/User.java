package id.web.indraguna.usersbook.Data;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by indra on 6/13/17.
 */

public class User {
    private String name, username;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUsername(String username){
        this.username = username;
    }


}
