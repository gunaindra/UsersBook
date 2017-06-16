package id.web.indraguna.usersbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import id.web.indraguna.usersbook.Data.User;
import id.web.indraguna.usersbook.R;

import static id.web.indraguna.usersbook.R.id.item_name;
import static id.web.indraguna.usersbook.R.id.item_username;

/**
 * Created by indra on 6/13/17.
 */

public class UserAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater = null;
    private List<User> userList;

    private RequestQueue queue;

    public UserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        inflater = LayoutInflater.from(context);

        queue = Volley.newRequestQueue(context);
    }

    public class ViewHolder {
        TextView item_name;
        TextView item_username;
    }

    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        final User user = userList.get(position);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.item_view, null);
            holder = new ViewHolder();

            holder.item_name = (TextView) convertView.findViewById(R.id.item_name);
            holder.item_username = (TextView) convertView.findViewById(R.id.item_username);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.item_name.setText(user.getName().toString());
        holder.item_username.setText(user.getUsername().toString());

        return convertView;
    }

}
