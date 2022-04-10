package com.rijal.daftar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MenuSubActivity extends AppCompatActivity {

    ListView lvSubMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sub);
        Intent intent = getIntent();
        Menu menu = intent.getParcelableExtra("MENU");
        getSupportActionBar().setTitle(menu.getName());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        lvSubMenu = (ListView) findViewById(R.id.lvSubMenu);
        lvSubMenu.setAdapter(new MenuSubAdapter(this, R.layout.row, menu.getMenuSubs()));
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

    class MenuSubAdapter extends ArrayAdapter<MenuSub> {

        Context context;
        int resource;
        List<MenuSub> menuSubList;
        public MenuSubAdapter(@NonNull Context context, int resource, @NonNull List<MenuSub> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
            this.menuSubList = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(this.resource, parent, false);
            }
            ImageView imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
            TextView txtLabel = (TextView) view.findViewById(R.id.txtLabel);
            imgIcon.setImageResource(menuSubList.get(position).getIcon());
            txtLabel.setText(menuSubList.get(position).getName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (menuSubList.get(position).name) {
                        case "Kembali":
                            finish();
                            break;
                        case "Ke Menu Music": {
                            Intent intent = getIntent();
                            intent.putExtra("MENU", Menu.listMenu.get(2));
                            finish();
                            startActivity(intent);

                            break;
                        }
                        case "Ke Menu Film": {
                            Intent intent = getIntent();
                            intent.putExtra("MENU", Menu.listMenu.get(1));
                            finish();
                            startActivity(intent);
                            break;
                        }
                        case "Ke Menu Game": {
                            Intent intent = getIntent();
                            intent.putExtra("MENU", Menu.listMenu.get(0));
                            finish();
                            startActivity(intent);
                            break;
                        }
                        case "Ke Menu Makanan": {
                            Intent intent = getIntent();
                            intent.putExtra("MENU", Menu.listMenu.get(3));
                            finish();
                            startActivity(intent);
                            break;
                        }
                        default: {
                            Intent intent = new Intent(MenuSubActivity.this, ItemActivity.class);
                            intent.putExtra("ITEM", menuSubList.get(position));
                            startActivity(intent);
//                        Toast.makeText(MenuSubActivity.this, menuSubList.get(position).getName(), Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                }
            });
//            return super.getView(position, convertView, parent);
            return view;
        }
    }
}