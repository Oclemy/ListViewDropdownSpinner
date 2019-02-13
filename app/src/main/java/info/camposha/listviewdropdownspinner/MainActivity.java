package info.camposha.listviewdropdownspinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView myListView;
    Spinner mySpinner;
    ArrayAdapter<CosmicBody> adapter;
    String[] categories={"All","Planets","Stars","Galaxies"};

    /*
    Initialize ListView and Spinner, set their adapters and listen to spinner itemSelection events
    */
    private void initializeViews() {

        mySpinner = findViewById(R.id.mySpinner);
        mySpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories));

        myListView = findViewById(R.id.myListView);
        myListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getCosmicBodies()));



        //spinner selection events
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemID) {
                if (position >= 0 && position < categories.length) {
                    getSelectedCategoryData(position);
                } else {
                    Toast.makeText(MainActivity.this, "Selected Category Does not Exist!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    /*
    Populate an arraylist that will act as our data source.
     */
    private ArrayList<CosmicBody> getCosmicBodies() {
        ArrayList<CosmicBody> data = new ArrayList<>();
        data.clear();

        data.add(new CosmicBody("Mercury", 1));
        data.add(new CosmicBody("UY Scuti", 1));
        data.add(new CosmicBody("Andromeda", 3));
        data.add(new CosmicBody("VV Cephei A", 2));
        data.add(new CosmicBody("IC 1011", 3));
        data.add(new CosmicBody("Sun", 2));
        data.add(new CosmicBody("Aldebaran", 2));
        data.add(new CosmicBody("Venus", 1));
        data.add(new CosmicBody("Malin 1", 3));
        data.add(new CosmicBody("Rigel", 2));
        data.add(new CosmicBody("Earth", 1));
        data.add(new CosmicBody("Whirlpool", 3));
        data.add(new CosmicBody("VY Canis Majoris", 2));
        data.add(new CosmicBody("Saturn", 1));
        data.add(new CosmicBody("Sombrero", 3));
        data.add(new CosmicBody("Betelgeuse", 2));
        data.add(new CosmicBody("Uranus", 1));
        data.add(new CosmicBody("Virgo Stellar Stream", 3));
        data.add(new CosmicBody("Epsillon Canis Majoris", 2));
        data.add(new CosmicBody("Jupiter", 1));
        data.add(new CosmicBody("VY Canis Majos", 2));
        data.add(new CosmicBody("Triangulum", 3));
        data.add(new CosmicBody("Cartwheel", 3));
        data.add(new CosmicBody("Antares", 2));
        data.add(new CosmicBody("Mayall's Object", 3));
        data.add(new CosmicBody("Proxima Centauri", 2));
        data.add(new CosmicBody("Black Eye", 3));
        data.add(new CosmicBody("Mars", 1));
        data.add(new CosmicBody("Sirius", 2));
        data.add(new CosmicBody("Centaurus A", 3));
        data.add(new CosmicBody("Pinwheel", 3));
        data.add(new CosmicBody("Small Magellonic Cloud", 3));
        data.add(new CosmicBody("Uranus", 1));
        data.add(new CosmicBody("Alpha Centauri", 2));
        data.add(new CosmicBody("Large Magellonic Cloud", 3));

        return data;
    }
    /*
    Get the selected category's cosmic bodies and bind to ListView
     */
    private void getSelectedCategoryData(int categoryID) {
        //arraylist to hold selected cosmic bodies
        ArrayList<CosmicBody> cosmicBodies = new ArrayList<>();
        if(categoryID == 0)
        {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getCosmicBodies());
        }else{
            //filter by id
            for (CosmicBody cosmicBody : getCosmicBodies()) {
                if (cosmicBody.getCategoryId() == categoryID) {
                    cosmicBodies.add(cosmicBody);
                }
            }
            //instatiate adapter a
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cosmicBodies);
        }
        //set the adapter to GridView
        myListView.setAdapter(adapter);
    }
    /*
    when activity is created, setContentView then initializeViews.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }
}
/*
Data Object class to represent a single Cosmic body. Class has default access modifier
 */
class CosmicBody {
    private String name;
    private int categoryID;

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryID;
    }

    public CosmicBody(String name, int categoryID) {
        this.name = name;
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return name;
    }
}