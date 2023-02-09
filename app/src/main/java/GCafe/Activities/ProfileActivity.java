package GCafe.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cafe.R;
import com.example.cafe.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        couponcode();
        Rateus();
        OrderHistory();
        Payment();
        Logout();
    }

    private void couponcode() {
        binding.codeapplybtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Not Applicable", Toast.LENGTH_SHORT).show();
                binding.usercode.setText("Not Applicable!");
            }
        });
    }

    private void Rateus() {
        binding.rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Under Construction", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileActivity.this,UnderConstructionActivity.class));
            }
        });
    }

    private void OrderHistory() {
        binding.userorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Under Construction", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileActivity.this,UnderConstructionActivity.class));
            }
        });
    }

    private void Payment() {
        binding.userpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Under Construction", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileActivity.this,UnderConstructionActivity.class));
            }
        });
    }

    private void Logout(){
        binding.userlogoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, "Logging out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProfileActivity.this,GettingStartedActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}