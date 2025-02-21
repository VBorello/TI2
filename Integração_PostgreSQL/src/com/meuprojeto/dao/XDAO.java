package com.meuprojeto.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.meuprojeto.model.X;

public class XDAO {
    private final String URL = "jdbc:postgresql://localhost:5432/nome_do_banco";
    private final String USER = "meu_usuario";
    private final String PASSWORD = "minha_senha";

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // CREATE
    public void inserir(X x) {
        String sql = "INSERT INTO X (nome, idade) VALUES (?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, x.getNome());
            stmt.setInt(2, x.getIdade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<X> listar() {
        List<X> lista = new ArrayList<>();
        String sql = "SELECT * FROM X";
        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                X x = new X(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"));
                lista.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // UPDATE
    public void atualizar(X x) {
        String sql = "UPDATE X SET nome = ?, idade = ? WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, x.getNome());
            stmt.setInt(2, x.getIdade());
            stmt.setInt(3, x.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void excluir(int id) {
        String sql = "DELETE FROM X WHERE id = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
