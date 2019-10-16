package com.tttuan.baitho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tttuan.docbao.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvTapTho;
    private ArrayList<BaiTho> baiThoArrayList;
    private BaiThoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Radiation();
        CreateApdater();


    }

    private void CreateApdater() {
        baiThoArrayList = new ArrayList<>();
        adapter = new BaiThoAdapter(baiThoArrayList,this);
        rcvTapTho.setLayoutManager(new LinearLayoutManager(this));
        rcvTapTho.setAdapter(adapter);

        new FetchDSBaiTho(baiThoArrayList,adapter).execute();

    }

    private void Radiation() {
        rcvTapTho  = findViewById(R.id.rcvTapTho);
    }

    public void chiTiet(View view) {
        String itemTag = (String)view.getTag();
        Intent intent = new Intent(this, ChiTietActivity.class);
        intent.putExtra("ID", Integer.parseInt(itemTag));
        startActivity(intent);
    }
}
