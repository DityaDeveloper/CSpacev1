package aiproject.tama.cspacev1;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class WSpaceD_Management extends Application
{

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

        if (!FirebaseApp.getApps(this).isEmpty()){

            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
}