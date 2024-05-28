package id.app.Controller;

import id.app.Data.Provinsi;
import id.app.Connector.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinsiController {
    public static List<Provinsi> getAllProvinsi() {
        List<Provinsi> provinsi = new ArrayList<>();
        String sql = "SELECT * FROM provinsi";
    
        try (Connection conn = DatabaseConnector.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
    
          while (rs.next()) {
            Provinsi provinsi1 = new Provinsi(rs.getString("nama"));
            provinsi1.setId(rs.getInt("id"));
            provinsi.add(provinsi1);
          }
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
    
        return provinsi;
      }
}
