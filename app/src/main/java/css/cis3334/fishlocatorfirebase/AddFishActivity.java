package css.cis3334.fishlocatorfirebase;

//import android.content.Context;
import android.content.Intent;
//import android.content.pm.PackageManager;
import android.location.Criteria;
//import android.location.Location;
import android.location.LocationManager;
//import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

public class AddFishActivity extends AppCompatActivity {

    Button buttonSave;
    EditText editTextSpecies, editTextWeight, editTextDate, editTextLat, editTextLong;
    //Double lattitude, longiture;
    FishFirebaseData fishDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fish);

        // link each editText variable to the xml layout
        editTextSpecies = (EditText) findViewById(R.id.editTextSpecies);
        editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        editTextLat = (EditText) findViewById(R.id.editTextLatitude);
        editTextLong = (EditText) findViewById(R.id.editTextLongitude);

        fishDataSource = new FishFirebaseData();
        fishDataSource.open();

        // get the current location of the phone
      /*  LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
           //Log.i("CISS3334, error with location");
            return;
        } else {
            Location location = locationManager.getLastKnownLocation();
            if (location != null) {
                lattitude = location.getLatitude();
                longiture = location.getLongitude();
            } else {
                lattitude = 0.0;
                longiture = 0.0;

            }
            }
        }
        */

        //Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        //lattitude = location.getLatitude();
        //longitude = location.getLongitude();

        // set up the button listener
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Add the fish to the database
                String species = editTextSpecies.getText().toString();
                String weight = editTextWeight.getText().toString();
                String dateCaught = editTextDate.getText().toString();
                String latitude = editTextLat.getText().toString();
                String longitude = editTextLong.getText().toString();
                //fishDataSource.createFish(species, weight, dateCaught);
                fishDataSource.createFish(species, weight, dateCaught, latitude, longitude);
                Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);
            }
        });
    }
}