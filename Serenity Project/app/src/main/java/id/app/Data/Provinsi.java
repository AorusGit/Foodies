package id.app.Data;

import javafx.beans.property.*;

public class Provinsi {
    private final IntegerProperty id;
    private final StringProperty nama;

    public Provinsi(String nama) {
        this.id = new SimpleIntegerProperty();
        this.nama = new SimpleStringProperty(nama);
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

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public StringProperty namaProperty() {
        return nama;
    }
}