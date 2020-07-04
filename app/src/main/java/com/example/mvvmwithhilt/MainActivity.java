package com.example.mvvmwithhilt;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvmwithhilt.databinding.ActivityMainBinding;

import java.util.ArrayList;

//https://medium.com/@abhinav.s0612/exploring-view-binding-in-activities-fragments-dialogs-and-recyclerview-adapters-789f84b31a2a
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.greetingText.setText("Hello, Reader.");

        // to initialize recycler view
        ArrayList<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        adapter = new CustomAdapter(list,this);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        // to open dialog
        binding.startDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog dialog = new CustomDialog();
                dialog.show(getSupportFragmentManager(),"Custom Dialog");
            }
        });

        // to show fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new DemoFragment())
                .commit();


    }
}