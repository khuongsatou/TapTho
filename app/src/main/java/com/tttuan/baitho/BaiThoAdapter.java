package com.tttuan.baitho;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tttuan.docbao.R;

import java.util.ArrayList;

public class BaiThoAdapter extends RecyclerView.Adapter<BaiThoAdapter.BaiThoHolder> {
    private ArrayList<BaiTho> baiThoArrayList;
    private LayoutInflater inflater;

    public BaiThoAdapter(ArrayList<BaiTho> baiThoArrayList, Context context) {
        this.baiThoArrayList = baiThoArrayList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BaiThoAdapter.BaiThoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.inflater.inflate(R.layout.custom_item_bai_tho,parent,false);
        return new BaiThoHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiThoAdapter.BaiThoHolder holder, int position) {
        BaiTho baiTho = baiThoArrayList.get(position);
        holder.text_tieu_de_1.setText(baiTho.getTieuDe());
        holder.text_tac_gia_1.setText(baiTho.getTacGia());
    }

    @Override
    public int getItemCount() {
        return baiThoArrayList.size();
    }

    public class BaiThoHolder extends RecyclerView.ViewHolder {
        private TextView text_tieu_de_1,text_tac_gia_1;
        private BaiThoAdapter adapter;

        public BaiThoHolder(@NonNull View itemView, BaiThoAdapter adapter) {
            super(itemView);
            this.adapter = adapter;

            this.text_tac_gia_1  = itemView.findViewById(R.id.text_tac_gia_1);
            this.text_tieu_de_1  = itemView.findViewById(R.id.text_tieu_de_1);
        }


    }
}
