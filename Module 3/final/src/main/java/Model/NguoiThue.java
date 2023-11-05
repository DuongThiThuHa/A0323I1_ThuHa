package Model;

public class NguoiThue {
    private int maNguoiThue;
    private String tenNguoiThue;
    private String soDienThoai;

    public NguoiThue(int maNguoiThue, String tenNguoiThue, String soDienThoai) {
        this.maNguoiThue = maNguoiThue;
        this.tenNguoiThue = tenNguoiThue;
        this.soDienThoai = soDienThoai;
    }

    public int getMaNguoiThue() {
        return maNguoiThue;
    }

    public void setMaNguoiThue(int maNguoiThue) {
        this.maNguoiThue = maNguoiThue;
    }

    public String getTenNguoiThue() {
        return tenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) {
        this.tenNguoiThue = tenNguoiThue;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
