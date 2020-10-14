package aiproject.tama.cspacev1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class InfoWindows implements GoogleMap.InfoWindowAdapter {
    private View myContentsView;
    LayoutInflater inflater;

    public InfoWindows (Context context){
        myContentsView = LayoutInflater.from(context).inflate(R.layout.infowindows, null);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        TextView tvTitle = ((TextView)myContentsView.findViewById(R.id.title));
        tvTitle.setText(marker.getTitle());

//        ImageView img = ((ImageView)myContentsView.findViewById(R.id.imgWindow));

        TextView tvSnippet = ((TextView)myContentsView.findViewById(R.id.snippet));
        tvSnippet.setText(marker.getSnippet());

        return myContentsView;
    }
}
