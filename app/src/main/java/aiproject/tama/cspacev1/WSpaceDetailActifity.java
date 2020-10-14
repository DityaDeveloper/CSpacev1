package aiproject.tama.cspacev1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WSpaceDetailActifity extends AppCompatActivity {
    ImageView Im;
    TextView tv_nama, tv_alamat,tv_tlpn,tv_deskripsi ,id,lalitude,longtitude;
    Gallery gallery;
    ImageSwitcher imageSwitcher;
    Integer[] imageIDs = new Integer[3];
    int msg_im;
    public static final String NAME= "name";
    public static final String LOKASI= "lokasi";
    public static final String LAT ="lat";
    public static final String LONG = "long";

    //firebase class
    private TextView product_info;
    private ImageView managerMain_imageView;

    private EditText Ulasan ,Name;
    private TextView save_Info, view_Info;
    private Spinner Tempat;

    private Product_Info productInfo;
    FirebaseDatabase database;
    DatabaseReference mRef;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cspace_detail
        );

        //firebase komentar
        product_info=findViewById(R.id.product_info);


        Name=findViewById(R.id.inventoryName);
        Tempat=findViewById(R.id.jeniskelamin);
        Ulasan= findViewById(R.id.jabatan);

        save_Info=findViewById(R.id.save_Info);
        view_Info=findViewById(R.id.view_Info);

        productInfo= new Product_Info();
        database=FirebaseDatabase.getInstance();
        mRef=database.getReference().child("Ulasan");
        //firebase komentar

        Intent iIdentifikasi = getIntent();
        msg_im = iIdentifikasi.getIntExtra("dataIM", 0);
        String msg_nama = iIdentifikasi.getStringExtra("dataNama");
        String msg_alamat = iIdentifikasi.getStringExtra("dataAlamat");
        String msg_no_tlpn = iIdentifikasi.getStringExtra("dataNoTlpn");
        String msg_deskripsi = iIdentifikasi.getStringExtra("dataDeskripsi");
        String lat = iIdentifikasi.getStringExtra("latitude");
        String lng = iIdentifikasi.getStringExtra("longtitude");
        Im = (ImageView) findViewById(R.id.iv_detail);
        tv_nama = (TextView) findViewById(R.id.tvNama);
        tv_alamat = (TextView) findViewById(R.id.tvalamat);
        tv_tlpn = (TextView) findViewById(R.id.tvtlpn);
        tv_deskripsi = (TextView) findViewById(R.id.tvdeskripsi);
        lalitude = (TextView) findViewById(R.id.latitude);
        longtitude = (TextView) findViewById(R.id.longitude);
        Im.setImageResource(msg_im);
        tv_nama.setText(msg_nama);
        tv_alamat.setText(msg_alamat);
        tv_tlpn.setText(msg_no_tlpn);
        tv_deskripsi.setText(msg_deskripsi);
        lalitude.setText(lat);
        longtitude.setText(lng);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Coworking Space Depok");
        }

        save_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean error = false;

                String name=Name.getText().toString();
                if (name.isEmpty()) {
                    Name.setError("Nama Masih Kosong");
                    error = true;
                }

                String ulasan=Ulasan.getText().toString();
                if (ulasan.isEmpty()) {
                    Ulasan.setError("Ulasan Masih Kosong");
                    error = true;
                }

                String tempat=Tempat.getSelectedItem().toString();

                productInfo.setName(name);
                productInfo.setUlasan(ulasan);
                productInfo.setTempat(tempat);

                if (error==true){

                    Toast.makeText(WSpaceDetailActifity.this, "Informaasi Data Tidak Valid", Toast.LENGTH_LONG).show();

                }
                else {

                    mRef.child(productInfo.getName()).setValue(productInfo);
                    Toast.makeText(WSpaceDetailActifity.this, "Terima Kasih Atas Ulasannya :)", Toast.LENGTH_LONG).show();

                }

            }


        });



        view_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewInfo=new Intent(WSpaceDetailActifity.this,View_Information.class);
                startActivity(viewInfo);
            }
        });
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