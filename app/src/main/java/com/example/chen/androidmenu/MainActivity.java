package com.example.chen.androidmenu;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
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
        registerForContextMenu(tvColor);//menu绑定视图
    }

    /**
     * 创建选项菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.font_size, menu);

        // 搜索
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        MenuItem itemSearch = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) itemSearch.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        // 分享
        MenuItem itemShare = menu.findItem(R.id.action_share);
        // 在获取ShareActionProvider时使用的是MenuItemCompat.getActionProvider(item)方法，
        // 官网给出的方法是item.getActionProvider()，但在v7包中使用ShareActionProvider这种方法不可行
        ShareActionProvider actionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(itemShare);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Hi, I'm fleming");
        intent.setType("text/plain");
        actionProvider.setShareIntent(intent);
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

    /**
     * 创建上下文菜单
     * @param menu
     * @param v
     * @param menuInfo
     */
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
}
