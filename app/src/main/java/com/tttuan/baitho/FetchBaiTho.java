package com.tttuan.baitho;

import android.os.AsyncTask;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class FetchBaiTho extends AsyncTask<Integer, Void, String> {
    private WeakReference<TextView> wBaiThoTextView;
    private WeakReference<ActionBar> wActionBar;

    public FetchBaiTho(TextView textView, ActionBar actionBar) {
        this.wBaiThoTextView = new WeakReference<>(textView);
        this.wActionBar = new WeakReference<>(actionBar);
    }
    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONObject baiThoObject = jsonObject.getJSONObject("bai_tho");
            if(baiThoObject != null) {
                this.wActionBar.get().setTitle(baiThoObject.getString("tieu_de"));
                this.wActionBar.get().setSubtitle(baiThoObject.getString("tac_gia"));
                this.wBaiThoTextView.get().setText(baiThoObject.getString("noi_dung"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(Integer... integers) {
//        ArrayList<String> nameParams = new ArrayList<>();
//        nameParams.add("id");
//        ArrayList<String> valueParams = new ArrayList<>();
//        valueParams.add(Integer.toString(integers[0] - 1));

        return NetworkUtils.getJSONData("tap-tho/" + integers[0], "GET");
    }
}
