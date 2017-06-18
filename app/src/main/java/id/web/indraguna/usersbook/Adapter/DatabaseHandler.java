package id.web.indraguna.usersbook.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.sax.StartElementListener;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import id.web.indraguna.usersbook.Data.User;

/**
 * Created by indra on 6/16/17.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user_manager";
    private static final String TABLE_NAME = "user_table";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_USERNAME = "username";
    private Context context;
    public DatabaseHandler(Context context){
        //this.context = context;
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER," + KEY_NAME + " TEXT,"
                + KEY_USERNAME + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
        Log.d("Inserting", "Inserting");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);

        //Create tables again
        onCreate(db);
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("Insert : ", "Inserting .. ");
                ContentValues values = new ContentValues();
                values.put(KEY_ID, user.getId());
                values.put(KEY_NAME, user.getName());
                values.put(KEY_USERNAME, user.getUsername());

                db.insert(TABLE_NAME, null, values);
                db.close();
    }
}
