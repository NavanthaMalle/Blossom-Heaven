package com.example.blossomheaven;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    private List<Product> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView cartRecyclerView = findViewById(R.id.recyclerViewCart);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        cartList = CartManager.getInstance().getCartItems();

        CartAdapter cartAdapter = new CartAdapter(this, cartList);
        cartRecyclerView.setAdapter(cartAdapter);

        // Update total price
        TextView totalPriceTextView = findViewById(R.id.total_price);
        double totalPrice = calculateTotalPrice();
        totalPriceTextView.setText("Total: $" + totalPrice);
    }

    private double calculateTotalPrice() {
        double total = 0;
        for (Product product : cartList) {
            total += product.getPrice();
        }
        return total;
    }
}
