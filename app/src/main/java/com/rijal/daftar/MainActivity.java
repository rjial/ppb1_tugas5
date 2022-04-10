package com.rijal.daftar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItem = (ListView) findViewById(R.id.lvItem);
        lvItem.setAdapter(new MenuAdapter(this, R.layout.row, Menu.listMenu));
    }

    class MenuAdapter extends ArrayAdapter<Menu> {

        public MenuAdapter(@NonNull Context context, int resource, @NonNull List<Menu> objects) {
            super(context, resource, objects);
            this.listMenu = objects;
            this.resource = resource;
            this.context = context;
        }
        List<Menu> listMenu;
        int resource;
        Context context;

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
            imgIcon.setImageResource(listMenu.get(position).getIcon());
            txtLabel.setText(listMenu.get(position).getName());
            Menu menu = listMenu.get(position);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listMenu.get(position).getName() == "Keluar") {
                        finishAffinity();
                    } else {
                        Intent intent = new Intent(MainActivity.this, MenuSubActivity.class);
                        intent.putExtra("MENU", menu);
                        startActivity(intent);
//                        Toast.makeText(MainActivity.this, listMenu.get(position).getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return view;
        }
    }
}