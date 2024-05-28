package id.app.Data;

import javafx.beans.property.*;

public class Foods {
    private final IntegerProperty id;
    private final IntegerProperty provinsiId;
    private final StringProperty nama;
    private final StringProperty asal;
    private final StringProperty deskripsi;

    public Foods(int id, int provinsiId,String nama,String asal,String deskripsi) {
        this.id = new SimpleIntegerProperty();
        this.provinsiId = new SimpleIntegerProperty(provinsiId);
        this.nama = new SimpleStringProperty(nama);
        this.asal = new SimpleStringProperty(asal);
        this.deskripsi = new SimpleStringProperty(deskripsi);
      }
    
    public int getId() {
        return id.get();
        }
    
    public void setId(int id) {
        this.id.set(id);
        }

    public IntegerProperty idProperty() {
        return id;
        }

    public int getProvinsiId() {
        return provinsiId.get();
        }

    public void setProvinsiId(int provinsiId) {
        this.provinsiId.set(provinsiId);
        }
    
    public IntegerProperty provinsiIdProperty() {
        return provinsiId;
    }
    
    public String getNama() {
        return nama.get();
    }
    
    public void setNama(String nama) {
        this.nama.set(nama);
    }
    
    public StringProperty namaProperty() {
        return nama;
    }
    
    public String getAsal() {
        return asal.get();
    }

    public void setAsal(String asal) {
        this.asal.set(asal);
    }

    public StringProperty asalProperty() {
        return asal;
        }
    
    public String getDeskripsi() {
        return deskripsi.get();
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi.set(deskripsi);
    }

    public StringProperty deskripsiProperty() {
        return asal;
        }
}
