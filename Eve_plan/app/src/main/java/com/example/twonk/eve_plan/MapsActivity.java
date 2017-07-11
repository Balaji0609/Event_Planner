package com.example.twonk.eve_plan;

import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //Bundle n = getIntent().getExtras();
    //int j = n.getInt("i");

    public Marker marker1,marker2;
    private GoogleMap mMap;
    public Marker m1,m2,m3,m4,m5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));

        return Radius * c;
    }
    public void drawline()
    {

        PolylineOptions options=new PolylineOptions()
                .add(marker1.getPosition())
                .add(marker2.getPosition());
        mMap.addPolyline(options);
        Double dis=CalculationByDistance(marker1.getPosition(),marker2.getPosition());
        if( dis < 0.5) {
            Toast.makeText(getApplicationContext(), " DISTANCE is walkable- " + dis, Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Distance"+dis+" is not walkable and weather is bad. Please consider alternative transport",Toast.LENGTH_LONG).show();
        }
    }

public void navigate(View view)throws IOException {
    List<Address> addressList = null;
    Bundle ex =getIntent().getExtras();
    EditText location_t = (EditText) findViewById(R.id.editText);
    //List<Address> daddressList = null;
    String location = null ;//= ex.get("add").toString();
    //location_t.setText(location);
    if(location == null || location.equals(""))
    {

        location = location_t.getText().toString();
    }
    if (location != null || !location.equals("")) {
        Geocoder geocoder = new Geocoder(this);
        try {
            addressList = geocoder.getFromLocationName(location, 1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Address address;
        if(addressList.size() != 0) {



          address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            System.out.println("*****************************" + address.getLatitude() + "   " + address.getLongitude());
            marker2 = mMap.addMarker(new MarkerOptions().position(latLng).snippet(location ).title("Destination Point"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
            drawline();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"please enter a address",Toast.LENGTH_LONG).show();
        }
    }
}

    public void onSearch(View view) throws IOException {
        String location = "699 S Mill Avenue,Tempe";
        List<Address> addressList = null;
        if(location != null || !location.equals(""))
        {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location , 1);

            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude() , address.getLongitude());

            System.out.println("*****************************" + address.getLatitude() + "   " + address.getLongitude());

            marker1=mMap.addMarker(new MarkerOptions().position(latLng).snippet(location+" Temp:54.3 F").title("Source Point"));

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

        }
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
    public void onZoom(View view)
    {
        if(view.getId() == R.id.Bzoomin)
        {
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if(view.getId() == R.id.Bzoomout)
        {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }
    public void nearby(View view)
    {
        //mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng s1 = new LatLng(33.414405, -111.929595);
        LatLng s2 = new LatLng(33.393377, -111.812543);
        LatLng s3 = new LatLng(33.317401, -111.876357);
        LatLng s4 = new LatLng(33.473924, -111.984504);
        LatLng s5 = new LatLng(33.347130, -111.96185);

        mMap.addMarker(new MarkerOptions().position(s1).title("Walmart").snippet("Walmart 671 East Apache boulevard"));
        mMap.addMarker(new MarkerOptions().position(s2).title("Walmart").snippet("800 East Southern Avenue"));
        mMap.addMarker(new MarkerOptions().position(s3).title("Walmart").snippet("857 North Dobson Road"));
        mMap.addMarker(new MarkerOptions().position(s4).title("Costco").snippet("4502 East Oak Street"));
        mMap.addMarker(new MarkerOptions().position(s5).title("Costco").snippet("1445 West Elliot Road"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(s1, 10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(s2, 10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(s3, 10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(s4, 10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(s5, 10));
    }

}
