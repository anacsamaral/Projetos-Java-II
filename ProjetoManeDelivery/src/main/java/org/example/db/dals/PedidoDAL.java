package org.example.db.dals;

import org.example.db.entidades.Pedido;
import org.example.db.entidades.TipoPagamento;
import org.example.db.util.IDAL;
import org.example.db.util.SingletonDB;

import java.sql.ResultSet;
import java.util.List;
import java.util.Locale;

public class PedidoDAL implements IDAL<Pedido> {
    @Override
    public boolean gravar(Pedido entidade) {
        boolean ok = true;
        try{
            SingletonDB.getConexao().getConnect().setAutoCommit(false);
            String sql = """
                    INSERT INTO pedido(
                    ped_data, ped_clinome, ped_clifone, ped_total, ped_entregue, tpg_id, ped_local, ped_numero_res)
                    VALUES ('#1', '#2', '#3', #4, '#5', #6, '#7', '#8');
                    """;
            sql = sql.replace("#1",entidade.getData().toString());
            sql = sql.replace("#2",entidade.getNomeCliente());
            sql = sql.replace("#3",entidade.getFoneCliente());
            sql = sql.replace("#4",String.format(Locale.US, "%.2f",entidade.getTotal());
            sql = sql.replace("#5",entidade.getEntrega());
            sql = sql.replace("#6","" + entidade.getTipoPagamento().getId());
            sql = sql.replace("#7",entidade.getLocal());
            sql = sql.replace("#8",entidade.getNumero());
            if (SingletonDB.getConexao().manipular(sql){
                SingletonDB.getConexao().getMaxPK("pedido", "ped_id");
                List<Pedido.Item> itemList = entidade.getItens();
                for(Pedido.Item it : itemList){
                    String sql2 = "INSERT INTO item(pro_id, ped_id, it_quant, it_valor) VALUES (#1, #2, #3, #4)";
                    sql2 = sql2.replace("#1", ""+it.produto().getId());
                    sql2 = sql2.replace("#2","" + id);
                    sql2 = sql2.replace("#3","" + it.quant());
                    sql2 = sql2.replace("#4", String.format(Locale.US, "%.2f",it.valor()));

                    if(!SingletonDB.getConexao().manipular(sql2))
                        ok = false;
                }
            }else ok = false;
            if(ok)
                SingletonDB.getConexao().getConnect().commit();
            else
                SingletonDB.getConexao().getConnect().rollback();
            SingletonDB.getConexao().getConnect().setAutoCommit(true);
        } catch (Exception e) {
            return ok;
        }
    }
}

//    @Override
//    public boolean alterar(Pedido entidade) {
//        // apagar todos os itens do pedido
//        // fazer update na tabela pedido
//        // inserir os itens do pedido novamente
//        return false;
//    }

//    @Override
//    public boolean apagar(Pedido entidade) {
//        // apagar todos os itens do pedido
//        // apagar o pedido
//        return false;
//    }

    @Override
    public Pedido get(int id) {
        Pedido pedido = null;
        try {
            String sql = "SELECT * FROM pedido WHERE ped_id = " + id;
            SingletonDB.getConexao().consultar(sql);
            ResultSet rs = SingletonDB.getConexao().consultar(sql);
            if(rs.next()){
                pedido = new Pedido(rs.getInt("ped_id"), rs.getDate("ped_data").toLocalDate().toString(), rs.getString("ped_clinome"), rs.getString("ped_clifone"), rs.getString("ped_local"), rs.getInt("ped_numero_res"), rs.getString("ped_entregue"), rs.getDouble("ped_total"), new TipoPagamentoDAL().get(rs.getInt("tpg_id"));
            }
            String sql2 = "SELECT * FROM item WHERE ped_id = "+pedido.getId();
            ResultSet rs2 = SingletonDB.getConexao().consultar(sql2);
            while(rs2.next())
                pedido.addItem(new ProdutoDAL().get(rs2.getInt("pro_id")), rs2.getInt("it_quant"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pedido;
    }

    @Override
    public List<Pedido> get(String filtro) {
        return List.of();
    }
}
