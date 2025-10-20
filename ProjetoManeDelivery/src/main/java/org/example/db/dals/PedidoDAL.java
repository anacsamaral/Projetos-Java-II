package org.example.db.dals;

import org.example.db.entidades.ItemPedido;
import org.example.db.entidades.Pedido;
import org.example.db.util.IDAL;
import org.example.db.util.SingletonDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PedidoDAL implements IDAL<Pedido> {

    @Override
    public boolean gravar(Pedido entidade) {
        try {
            SingletonDB.getConexao().begin(); // Inicia a transação

            String sqlPedido = "INSERT INTO pedido (nome_cliente, telefone_cliente, cep, localizacao_completa, " +
                    "numero_residencia, valor_total, entregue, id_tipo_pagamento) VALUES ('#1', '#2', '#3', '#4', '#5', #6, #7, #8)";

            sqlPedido = sqlPedido.replace("#1", entidade.getNomeCliente());
            sqlPedido = sqlPedido.replace("#2", entidade.getTelefoneCliente());
            sqlPedido = sqlPedido.replace("#3", entidade.getCep());
            sqlPedido = sqlPedido.replace("#4", entidade.getLocalizacao());
            sqlPedido = sqlPedido.replace("#5", entidade.getNumeroResidencia());
            sqlPedido = sqlPedido.replace("#6", entidade.getValorTotal().toString());
            sqlPedido = sqlPedido.replace("#7", "" + entidade.isEntregue());
            sqlPedido = sqlPedido.replace("#8", "" + entidade.getTipoPagamento().getId());

            if (!SingletonDB.getConexao().manipular(sqlPedido)) {
                throw new SQLException("Falha ao inserir o pedido na tabela principal.");
            }

            // Recupera o último ID inserido (específico do PostgreSQL)
            int pedidoId = -1;
            ResultSet rs = SingletonDB.getConexao().consultar("SELECT lastval()");
            if (rs != null && rs.next()) {
                pedidoId = rs.getInt(1);
            }
            if (pedidoId == -1) {
                throw new SQLException("Não foi possível recuperar o ID do pedido inserido.");
            }
            entidade.setId(pedidoId);

            // Gravar os Itens do Pedido
            for (ItemPedido item : entidade.getItens()) {
                String sqlItem = "INSERT INTO item_pedido (id_pedido, id_produto, quantidade, preco_unitario) VALUES (#1, #2, #3, #4)";
                sqlItem = sqlItem.replace("#1", "" + pedidoId);
                sqlItem = sqlItem.replace("#2", "" + item.getProduto().getId());
                sqlItem = sqlItem.replace("#3", "" + item.getQuantidade());
                sqlItem = sqlItem.replace("#4", item.getPrecoUnitario().toString());

                if (!SingletonDB.getConexao().manipular(sqlItem)) {
                    throw new SQLException("Falha ao inserir item do pedido: " + item.getProduto().getNome());
                }
            }

            SingletonDB.getConexao().commit(); // Efetiva a transação se tudo deu certo
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao gravar pedido. Realizando rollback... " + e.getMessage());
            SingletonDB.getConexao().rollback(); // Desfaz a transação em caso de erro
            return false;
        }
    }

    // Método para a tela de gerenciamento de pedidos, para alterar o status de entrega
    public boolean atualizarStatusEntrega(Pedido entidade, boolean entregue) {
        String sql = "UPDATE pedido SET entregue=" + entregue + " WHERE id=" + entidade.getId();
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean alterar(Pedido entidade) {
        // A alteração completa de um pedido (mudando itens) é complexa.
        // Normalmente se apaga os itens antigos e insere os novos.
        // Para este projeto, o mais comum é apenas mudar o status ou dados do cliente.
        System.err.println("Método 'alterar' de PedidoDAL não implementado de forma completa.");
        return false;
    }

    @Override
    public boolean apagar(Pedido entidade) {
        // Se a chave estrangeira em item_pedido foi criada com ON DELETE CASCADE,
        // apagar o pedido aqui irá apagar os itens automaticamente.
        return SingletonDB.getConexao().manipular("DELETE FROM pedido WHERE id=" + entidade.getId());
    }

    @Override
    public Pedido get(int id) {
        // Buscar um pedido completo com seus itens exigiria múltiplas consultas.
        System.err.println("Método 'get(id)' de PedidoDAL não implementado nesta versão.");
        return null;
    }

    @Override
    public List<Pedido> get(String filtro) {
        // A implementação da busca de todos os pedidos pode ser feita aqui,
        // similarmente à busca de produtos, usando JOIN com a tabela tipo_pagamento.
        System.err.println("Método 'get(filtro)' de PedidoDAL não implementado nesta versão.");
        return null;
    }
}