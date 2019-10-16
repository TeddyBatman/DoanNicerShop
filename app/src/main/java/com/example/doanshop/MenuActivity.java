package com.example.doanshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Product> productArrayList =new ArrayList<>();
    FloatingActionButton fab;
    double cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        productArrayList.add(new Product("0",R.drawable.mdl3));
        ProductAdapter adapter = new ProductAdapter(this, productArrayList);
        recyclerView.setAdapter(adapter);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                // Set the ALertDialog title
                builder.setTitle("Shipping Methods:")

                        .setSingleChoiceItems(R.array.shippingMethods, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                switch (which) {
                                    case 0:
                                        cost = 50;
                                        break;
                                    case 1:
                                        cost = 10;
                                        break;
                                    case 2:
                                        cost = 0;
                                        break;
                                }


                            }
                        }).setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MenuActivity.this, CheckoutActivity.class);
                        startActivity(intent);


                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
    }
    }

    /**
     *
     * open checkout activity

    public void openCheckout(View view) {

        int subtotal = (mAddm3*54990)+(mAddms*108990)+(mAddmx*115990);
        double tps = subtotal * 0.05;
        double tvq = subtotal * 0.09975;
        double total = subtotal + tps + tvq;

        Intent intent1 = new Intent(this, CheckoutActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("subtotal",String.valueOf(subtotal));
        bundle.putString("total",String.valueOf(total));
        bundle.putString("tvq",String.valueOf(tvq));
        bundle.putString("tps",String.valueOf(tps));

        intent1.putExtras(bundle);
        intent1.putExtras(bundle);
        intent1.putExtras(bundle);
        intent1.putExtras(bundle);

        startActivity(intent1);

    }
*/


