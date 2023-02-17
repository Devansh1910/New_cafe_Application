package GCafe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cafe.databinding.ActivityRegistrationBinding;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegistrationActivity extends AppCompatActivity {
    ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginbtn.setOnClickListener(view -> openLogin());

        binding.originalsignupbtn.setOnClickListener(view -> validateUser());
    }

    private void validateUser() {
        if (binding.userName.getText().toString().isEmpty() || binding.userPhone.getText().toString().isEmpty() || binding.userEmail.getText().toString().isEmpty())
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        else
            storeData();
    }

    private void storeData() {
        AlertDialog builder = new AlertDialog.Builder(this)
                .setTitle("Loading...")
                .setMessage("Please Wait")
                .setCancelable(false)
                .create();
        builder.show();

        android.content.SharedPreferences preferences = getSharedPreferences("user", MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = preferences.edit();

        editor.putString("number", binding.userPhone.getText().toString());
        editor.putString("name", binding.userName.getText().toString());
        editor.apply();

        UserModel data = new UserModel(binding.userName.getText().toString(), binding.userPhone.getText().toString(), binding.userEmail.getText().toString());

        FirebaseFirestore.getInstance().collection("users").document(binding.userPhone.getText().toString())
                .set(data)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                    builder.dismiss();
                    openLogin();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Something went wrong..", Toast.LENGTH_SHORT).show();
                    builder.dismiss();
                });
    }

    private void openLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}

