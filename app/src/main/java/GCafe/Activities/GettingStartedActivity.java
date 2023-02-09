package GCafe.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.example.cafe.R;
import com.example.cafe.databinding.ActivityCategoryBinding;
import com.example.cafe.databinding.ActivityGettingStartedBinding;

public class GettingStartedActivity extends AppCompatActivity {

    ActivityGettingStartedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGettingStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        VideoView videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoloop);
        videoview.setVideoURI(uri);
        videoview.setOnPreparedListener(mediaPlayer -> mediaPlayer.setLooping(true));
        videoview.start();

        binding.getstartedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GettingStartedActivity.this,MainActivity.class));
            }
        });
    }
}