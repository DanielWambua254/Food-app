package com.example.foodapp.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.foodapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends BaseActivity {

    ActivitySignUpBinding  binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }

    private void setVariable() {
        binding.signUpBtn.setOnClickListener(v -> {
            String email = binding.emailEdit.getText().toString();
            String password = binding.passEdit.getText().toString();
            if (password.length() < 8){
                Toast.makeText(SignUpActivity.this, "Password must be more than 8 characters", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, task -> {
                if(task.isSuccessful()) {
                    Log.i(TAG, "onComplete: ");
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                } else {
                    Log.i(TAG, "failure: " + task.getException());
                    Toast.makeText(SignUpActivity.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}