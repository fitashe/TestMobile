package com.fita.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fita.myapplication.databinding.ActivityFirstScreenBinding;

public class FirstScreen extends AppCompatActivity {
    private ActivityFirstScreenBinding binding;
    private TextView calluser;
    public static final String EXTRA_MESSAGE = "com.fita.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char[] charInput = binding.palindromInput.getText().toString().toCharArray();
                int intLength = charInput.length;

                boolean isPalindrome = true;

                for (int i=0; i < intLength / 2; i++){
                    if(charInput[i] != charInput[intLength - i - 1]){
                        isPalindrome = false;
                        break;
                    }
                }

                if(isPalindrome){
                    Toast.makeText(FirstScreen.this, "isPalindrome", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(FirstScreen.this, "not palindrome", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstScreen.this, SecondScreen.class);
                startActivity(intent);
                sendMessage(view);
            }
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, SecondScreen.class);
        calluser = binding.nameInput;
        String message = calluser.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("message", EXTRA_MESSAGE);
        startActivity(intent);
    }
}