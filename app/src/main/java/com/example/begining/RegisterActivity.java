package com.example.begining;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFullName, etRegEmail, etRegPassword, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFullName = findViewById(R.id.etFullName);
        etRegEmail = findViewById(R.id.etRegEmail);
        etRegPassword = findViewById(R.id.etRegPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvAlreadyHaveAccount = findViewById(R.id.tvAlreadyHaveAccount);

        btnRegister.setOnClickListener(v -> handleRegister());

        tvAlreadyHaveAccount.setOnClickListener(v -> finish());
    }

    private void handleRegister() {
        String fullName = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
        String email = etRegEmail.getText() != null ? etRegEmail.getText().toString().trim() : "";
        String password = etRegPassword.getText() != null ? etRegPassword.getText().toString().trim() : "";
        String confirmPassword = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString().trim() : "";

        if (TextUtils.isEmpty(fullName)) {
            etFullName.setError(getString(R.string.err_empty_field));
            etFullName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            etRegEmail.setError(getString(R.string.err_empty_field));
            etRegEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etRegEmail.setError(getString(R.string.err_invalid_email));
            etRegEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etRegPassword.setError(getString(R.string.err_empty_field));
            etRegPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etRegPassword.setError(getString(R.string.err_password_short));
            etRegPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError(getString(R.string.err_password_mismatch));
            etConfirmPassword.requestFocus();
            return;
        }

        Toast.makeText(this, R.string.toast_register_success, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
