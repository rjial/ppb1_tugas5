package com.rijal.daftar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

public class ItemActivity extends AppCompatActivity {

    ImageView imgItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Intent intent = getIntent();
        MenuSub menuSub = intent.getParcelableExtra("ITEM");
        getSupportActionBar().setTitle(menuSub.getName());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        imgItem = (ImageView) findViewById(R.id.imgItem);
        imgItem.setImageResource(menuSub.gambar);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigateUp() {
        finish();
        return true;
    }
}