package id.app.Data;


public class Foods {
    private int id;
    private int provinsiId;
    private String nama;
    private String deskripsi;

    public Foods(){}

    public Foods(String nama){
        this.nama = nama;
    }
    
    public Foods(int provinsiId, String nama, String deskripsi) {
        this.provinsiId = provinsiId;
        this.nama = nama;
        this.deskripsi = deskripsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinsiId() {
        return provinsiId;
    }

    public void setProvinsiId(int provinsiId) {
        this.provinsiId = provinsiId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
