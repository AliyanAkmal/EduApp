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

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText etForgotEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etForgotEmail = findViewById(R.id.etForgotEmail);
        Button btnSendRecovery = findViewById(R.id.btnSendRecovery);
        TextView tvBackToLogin = findViewById(R.id.tvBackToLogin);

        btnSendRecovery.setOnClickListener(v -> handleSendRecovery());

        tvBackToLogin.setOnClickListener(v -> finish());
    }

    private void handleSendRecovery() {
        String email = etForgotEmail.getText() != null ? etForgotEmail.getText().toString().trim() : "";

        if (TextUtils.isEmpty(email)) {
            etForgotEmail.setError(getString(R.string.err_empty_field));
            etForgotEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etForgotEmail.setError(getString(R.string.err_invalid_email));
            etForgotEmail.requestFocus();
            return;
        }

        Toast.makeText(this, R.string.toast_recovery_sent, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
        finish();
    }
}
