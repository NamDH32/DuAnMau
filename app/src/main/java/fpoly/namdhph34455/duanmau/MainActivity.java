package fpoly.namdhph34455.duanmau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import fpoly.namdhph34455.duanmau.fragment.fragmentAddTv;
import fpoly.namdhph34455.duanmau.fragment.fragmentDoanhthu;
import fpoly.namdhph34455.duanmau.fragment.fragmentDoimatkhau;
import fpoly.namdhph34455.duanmau.fragment.fragmentLoaiS;
import fpoly.namdhph34455.duanmau.fragment.fragmentPM;
import fpoly.namdhph34455.duanmau.fragment.fragmentSach;
import fpoly.namdhph34455.duanmau.fragment.fragmentTV;
import fpoly.namdhph34455.duanmau.fragment.fragmentTop10;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView view = findViewById(R.id.navigation_view);
        // set toolbar thay cho ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View header = view.getHeaderView(0);
        TextView tv_user = header.findViewById(R.id.tvTen);
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");

        tv_user.setText("Welcome "+user);
        if (!user.equalsIgnoreCase("admin")){
            view.getMenu().findItem(R.id.nv_addUser).setVisible(false);
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open_name,R.string.close_name);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new fragmentPM()).commit();
        getSupportActionBar().setTitle("Quản Lý Phiếu Mượn");
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int position = item.getItemId();
                if (position == R.id.nv_quanLyPhieuMuon){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new fragmentPM()).commit();
                    getSupportActionBar().setTitle("Quản Lý Phiếu Mượn");
                    drawerLayout.close();
                }else if (position == R.id.nv_quanLyLS){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new fragmentLoaiS()).commit();
                    getSupportActionBar().setTitle("Quản Lý Loại Sách");
                    drawerLayout.close();
                } else if (position == R.id.nv_quanLyS) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new fragmentSach()).commit();
                    getSupportActionBar().setTitle("Quản Lý Sách");
                    drawerLayout.close();
                } else if (position == R.id.nv_quanLyTV) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new fragmentTV()).commit();
                    getSupportActionBar().setTitle("Quản Lý Thành Viên");
                    drawerLayout.close();
                } else if(position == R.id.nv_doiMK){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new fragmentDoimatkhau()).commit();
                    getSupportActionBar().setTitle("Đổi mật khẩu");
                    drawerLayout.close();
                } else if (position == R.id.nv_top10) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new fragmentTop10()).commit();
                    getSupportActionBar().setTitle("Top 10 Sách mượn nhiều nhất");
                    drawerLayout.close();
                } else if (position == R.id.nv_doanhThu) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new fragmentDoanhthu()).commit();
                    getSupportActionBar().setTitle("Doanh Thu");
                    drawerLayout.close();
                } else if (position == R.id.nv_addUser) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new fragmentAddTv()).commit();
                    getSupportActionBar().setTitle("Thêm Thành Viên");
                    drawerLayout.close();
                } else if (position == R.id.nv_dangXuat) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
                return true;
            }
        });
    }
}