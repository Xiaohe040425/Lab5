package com.example.lab5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // 連接 main.xml 佈局

        Button btn = findViewById(R.id.button);  // 綁定 Button 元件
        btn.setOnClickListener(new View.OnClickListener() {  // Button 設定事件
            @Override
            public void onClick(View view) {
                showAlertDialog();  // 執行顯示 AlertDialog 的方法
            }
        });
    }

    private void showAlertDialog() {
        // 建立 AlertDialog 物件並設定標題與訊息
        final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("請根據下方按鈕選擇要顯示的物件");
        dialog.setMessage("根據下方按鈕顯示不同的物件");

        // 中立按鈕：顯示一般的 Toast 訊息
        dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "dialog關閉", Toast.LENGTH_SHORT).show();
            }
        });

        // 負面按鈕：顯示自定義的 Toast
        dialog.setNegativeButton("自定義 Toast", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast();  // 執行自定義 Toast 的顯示方法
            }
        });

        // 正面按鈕：顯示包含列表的對話框
        dialog.setPositiveButton("顯示 List", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showListDialog();  // 執行列表對話框的顯示方法
            }
        });

        dialog.show();  // 顯示對話框
    }

    private void showToast() {
        Toast toast = new Toast(MainActivity.this);
        toast.setGravity(Gravity.TOP, 0, 50);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_root));
        toast.setView(layout);
        toast.show();
    }


    private void showListDialog() {
        final String[] list = {"message1", "message2", "message3"};
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
        dialog_list.setTitle("列表選單");
        dialog_list.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,
                        "你選擇了" + list[i],
                        Toast.LENGTH_SHORT).show();
            }
        });
        dialog_list.show();
    }
}