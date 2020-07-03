package com.example.mvvmwithhilt.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvvmwithhilt.R;
import com.example.mvvmwithhilt.databinding.ActivityMainBinding;
import com.example.mvvmwithhilt.ui.fragments.Favorites;
import com.example.mvvmwithhilt.ui.fragments.Home;

import dagger.hilt.android.AndroidEntryPoint;


//https://medium.com/swlh/mvvm-with-hilt-rxjava-3-retrofit-room-live-data-and-view-binding-8da9bb1004bf
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean isFavoriteListVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home())
                .commit();

        binding.changeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFavoriteListVisible){
                    isFavoriteListVisible = false;
                    binding.changeFragment.setText("Favorites");
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home())
                            .commit();
                }
                else {
                    isFavoriteListVisible = true;
                    binding.changeFragment.setText("Home");
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Favorites())
                            .commit();
                }
            }
        });
    }
}