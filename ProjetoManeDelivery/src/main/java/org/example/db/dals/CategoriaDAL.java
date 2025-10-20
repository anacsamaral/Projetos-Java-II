package org.example.db.dals;

import org.example.db.entidades.Categoria;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAL {

    public class CategoriaDAL implements IDAL<Categoria> {
        @Override
        public boolean gravar(Categoria entidade) {
            String sql="INSERT INTO categoria (cat_nome) VALUES ('#1')";
            sql=sql.replace("#1", entidade.getNome());
            return SingletonDB.getConexao().manipular(sql);
        }

        @Override
        public boolean alterar(Categoria entidade) {
            String sql="UPDATE categoria SET cat_nome='#1' WHERE cat_id=#2";
            sql=sql.replace("#1", entidade.getNome());
            sql=sql.replace("#2", ""+entidade.getId());
            return SingletonDB.getConexao().manipular(sql);
        }

        @Override
        public boolean apagar(Categoria entidade) {
            return SingletonDB.getConexao().manipular("DELETE FROM categoria WHERE cat_id="+entidade.getId());
        }

        @Override
        public Categoria get(int id) {
            Categoria categoria=null;
            String sql="SELECT * FROM categoria WHERE cat_id="+id;
            ResultSet rs=SingletonDB.getConexao().consultar(sql);
            try {
                if (rs.next())
                    categoria = new Categoria(rs.getInt("cat_id"), rs.getString("cat_nome"));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return categoria;
        }

        @Override
        public List<Categoria> get(String filtro) {
            List <Categoria> categoriaList=new ArrayList<>();
            String sql="SELECT * FROM categoria";
            if(!filtro.isEmpty())
                sql+=" WHERE "+filtro;
            ResultSet rs=SingletonDB.getConexao().consultar(sql);
            try {
                while (rs.next()) {
                    Categoria categoria = new Categoria(rs.getInt("cat_id"), rs.getString("cat_nome"));
                    categoriaList.add(categoria);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return categoriaList;
        }
    }

}
