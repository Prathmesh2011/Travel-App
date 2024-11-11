package com.example.travel_app.Activity;

import android.os.Bundle;
import android.view.View;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.travel_app.Domain.ItemDomain;
import com.example.travel_app.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private ItemDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        if (object != null) {
            binding.titleTxt.setText(object.getTitle());
            binding.priceTxt.setText("$" + object.getPrice());
            binding.backBtn.setOnClickListener(v -> finish());
            binding.bedTxt.setText(String.valueOf(object.getBed()));
            binding.durationTxt.setText(object.getDuration());
            binding.distanceTxt.setText(object.getDistance());
            binding.descriptionTxt.setText(object.getDescription());
            binding.addressTxt.setText(object.getAddress());
            binding.ratingTxt.setText(object.getScore() + " Rating");
            binding.ratingBar.setRating((float) object.getScore());

            Glide.with(DetailActivity.this)
                    .load(object.getPic())
                    .into(binding.pic);
        } else {
            Log.e("DetailActivity", "Object is null");
        }
    }

    private void getIntentExtra() {
        // Fetch the object using the correct key "object"
        object = (ItemDomain) getIntent().getSerializableExtra("object");  // Consistent key here
    }
}
