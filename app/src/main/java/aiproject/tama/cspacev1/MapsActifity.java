package aiproject.tama.cspacev1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActifity extends AppCompatActivity implements OnMapReadyCallback {
    static final LatLng Depok= new LatLng(-6.390028,106.809052);
    final int RQS_GooglePlayServices = 1;
    private GoogleMap myMap;
    private String provider = null;
    private Marker mCurrenPosition = null;
    LatLng cwd_depok = new LatLng(-6.395336, 106.802989);
    LatLng cwd_iot = new LatLng(-6.354593, 106.839788);
    LatLng cwd_dd = new LatLng(-6.380240, 106.823979);
    LatLng cwd_jd = new LatLng(-6.379678, 106.849681);
    LatLng cwd_cm = new LatLng(-6.372296, 106.832490);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Lokasi Coworking Space");
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
               .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
           //     .findFragmentById(R.id.map);
        //assert mapFragment != null;
       // mapFragment.getMapAsync(this);


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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;

        // Enabling MyLocation Layer of Google Map
        googleMap.setMyLocationEnabled(true);

        myMap.addMarker(new MarkerOptions().position(cwd_depok).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("Depok Coworking").snippet("Jl. Raya Sawangan No.81, Pancoran MAS, Kec. Pancoran Mas, Kota Depok, Jawa Barat 16436"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_depok, 10));


        myMap.addMarker(new MarkerOptions().position(cwd_dd).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("Digital Innovation Lounge").snippet("Jl. Ridwan Rais No.65, Beji Tim., Kecamatan Beji, Kota Depok, Jawa Barat 16422"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_dd, 10));

        myMap.addMarker(new MarkerOptions().position(cwd_jd).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("DJuanda Coworking Space").snippet("Jl. Jelutung 4 No.191B, RT.03/RW.016, Bakti Jaya, Kec. Sukmajaya, Kota Depok, Jawa Barat 16418"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_jd, 10));

        myMap.addMarker(new MarkerOptions().position(cwd_cm).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("Code Margonda").snippet("Depok Town Square, paling atas (Lantai 2, Level Mezanin) Area Foodcourt, Jl. Margonda Raya No.1, Kemiri Muka, Kecamatan Beji, Kota Depok, Jawa Barat 16424"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_cm, 10));

        myMap.addMarker(new MarkerOptions().position(cwd_iot).icon(BitmapDescriptorFactory
                .fromResource(R.drawable.ic_marker)).title("IoT Workspace Depok").snippet("Jl. Akses UI No.26, Tugu, Kec. Cimanggis, Kota Depok, Jawa Barat 16451"));

        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cwd_iot, 10));


        myMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        myMap.getUiSettings().setCompassEnabled(true);

        myMap.getUiSettings().setZoomControlsEnabled(true);

        myMap.getUiSettings().setMyLocationButtonEnabled(true);
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Depok, 12));

        myMap.setMyLocationEnabled(true);

        myMap.setOnMarkerClickListener(new OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker arg0) {
                // TODO Auto-generated method stub

                try {
                    StringBuilder urlString = new StringBuilder();
                    String daddr = (String.valueOf(arg0.getPosition().latitude) + "," + String.valueOf(arg0.getPosition().longitude));
                    urlString.append("http://maps.google.com/maps?f=d&hl=en");
                    urlString.append("&saddr=" + String.valueOf(myMap.getMyLocation().getLatitude()) + "," + String.valueOf(myMap.getMyLocation().getLongitude()));
                    urlString.append("&daddr=" + daddr);
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString.toString()));
                    startActivity(i);
                } catch (Exception ee) {
                    Toast.makeText(getApplicationContext(), "Lokasi Saat Ini Belum Didapatkan, Izinkan GPS secara manual. lalu masuk kembali", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });


        myMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker arg0) {
                // TODO Auto-generated method stub
                //JIKA KLIKNYA INGIN DI INFO WINDOW
            }
        });

    }

}
