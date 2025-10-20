package org.example.db.dals;

import org.example.db.entidades.Categoria;
import org.example.db.entidades.Marca;
import org.example.db.entidades.Produto;
import org.example.db.util.IDAL;
import org.example.db.util.SingletonDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAL implements IDAL<Produto> {

    @Override
    public boolean gravar(Produto entidade) {
        String sql = "INSERT INTO produto (nome, preco, volume_ml, id_categoria, id_marca) VALUES ('#1', #2, #3, #4, #5)";
        sql = sql.replace("#1", entidade.getNome());
        sql = sql.replace("#2", entidade.getPreco().toString());
        sql = sql.replace("#3", "" + entidade.getVolume());
        sql = sql.replace("#4", "" + entidade.getCategoria().getId());
        sql = sql.replace("#5", "" + entidade.getMarca().getId());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean alterar(Produto entidade) {
        String sql = "UPDATE produto SET nome='#1', preco=#2, volume_ml=#3, id_categoria=#4, id_marca=#5 WHERE id=#6";
        sql = sql.replace("#1", entidade.getNome());
        sql = sql.replace("#2", entidade.getPreco().toString());
        sql = sql.replace("#3", "" + entidade.getVolume());
        sql = sql.replace("#4", "" + entidade.getCategoria().getId());
        sql = sql.replace("#5", "" + entidade.getMarca().getId());
        sql = sql.replace("#6", "" + entidade.getId());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean apagar(Produto entidade) {
        return SingletonDB.getConexao().manipular("DELETE FROM produto WHERE id=" + entidade.getId());
    }

    private Produto criarProduto(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria(rs.getInt("cat_id"), rs.getString("cat_nome"));
        Marca marca = new Marca(rs.getInt("mar_id"), rs.getString("mar_nome"));

        return new Produto(
                rs.getInt("prod_id"),
                rs.getString("prod_nome"),
                rs.getBigDecimal("preco"),
                rs.getInt("volume_ml"),
                categoria,
                marca
        );
    }

    @Override
    public Produto get(int id) {
        Produto produto = null;
        String sql = "SELECT p.id as prod_id, p.nome as prod_nome, p.preco, p.volume_ml, " +
                "c.id as cat_id, c.nome as cat_nome, m.id as mar_id, m.nome as mar_nome " +
                "FROM produto p JOIN categoria c ON p.id_categoria = c.id " +
                "JOIN marca m ON p.id_marca = m.id WHERE p.id=" + id;

        ResultSet rs = SingletonDB.getConexao().consultar(sql);
        try {
            if (rs != null && rs.next()) {
                produto = criarProduto(rs);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar produto por ID: " + e.getMessage());
        }
        return produto;
    }

    @Override
    public List<Produto> get(String filtro) {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT p.id as prod_id, p.nome as prod_nome, p.preco, p.volume_ml, " +
                "c.id as cat_id, c.nome as cat_nome, m.id as mar_id, m.nome as mar_nome " +
                "FROM produto p JOIN categoria c ON p.id_categoria = c.id " +
                "JOIN marca m ON p.id_marca = m.id";
        if (filtro != null && !filtro.isEmpty()) {
            sql += " WHERE p.nome ILIKE '%" + filtro + "%'";
        }
        sql += " ORDER BY p.nome";

        ResultSet rs = SingletonDB.getConexao().consultar(sql);
        try {
            while (rs != null && rs.next()) {
                lista.add(criarProduto(rs));
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar produtos: " + e.getMessage());
        }
        return lista;
    }
}