package com.fita.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fita.myapplication.databinding.ActivityFirstScreenBinding;
import com.fita.myapplication.databinding.ActivitySecondScreenBinding;

public class SecondScreen extends AppCompatActivity {
    private ActivitySecondScreenBinding binding;
    private TextView calluser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String message = intent.getStringExtra(FirstScreen.EXTRA_MESSAGE);
        calluser = binding.tvName;
        calluser.setText(message);

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondScreen.this, FirstScreen.class);
                startActivity(intent);
            }
        });

        binding.buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondScreen.this, ThirdScreen.class);
                startActivity(intent);
            }
        });
    }
}