package id.app.Data;

import javafx.beans.property.*;

public class Provinsi {
    private final IntegerProperty id;
    private final StringProperty name;

    public Provinsi(String name) {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty(name);
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
        return name.get();
    }

    public void setNama(String name) {
        this.name.set(name);
    }

    public StringProperty namaProperty() {
        return name;
    }
}