package com.tttuan.baitho;

public class BaiTho {
    private int id;
    private String tieuDe;
    private String tacGia;
    private String noiDung;

    public BaiTho() {
    }

    public BaiTho(int id, String tieuDe, String tacGia, String noiDung) {
        this.id = id;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.noiDung = noiDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}

