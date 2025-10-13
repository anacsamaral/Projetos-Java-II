package org.example;

import java.util.List;

public class CategoriaDal implements IDAL<Categoria>{
    @Override
    public boolean alterar(Categoria entidade) {
        Categoria categoria = new Categoria();
        String sql = "UPDATE categoria SET ca_nome = '#1' WHERE ca_id = #2";
        sql = sql.replace("#1", categoria.getNome());
        sql = sql.replace("#2", categoria.getId());

        boolean ok = false;

        Conexao conexao = new Conexao();
        if(!conexao.conectar("jdbc:postgresql://localhost:5433/","acervo_db","postgres", "postgres123"))
            System.out.println("Problemas de Conexão: " + conexao.getMensagemErro());
        else
            ok = conexao.manipular(sql);

        return ok;
    }

    @Override
    public boolean apagar(Categoria entidade) {
        return false;
    }

    @Override
    public Categoria get(int id) {
        return null;
    }

    @Override
    public List<Categoria> get(String filtro) {
        return List.of();
    }

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

        // toda carga de acesso ao banco está aqui dentro, que será usado apenas uma vez

    }
}
