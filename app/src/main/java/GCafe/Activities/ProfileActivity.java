package GCafe.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cafe.R;
import com.example.cafe.databinding.ActivityProfileBinding;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_GALLERY = 2;
    private EditText editTextInput;
    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        couponcode();
//        Rateus();
//        OrderHistory();
//        Payment();
//        Logout();
    }
//..........................................
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView avatarImageView = findViewById(R.id.userimg);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                avatarImageView.setImageBitmap(imageBitmap);
            } else if (requestCode == REQUEST_IMAGE_GALLERY) {
                Uri selectedImageUri = data.getData();
                avatarImageView.setImageURI(selectedImageUri);
            }
        }
    }

    //..................................

    private void couponcode() {

        Button buttonApply = findViewById(R.id.codeapplybtn);
        editTextInput = findViewById(R.id.usercode);

        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInput.getText().toString().trim();
                if (inputText.isEmpty()) {
                    Toast.makeText(ProfileActivity.this, "Please enter the code", Toast.LENGTH_SHORT).show();
                } else {
                    SpannableString styledText = new SpannableString("Not Applied");
                    styledText.setSpan(new ForegroundColorSpan(Color.RED), 0, styledText.length(), 0);
                    styledText.setSpan(new StyleSpan(Typeface.BOLD), 0, styledText.length(), 0);
                    Toast.makeText(ProfileActivity.this, styledText, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    private void Rateus() {
//        binding.rateus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ProfileActivity.this, "Under Construction", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(ProfileActivity.this,UnderConstructionActivity.class));
//            }
//        });
//    }

//    private void OrderHistory() {
//        binding.userorder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ProfileActivity.this, "Under Construction", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(ProfileActivity.this,UnderConstructionActivity.class));
//            }
//        });
//    }

//    private void Payment() {
//        binding.userpayment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ProfileActivity.this, "Under Construction", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(ProfileActivity.this,UnderConstructionActivity.class));
//            }
//        });
//    }

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