package com.example.blossomheaven;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView productImage = findViewById(R.id.product_image_detail);
        TextView productName = findViewById(R.id.product_name_detail);
        TextView productPrice = findViewById(R.id.product_price_detail);
        TextView productDescription = findViewById(R.id.product_description_detail);
        Button addToCartButton = findViewById(R.id.btn_add_to_cart);
        Button buyNowButton = findViewById(R.id.btn_buy_now);

        String name = getIntent().getStringExtra("product_name");
        double price = getIntent().getDoubleExtra("product_price", 0);
        int imageId = getIntent().getIntExtra("product_image", 0);
        String description = getIntent().getStringExtra("product_description");

        productName.setText(name);
        productPrice.setText("$" + price);
        productImage.setImageResource(imageId);
        productDescription.setText(description);

        Product product = new Product(name, price, imageId, description);

        addToCartButton.setOnClickListener(v -> {
            CartManager.getInstance().addToCart(product);  // Add product to the cart
            Toast.makeText(ProductDetailActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
        });

        buyNowButton.setOnClickListener(v -> {
            Toast.makeText(ProductDetailActivity.this, "Proceeding to Buy " + name, Toast.LENGTH_SHORT).show();
        });
    }
}
