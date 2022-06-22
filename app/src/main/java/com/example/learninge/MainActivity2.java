package com.example.learninge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<String> level = new ArrayList<String>();;
        level.add("Cơ bản");
        level.add("Từ 500 - 600 toeic");
        level.add("Từ 700 trở lên");


        setContentView(R.layout.activity_main2);




        RecyclerView recyclerView = findViewById(R.id.recycler);
        mainadapter mainadapter = new mainadapter(this,level);
        recyclerView.setAdapter(mainadapter);
        recyclerView.setLayoutManager(new  LinearLayoutManager(this));
        DrawerLayout drawerLayout = findViewById(R.id.drawable);
        findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.menu);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.totranslate:{
                Intent intent = new Intent(this,Translate.class);
                startActivity(intent);
                break;
            }
            case R.id.logout:{
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(this,Login.class);
                startActivity(intent);
                break;
            }
            case R.id.index:{
                Intent intent = new Intent(this,MainActivity2.class);
                startActivity(intent);
                break;
            }
        }
        DrawerLayout drawerLayout = findViewById(R.id.drawable);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}