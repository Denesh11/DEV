package com.example.mymapsapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = " Mountains ";
    private GoogleMap mMap;
    private LatLng kanjanjunga = new LatLng(27.704313646572125, 88.14753484686162);
    private LatLng meesapulimala = new LatLng(10.097650303829067, 77.20340067034836);
    private LatLng marunthuvazhmalai = new LatLng(8.135192079647908, 77.50828510322856);

    //Todo: Create Markers for each mountain

    private Marker kanjanMarker;
    private Marker meesaMarker;
    private Marker marunthuvazhMarker;

    private MarkerOptions marunthuvazhmalaiOptions;
    private MarkerOptions meesapulimalaOptions;

    private ArrayList<Marker> markerArrayList;
    private List<MarkerOptions> markerOptionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        markerArrayList = new ArrayList<>();
        
        markerOptionsList = new ArrayList<>();

//        kanjanMarker = mMap.addMarker(new MarkerOptions()
//        .position(kanjanjunga).title("Mt Kanjanjunga")
//                .icon(BitmapDescriptorFactory.defaultMarker
//                        (BitmapDescriptorFactory.HUE_ORANGE)));
//
//        markerArrayList.add(kanjanMarker);

        meesapulimalaOptions= new MarkerOptions()
        .position(meesapulimala).title("Mt Meesapulimala")
        .icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_ROSE));

        markerOptionsList.add(meesapulimalaOptions);

        marunthuvazhmalaiOptions = new MarkerOptions()
        .position(marunthuvazhmalai).title("Mt Marunthuvazh Malai")
        .icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_AZURE));

        markerOptionsList.add(marunthuvazhmalaiOptions);

        for (MarkerOptions options : markerOptionsList){
            LatLng latLng = new LatLng(options.getPosition().latitude,options.getPosition().longitude);
            mMap.addMarker(options);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,11));
//            Log.d(TAG, "onMapReady: " + marker.getTitle());
        }



//
//        // Add a marker in Sydney and move the camera
//        LatLng zion = new LatLng(8.114587,77.427331);
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(zion).title("Marker in Zion")
//        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
//        .alpha(3.2f));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(zion,10));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}