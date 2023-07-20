package com.example.sudip_new_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sudip_new_project.Fragments.GMapsFragment;
import com.example.sudip_new_project.Fragments.InfoFragment;
import com.example.sudip_new_project.Fragments.MapFragment;
import com.example.sudip_new_project.databinding.ActivityMainBinding;
import com.iammert.library.readablebottombar.ReadableBottomBar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new GMapsFragment());
        transaction.commit();

        binding.readableBottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {
                bottom_Selection(i);
            }
        });
    }

    private void bottom_Selection(int i) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (i) {
            case 0:
                transaction.replace(R.id.container, new GMapsFragment());
                break;
            case 1:
                transaction.replace(R.id.container, new InfoFragment());
                break;
        }
        transaction.commit();

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.drawable.healthcare);
        builder.setMessage("Do you want to exit?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}