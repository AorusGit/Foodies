
package id.app.Data;

//inheritance
public class Provinsi extends Foods {

    public Provinsi() {
        super();
    }

    public Provinsi(String nama) {
        super(nama);
    }

    public Provinsi(int id, String nama) {
        super(nama);
        setId(id);
    }
}