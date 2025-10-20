package org.example.db.dals;

import org.example.db.entidades.TipoPagamento;
import org.example.db.util.IDAL;
import org.example.db.util.SingletonDB;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoPagamentoDAL implements IDAL<TipoPagamento> {

    @Override
    public boolean gravar(TipoPagamento entidade) {
        String sql = "INSERT INTO tipo_pagamento (nome) VALUES ('#1')";
        sql = sql.replace("#1", entidade.getNome());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean alterar(TipoPagamento entidade) {
        String sql = "UPDATE tipo_pagamento SET nome='#1' WHERE id=#2";
        sql = sql.replace("#1", entidade.getNome());
        sql = sql.replace("#2", "" + entidade.getId());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean apagar(TipoPagamento entidade) {
        return SingletonDB.getConexao().manipular("DELETE FROM tipo_pagamento WHERE id=" + entidade.getId());
    }

    @Override
    public TipoPagamento get(int id) {
        TipoPagamento tipoPagamento = null;
        String sql = "SELECT * FROM tipo_pagamento WHERE id=" + id;
        ResultSet rs = SingletonDB.getConexao().consultar(sql);
        try {
            if (rs != null && rs.next()) {
                tipoPagamento = new TipoPagamento(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar tipo de pagamento por ID: " + e.getMessage());
        }
        return tipoPagamento;
    }

    @Override
    public List<TipoPagamento> get(String filtro) {
        List<TipoPagamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipo_pagamento";
        if (filtro != null && !filtro.isEmpty()) {
            // Usando ILIKE para busca case-insensitive no PostgreSQL
            sql += " WHERE nome ILIKE '%" + filtro + "%'";
        }
        ResultSet rs = SingletonDB.getConexao().consultar(sql);
        try {
            while (rs != null && rs.next()) {
                lista.add(new TipoPagamento(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar tipos de pagamento: " + e.getMessage());
        }
        return lista;
    }
}