package id.app.Data;

import javafx.beans.property.*;

public class Foods {
    private final IntegerProperty id;
    private final IntegerProperty provinsiId;
    private final StringProperty name;
    private final StringProperty asal;
    private final StringProperty deskripsi;

    public Foods(int provinsiId,String name,String asal,String deskripsi) {
        this.id = new SimpleIntegerProperty();
        this.provinsiId = new SimpleIntegerProperty(provinsiId);
        this.name = new SimpleStringProperty(name);
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
        return name.get();
    }
    
    public void setNama(String name) {
        this.name.set(name);
    }
    
    public StringProperty namaProperty() {
        return name;
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
        return deskripsi;
        }
}
