package aiproject.tama.cspacev1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static aiproject.tama.cspacev1.R.drawable.codemargonda;
import static aiproject.tama.cspacev1.R.drawable.depokcoworking;
import static aiproject.tama.cspacev1.R.drawable.digitalin;
import static aiproject.tama.cspacev1.R.drawable.iot;
import static aiproject.tama.cspacev1.R.drawable.juanda;


public class DbHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "db_coworking";
    public DbHelper(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS coworking(_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, alamat TEXT, no_tlpn NUMERIC, descripsi TEXT,latitude Double,longtitude Double, img BLOB)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();
        //copy coworking space disini

        values.put("_id", "121");
        values.put("nama", "IoT Workspace Depok ");
        values.put("alamat", "Jl. Akses UI No.26, Tugu, Kec. Cimanggis, Kota Depok, Jawa Barat 16451");
        values.put("no_tlpn", "(021)-22822846");
        values.put("descripsi","IoT Workspace Depok");
        values.put("latitude","-6.354593");
        values.put("longtitude","106.839788");
        values.put("img",iot);

        db.insert("coworking","_id", values);

        values.put("_id", "123");
        values.put("nama", "Depok Coworking ");
        values.put("alamat", "Jl. Raya Sawangan No.81, Pancoran MAS, Kec. Pancoran Mas, Kota Depok, Jawa Barat 16436");
        values.put("no_tlpn", "(021)-29436785");
        values.put("descripsi","https://depok-coworking.business.site/");
        values.put("latitude","-6.395336");
        values.put("longtitude","106.802989");
        values.put("img",depokcoworking);

        db.insert("coworking","_id", values);

        values.put("_id", "125");
        values.put("nama", "Digital Innovation Lounge ");
        values.put("alamat", "Jl. Ridwan Rais No.65, Beji Tim., Kecamatan Beji, Kota Depok, Jawa Barat 16422");
        values.put("no_tlpn", "(021)-77801655");
        values.put("descripsi","Digital Innovation Lounge ");
        values.put("latitude","-6.380240");
        values.put("longtitude","106.823979");
        values.put("img",digitalin);

        db.insert("coworking","_id", values);

        values.put("_id", "126");
        values.put("nama", "Juanda Coworking Space ");
        values.put("alamat", "Jl. Jelutung 4 No.191B, RT.03/RW.016, Bakti Jaya, Kec. Sukmajaya, Kota Depok, Jawa Barat 16418");
        values.put("no_tlpn", "(021)-27612703");
        values.put("descripsi","Juanda Coworking Space ");
        values.put("latitude","-6.379678");
        values.put("longtitude","106.849681");
        values.put("img",juanda);

        db.insert("coworking","_id", values);

        values.put("_id", "124");
        values.put("nama", "Code Margonda ");
        values.put("alamat", "Depok Town Square, paling atas (Lantai 2, Level Mezanin) Area Foodcourt, Jl. Margonda Raya No.1, Kemiri Muka, Kecamatan Beji, Kota Depok, Jawa Barat 16424");
        values.put("no_tlpn", "(021)-22711457");
        values.put("descripsi","https://codemargonda.com/ ");
        values.put("latitude","-6.372303");
        values.put("longtitude","106.832490");
        values.put("img",codemargonda);

        db.insert("coworking","_id", values);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS coworking");
        onCreate(db);

    }
}
