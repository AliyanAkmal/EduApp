package com.example.begining;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText etNewPassword, etConfirmNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etNewPassword = findViewById(R.id.etNewPassword);
        etConfirmNewPassword = findViewById(R.id.etConfirmNewPassword);
        Button btnResetPassword = findViewById(R.id.btnResetPassword);

        btnResetPassword.setOnClickListener(v -> handleResetPassword());
    }

    private void handleResetPassword() {
        String newPassword = etNewPassword.getText() != null ? etNewPassword.getText().toString().trim() : "";
        String confirmPassword = etConfirmNewPassword.getText() != null ? etConfirmNewPassword.getText().toString().trim() : "";

        if (TextUtils.isEmpty(newPassword)) {
            etNewPassword.setError(getString(R.string.err_empty_field));
            etNewPassword.requestFocus();
            return;
        }

        if (newPassword.length() < 6) {
            etNewPassword.setError(getString(R.string.err_password_short));
            etNewPassword.requestFocus();
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            etConfirmNewPassword.setError(getString(R.string.err_password_mismatch));
            etConfirmNewPassword.requestFocus();
            return;
        }

        Toast.makeText(this, R.string.toast_password_reset, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
