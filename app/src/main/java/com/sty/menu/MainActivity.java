package com.sty.menu;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //第一种添加菜单的方法
        //getMenuInflater().inflate(R.menu.main, menu);

        //第二种添加菜单的方法
        menu.add(0, 1, 0, "后退");
        menu.add(0, 1, 0, "前进");
        return true;
    }

    /**
     * 想知道具体点击的是menu的哪个条目 需要重写这个方法
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Log.i(TAG, "后退----");
                break;
            case 2:
                Log.i(TAG, "前进----");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 当点击menu按键时执行这个方法
     * @param featureId
     * @param menu
     * @return  return false时将不再执行onCreateOptionsMenu()方法
     */
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("您的网络异常");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "您点击了确定按钮");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i(TAG, "您点击了取消按钮");
            }
        });
        builder.show();
        return false;
    }
}
