package Model;

import java.util.Date;

public class Rent {
    private int id;
    private PhongTro phongTro;
    private NguoiThue nguoiThue;
    private Date ngayThue;
    private String hinhThuc;
    private String ghiChu;

    public Rent(int id, PhongTro phongTro, NguoiThue nguoiThue, Date ngayThue, String hinhThuc, String ghiChu) {
        this.id = id;
        this.phongTro = phongTro;
        this.nguoiThue = nguoiThue;
        this.ngayThue = ngayThue;
        this.hinhThuc = hinhThuc;
        this.ghiChu = ghiChu;
    }

    public Rent(String name, PhongTro phongTro, int maNguoiThue, Date ngayThue) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PhongTro getPhongTro() {
        return phongTro;
    }

    public void setPhongTro(PhongTro phongTro) {
        this.phongTro = phongTro;
    }

    public NguoiThue getNguoiThue() {
        return nguoiThue;
    }

    public void setNguoiThue(NguoiThue nguoiThue) {
        this.nguoiThue = nguoiThue;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
