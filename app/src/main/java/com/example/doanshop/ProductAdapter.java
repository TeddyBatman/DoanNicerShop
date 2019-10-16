package com.example.doanshop;


import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ArrayList<Product> products;
    LayoutInflater mInflater;

    public static class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ProductAdapter adapter;
        TextView price;

        ImageView carPhoto;
        TextView quantity;
        Button mButtonAdd;
        int qty;
        double total;
        Button mButtonSubtract;


        ProductViewHolder(View itemView, ProductAdapter adapter) {
            super(itemView);
            carPhoto = (ImageView) itemView.findViewById(R.id.model3);
            quantity = itemView.findViewById(R.id.subtotal_countm3);
            mButtonAdd = itemView.findViewById(R.id.add_buttonm3);
            mButtonAdd.setOnClickListener(this);
            mButtonSubtract = itemView.findViewById(R.id.remove_buttonm3);
            mButtonSubtract.setOnClickListener(this);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.add_buttonm3:
                    ++qty;
                    quantity.setText(Integer.toString(qty));
                    total = Integer.parseInt(quantity.getText().toString());
                    break;
                case R.id.remove_buttonm3:
                    if (Integer.parseInt(quantity.getText().toString()) == 0) {
                        quantity.setText("0");
                        Toast.makeText(v.getContext(), "Cannot Remove items.", Toast.LENGTH_SHORT).show();
                    } else
                        --qty;
                    quantity.setText(Integer.toString(qty));
                    total = Integer.parseInt(quantity.getText().toString());
                    break;


            }


        }
    }


    ProductAdapter(Context context, ArrayList<Product> products) {
        mInflater = LayoutInflater.from(context);
        this.products = products;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.card_content, viewGroup, false);
        return new ProductViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder productViewHolder, int i) {
        productViewHolder.carPhoto.setImageResource(products.get(i).pictureId);
        productViewHolder.quantity.setText(products.get(i).getQuantity());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
