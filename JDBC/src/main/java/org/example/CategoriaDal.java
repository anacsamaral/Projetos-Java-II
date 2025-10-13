package org.example;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.List;

public class CategoriaDal implements IDAL<Categoria>{
    @Override
    public boolean gravar(Categoria categoria){
        String sql = "INSERT INTO categoria (ca_nome) VALUES ('#1')"; // token que vai ser substituido no replace
        sql = sql.replace("#1", categoria.getNome());

        boolean ok = false;

        Conexao conexao = new Conexao();
        if(!conexao.conectar("jdbc:postgresql://localhost:5433/","acervo_db","postgres", "postgres123"))
            System.out.println("Problemas de Conexão: " + conexao.getMensagemErro());
        else
            ok = conexao.manipular(sql);

        return ok;

    }

    @Override
    public boolean alterar(Categoria categoria) {
        String sql = "UPDATE categoria SET ca_nome = '#1' WHERE ca_id = #2";
        sql = sql.replace("#1", categoria.getNome());
        sql = sql.replace("#1", "" + categoria.getNome());

        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean apagar(Categoria categoria) {
        return SingletonDB.getConexao().manipular("DELETE FROM categoria WHERE ca_id" + categoria.getId());
    }

    @Override
    public Categoria get(int id) {
        Categoria categoria = null;
        String sql = "SELECT * FROM categoria WHERE ca_id = "+id;
        ResultSet resultSet =
    }

    @Override
    public List<Categoria> get(String filtro) {
        return List.of();
    }
}
