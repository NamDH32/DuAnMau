package fpoly.namdhph34455.duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class manHinhCho extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinhcho);
        ImageView ivm = findViewById(R.id.imv_anh);
        Glide.with(this).load(R.drawable.anh1).into(ivm);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(manHinhCho.this,LoginActivity.class));
            }
        },5000);
    }
}