package id.web.indraguna.usersbook;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

import id.web.indraguna.usersbook.Adapter.DatabaseHandler;
import id.web.indraguna.usersbook.Adapter.UserAdapter;
import id.web.indraguna.usersbook.Data.User;
import id.web.indraguna.usersbook.Parser.UserJSONParser;

/**
 * Created by indra on 6/13/17.
 */

public class MainActivity extends Activity {
    ListView listView;
    List<User> userList = new ArrayList<>();
    TextView text_name;

    private UserAdapter userAdapter;

    String url = "http://jsonplaceholder.typicode.com/users";
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_name = (TextView) findViewById(R.id.item_name);


        listView = (ListView) findViewById(R.id.list);

        requestData(url);


    }

    public void requestData(String url) {
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        userList = UserJSONParser.parseData(response);
                        Log.d("tes", userList.get(0).getName());
                        UserAdapter userAdapter = new UserAdapter(MainActivity.this, userList);
                        for (int i = 0; i < userList.size(); i++){
                            db.addUser(new User(userList.get(i).getId(), userList.get(i).getName(), userList.get(i).getUsername()));
                        }
                        listView.setAdapter(userAdapter);

                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
