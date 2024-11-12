package com.example.travel_app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bumptech.glide.Glide;
import com.example.travel_app.Domain.ItemDomain;
import com.example.travel_app.databinding.ActivityTicketBinding;

public class TicketActivity extends BaseActivity {
    ActivityTicketBinding binding;
    private ItemDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTicketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();  // Fetch the object passed from DetailActivity
        setVariable();  // Populate UI with the object details
    }

    private void setVariable() {
        if (object != null) {
            // Load images using Glide
            Glide.with(TicketActivity.this)
                    .load(object.getPic())
                    .into(binding.pic);

            Glide.with(TicketActivity.this)
                    .load(object.getTourGuidePic())
                    .into(binding.profile);

            // Set UI elements
            binding.backBtn.setOnClickListener(v -> finish());
            binding.titleTxt.setText(object.getTitle());
            binding.durationTxt.setText(object.getDuration());
            binding.tourGuideTxt.setText(object.getDateTour());
            binding.timeTxt.setText(object.getTimeTour());
            binding.tourGuideNameTxt.setText(object.getTourGuideName());

            // Call button functionality
            binding.callBtn.setOnClickListener(v -> {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" + object.getTourGuidePhone()));
                sendIntent.putExtra("sms_body", "type your message");
                startActivity(sendIntent);
            });

            // Message button functionality
            binding.messageBtn.setOnClickListener(v -> {
                String phone = object.getTourGuidePhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            });
        }
    }

    private void getIntentExtra() {
        // Fetch the object passed from DetailActivity
        object = (ItemDomain) getIntent().getSerializableExtra("object");  // Ensure the key is consistent
    }
}
