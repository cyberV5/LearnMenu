package com.example.chen.learnmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvHello;
    private TextView tvColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tvHello = (TextView) findViewById(R.id.tv_hello);
        tvColor = (TextView) findViewById(R.id.tv_color);
        registerForContextMenu(tvColor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.font_size, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.font_color, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red:
                tvColor.setTextColor(Color.RED);
                break;
            case R.id.green:
                tvColor.setTextColor(Color.GREEN);
                break;
            case R.id.blue:
                tvColor.setTextColor(Color.BLUE);
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.size_12sp:
                tvHello.setTextSize(12);
                break;
            case R.id.size_14sp:
                tvHello.setTextSize(14);
                break;
            case R.id.size_16sp:
                tvHello.setTextSize(16);
                break;
            case R.id.size_18sp:
                tvHello.setTextSize(18);
                break;
            case R.id.size_22sp:
                tvHello.setTextSize(22);
                break;
        }
        return true;
    }
}
