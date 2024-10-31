package com.example.softofertarefacturare.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private void insertOferta(double pretTotal, double pretTva){
    String sql = "INSERT INTO oferta (pret_total,pret_tva) VALUES (?,?)";
        try (Connection conn = BazaDate.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, pretTotal);
            pstmt.setDouble(2, pretTva);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
}

    }
}



