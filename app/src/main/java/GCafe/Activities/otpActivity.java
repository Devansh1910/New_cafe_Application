package GCafe.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cafe.databinding.ActivityOtpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class otpActivity extends AppCompatActivity {

    private String verificationId;
    private ActivityOtpBinding binding;
    private Button enableButton;
    private int counter = 10;
    private Handler handler;
    private Runnable runnable;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FirebaseApp.initializeApp(this);

        editTextInput();

        binding.getusernumber.setText(String.format(
                "+91 - %s", getIntent().getStringExtra("phone")
        ));

        verificationId = getIntent().getStringExtra("verificationId");

        binding.resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(otpActivity.this, "OTP send successfully.", Toast.LENGTH_SHORT).show();
            }
        });


        binding.verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressBarVerify.setVisibility(View.VISIBLE);
                binding.verifybtn.setVisibility(View.INVISIBLE);
                if (binding.userotp1.getText().toString().trim().isEmpty() ||
                        binding.userotp2.getText().toString().trim().isEmpty() ||
                        binding.userotp3.getText().toString().trim().isEmpty() ||
                        binding.userotp4.getText().toString().trim().isEmpty() ||
                        binding.userotp5.getText().toString().trim().isEmpty() ||
                        binding.userotp6.getText().toString().trim().isEmpty()) {
                    Toast.makeText(otpActivity.this, "OTP is not valid!", Toast.LENGTH_SHORT).show();
                } else {
                    if (verificationId != null) {
                        String code = binding.userotp1.getText().toString().trim() +
                                binding.userotp2.getText().toString().trim() +
                                binding.userotp3.getText().toString().trim() +
                                binding.userotp4.getText().toString().trim() +
                                binding.userotp5.getText().toString().trim() +
                                binding.userotp6.getText().toString().trim();

                        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
                        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    binding.progressBarVerify.setVisibility(View.VISIBLE);
                                    binding.verifybtn.setVisibility(View.INVISIBLE);
                                    Intent intent = new Intent(otpActivity.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                } else {
                                    binding.progressBarVerify.setVisibility(View.GONE);
                                    binding.verifybtn.setVisibility(View.VISIBLE);
                                    Toast.makeText(otpActivity.this, "Invalid  OTP", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });

    }
    private void editTextInput() {
        binding.userotp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.userotp2.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.userotp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.userotp3.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.userotp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.userotp4.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.userotp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.userotp5.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.userotp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.userotp6.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}