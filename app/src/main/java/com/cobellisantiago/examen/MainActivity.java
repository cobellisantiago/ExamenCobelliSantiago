package com.cobellisantiago.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private EditText editTextStoreName;
    private RadioGroup radioGroupStoreTypes;
    private RadioButton radioButtonStoreTypeBar, radioButtonStoreTypeSupermarket;
    private Button buttonCreate;
    private ArrayList<Store> stores;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment )
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        editTextStoreName = findViewById(R.id.editTextStoreName);
        radioGroupStoreTypes = findViewById(R.id.radioGroupStoreTypes);
        radioGroupStoreTypes = findViewById(R.id.radioGroupStoreTypes);
        radioButtonStoreTypeBar = findViewById(R.id.radioButtonStoreTypeBar);
        radioButtonStoreTypeSupermarket = findViewById(R.id.radioButtonStoreTypeSupermarket);
        buttonCreate = findViewById(R.id.buttonCreate);
        stores = new ArrayList<>();

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextStoreName.getText().toString().isEmpty()){
                    Random rand = new Random();
                    Double random = (-0.0000099) + (0.0000099 - (-0.0000099) * rand.nextDouble());
                    String type =
                            (String) (radioGroupStoreTypes.getCheckedRadioButtonId() == radioButtonStoreTypeBar.getId() ?
                                                                radioButtonStoreTypeBar.getText() : radioButtonStoreTypeSupermarket.getText());
                    Store auxStore = new Store(
                            (-31.6408215) + random, //((random-10) / 100000),
                            (-60.6865821) + random, // ((random-10) / 100000),
                            editTextStoreName.getText().toString(),
                            type);
                    stores.add(auxStore);
                    Log.d("Lista", String.valueOf(stores));
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
        updateMap();
    }

    private void updateMap() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, 9999);
        return;
        }
        googleMap.setMyLocationEnabled(true);
    }
}