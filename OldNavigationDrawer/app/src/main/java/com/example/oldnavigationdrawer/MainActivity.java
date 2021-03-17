package com.example.oldnavigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.oldnavigationdrawer.fragment.ActivityFragment;
import com.example.oldnavigationdrawer.fragment.BroadcastFragment;
import com.example.oldnavigationdrawer.fragment.ContentProviderFragment;
import com.example.oldnavigationdrawer.fragment.ServiceFragment;
import com.example.oldnavigationdrawer.fragment.SecurityFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        //navigate the menu
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //reduce memory usage
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ActivityFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_activity_part);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_activity_part:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ActivityFragment()).commit();
                break;
            case R.id.nav_service_part:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ServiceFragment()).commit();
                break;
            case R.id.nav_broadcast_part:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BroadcastFragment()).commit();
                break;
            case R.id.nav_content_provider_part:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContentProviderFragment()).commit();
                break;
            case R.id.nav_security_part:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SecurityFragment()).commit();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}