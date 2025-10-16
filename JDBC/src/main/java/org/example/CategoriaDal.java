package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDal implements IDAL<Categoria>{
    @Override
    public boolean gravar(Categoria categoria){
        String sql="INSERT INTO categoria (ca_nome) VALUES ('#1')";
        sql=sql.replace("#1", categoria.getNome());
        Conexao conexao=new Conexao();
        boolean ok = false;
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean alterar(Categoria categoria) {
        String sql="UPDATE categoria SET ca_nome='#1' WHERE ca_id=#2";
        sql=sql.replace("#1", categoria.getNome());
        sql=sql.replace("#2", ""+categoria.getId());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean apagar(Categoria categoria) {
        return SingletonDB.getConexao().manipular("DELETE FROM categoria WHERE ca_id="+categoria.getId());
    }

    @Override
    public Categoria get(int id) {
        Categoria categoria=null;
        String sql="SELECT * FROM categoria WHERE ca_id="+id;
        ResultSet resultSet=SingletonDB.getConexao().consultar(sql);
        try {
            if (resultSet.next()) {
                categoria = new Categoria(resultSet.getInt("ca_id"), resultSet.getString("ca_nome"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }

    @Override
    public List<Categoria> get(String filtro) {
        List <Categoria> categoriaList=new ArrayList<>();
        String sql="SELECT * FROM categoria";
        if(!filtro.isEmpty())
            sql+=" WHERE "+filtro;
        ResultSet resultSet=SingletonDB.getConexao().consultar(sql);
        try {
            while (resultSet.next()) {
                Categoria categoria = new Categoria(resultSet.getInt("ca_id"), resultSet.getString("ca_nome"));
                categoriaList.add(categoria);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return categoriaList;
    }
}
