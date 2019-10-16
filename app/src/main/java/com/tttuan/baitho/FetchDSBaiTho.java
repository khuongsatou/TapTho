package com.tttuan.baitho;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FetchDSBaiTho extends AsyncTask<Void, Void, String> {
    private WeakReference<ArrayList<BaiTho>> baiThoWeakReferences;
    private WeakReference<BaiThoAdapter> adapter;

    public FetchDSBaiTho(ArrayList<BaiTho> baiThoWeakReferences,BaiThoAdapter adapter) {
        this.baiThoWeakReferences = new WeakReference<>(baiThoWeakReferences);
        this.adapter  = new WeakReference<>(adapter);
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("tap_tho");
            for(int i=0; i<itemsArray.length(); i++) {
                BaiTho baiTho = new BaiTho();
                //baiTho.setId(itemsArray.getJSONObject(i).getInt("id"));
                baiTho.setTieuDe(itemsArray.getJSONObject(i).getString("tieu_de"));
                baiTho.setTacGia(itemsArray.getJSONObject(i).getString("tac_gia"));

                this.baiThoWeakReferences.get().add(baiTho);
            }


            this.adapter.get().notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(Void... voids) {
        return NetworkUtils.getJSONData("api.php", "GET");
    }
}
