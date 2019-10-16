package com.tttuan.baitho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.tttuan.docbao.R;

public class ChiTietActivity extends AppCompatActivity {

    private TextView mNoiDungTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);

        this.mNoiDungTextView = findViewById(R.id.text_bai_tho);

        new FetchBaiTho(mNoiDungTextView, getSupportActionBar()).execute(id);
    }
}
