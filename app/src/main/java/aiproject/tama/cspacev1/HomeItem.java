package aiproject.tama.cspacev1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class HomeItem extends AppCompatActivity {
    protected ListView lv;
    protected ListAdapter adapter;
    SQLiteDatabase db;
    Cursor cursor;
    EditText et_db;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_home);
        db = (new DbHelper(this)).getWritableDatabase();
        lv = (ListView) findViewById(R.id.lv);
        et_db =(EditText) findViewById(R.id.et);

        try{
            cursor = db.rawQuery("SELECT * FROM coworking ORDER BY nama ASC", null);
            adapter = new SimpleCursorAdapter(this, R.layout.list_home_item, cursor, new String[] {"nama", "alamat"}, new int[] {R.id.tv_nama, R.id.tv_alamat});
            lv.setAdapter(adapter);
            lv.setTextFilterEnabled(true);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    detail(position);
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("List Coworking Space");
        }
    }
    @SuppressWarnings("deprecation")
    public void search_db(View v){
        String edit_db = et_db.getText().toString();
        if(!edit_db.equals("")){
            try{
                cursor = db.rawQuery("SELECT * FROM coworking WHERE nama LIKE ?", new String[] {"%" +edit_db+ "%"});
                adapter = new SimpleCursorAdapter(this, R.layout.list_home_item, cursor, new String[] {"nama", "alamat", "img"}, new int[] {R.id.tv_nama, R.id.tv_alamat});
                if(adapter.getCount() == 0){
                    Toast.makeText(this, "Tidak ditemukan data dengan kata kunci "+edit_db+"", Toast.LENGTH_SHORT).show();
                }else{
                    lv.setAdapter(adapter);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                cursor = db.rawQuery("SELECT * FROM coworking ORDER BY nama ASC", null);
                adapter = new SimpleCursorAdapter(this, R.layout.list_home_item, cursor, new String[] {"nama", "alamat", "img"}, new int[] {R.id.tv_nama, R.id.tv_alamat});
                lv.setAdapter(adapter);
                lv.setTextFilterEnabled(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void detail(int position){
        int im = 0;
        String _id = "";
        String nama = "";
        String alamat = "";
        String no_tlpn = "";
        String deskripsi = "";
        String lat= "";
        String lng ="";
        if(cursor.moveToFirst()){
            cursor.moveToPosition(position);
            im = cursor.getInt(cursor.getColumnIndex("img"));
            nama = cursor.getString(cursor.getColumnIndex("nama"));
            alamat = cursor.getString(cursor.getColumnIndex("alamat"));
            no_tlpn = cursor.getString(cursor.getColumnIndex("no_tlpn"));
            deskripsi = cursor.getString(cursor.getColumnIndex("descripsi"));
            lat = cursor.getString(cursor.getColumnIndex("latitude"));
            lng = cursor.getString(cursor.getColumnIndex("longtitude"));
        }

        Intent iIntent = new Intent(this, WSpaceDetailActifity.class);
        iIntent.putExtra("dataIM", im);
        iIntent.putExtra("dataNama", nama);
        iIntent.putExtra("dataAlamat", alamat);
        iIntent.putExtra("dataNoTlpn", no_tlpn);
        iIntent.putExtra("dataDeskripsi",deskripsi);
        iIntent.putExtra("latitude",lat);
        iIntent.putExtra("longtitude",lng);
        setResult(RESULT_OK, iIntent);
        startActivityForResult(iIntent, 99);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
