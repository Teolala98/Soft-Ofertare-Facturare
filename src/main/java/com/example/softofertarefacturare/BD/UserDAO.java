package com.example.softofertarefacturare.BD;

import com.example.softofertarefacturare.BD.BazaDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


        public int insertOferta(double pretTotal, double pretTva) {
            String sql = "INSERT INTO oferta (pret_total, pret_tva) VALUES (?, ?)";
            int generatedId = -1;
            try (Connection conn = BazaDate.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                pstmt.setDouble(1, pretTotal);
                pstmt.setDouble(2, pretTva);


                pstmt.executeUpdate();


                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getInt(1);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return generatedId;
        }


        public void insertProdus(int idOferta, String denumireProdus, int cantitate, double pret) {
            String sql = "INSERT INTO produse_oferta (id_oferta, denumire_produs, cantitate, pret) VALUES (?, ?, ?, ?)";

            try (Connection conn = BazaDate.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, idOferta);
                pstmt.setString(2, denumireProdus);
                pstmt.setInt(3, cantitate);
                pstmt.setDouble(4, pret);

                // Execute the insert statement
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

