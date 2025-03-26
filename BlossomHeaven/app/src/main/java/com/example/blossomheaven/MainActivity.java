//Developed by Naveen Dileesha S1033712//

package com.example.blossomheaven;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Chrysanthemum Bouquet", 30, R.drawable.chrysanthemum_bouquet, "A lovely bouquet of Chrysanthemums"));
        productList.add(new Product("Pink Lilies Bouquet", 25, R.drawable.pink_red_lilies_bouquet, "Fresh pink lilies to brighten any day"));
        productList.add(new Product("White Lilies & Chrysanthemums", 60, R.drawable.white_lilies_chrysanthemums_bouquet, "A blend of white lilies and chrysanthemums"));
        productList.add(new Product("Rose Bouquet", 85, R.drawable.rose_bouquet, "Classic red rose bouquet for special moments"));
        productList.add(new Product("Pink Gerberas Bouquet", 40, R.drawable.pink_gerberas_bouquet, "Cheerful pink gerberas bouquet"));
        productList.add(new Product("Pink Rose Bouquet", 75, R.drawable.pink_rose_bouquet, "Elegant pink roses for a softer touch"));
        productList.add(new Product("White Chrysanthemums Bouquet", 50, R.drawable.white_chrysanthemums_bouquet, "White chrysanthemums in full bloom"));
        productList.add(new Product("Pothos Plant", 30, R.drawable.pothos_plant, "Beautiful indoor pothos plant"));
        productList.add(new Product("Sansevieria Plant", 60, R.drawable.sansevieria_plant, "Sansevieria plant for home décor"));
        productList.add(new Product("Cyprus Plant", 50, R.drawable.cyprus_plant, "Cyprus plant for both indoor and outdoor use"));

        // Set adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.btn_view_cart).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}