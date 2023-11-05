package Model;
public class PhongTro {
    private int maPhongTro;
    private String tenPhongTro;

    public PhongTro(int maPhongTro, String tenPhongTro) {
        this.maPhongTro = maPhongTro;
        this.tenPhongTro = tenPhongTro;
    }

    public int getMaPhongTro() {
        return maPhongTro;
    }

    public void setMaPhongTro(int maPhongTro) {
        this.maPhongTro = maPhongTro;
    }

    public String getTenPhongTro() {
        return tenPhongTro;
    }

    public void setTenPhongTro(String tenPhongTro) {
        this.tenPhongTro = tenPhongTro;
    }
}