package org.example.db.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    // inner **record
    public static record Item(Produto produto, int quant, double valor){}

    private int id;
    private LocalDate data;
    private String nomeCliente;
    private String foneCliente;
    private String local;
    private String numero;
    private String entrega;
    private double total;
    private TipoPagamento tipoPagamento;
    private List<Item> itens;

    public Pedido(int id, LocalDate data, String nomeCliente, String foneCliente, String local, String numero, String entrega, double total, TipoPagamento tipoPagamento) {
        this.id = id;
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.foneCliente = foneCliente;
        this.local = local;
        this.numero = numero;
        this.entrega = entrega;
        this.total = total;
        this.tipoPagamento = tipoPagamento;
        itens = new ArrayList<>();
    }

    public Pedido(LocalDate data, String nomeCliente, String foneCliente, String local, String numero, String entrega, double total, TipoPagamento tipoPagamento) {
        this(0,data,nomeCliente, foneCliente,local, numero, entrega, total, tipoPagamento);
    }

    public Pedido() {
        this(0,LocalDate.now(),"","","","","N",0,null);
    }

    public boolean addItem(Produto produto, int quantidade){
        return itens.add(new Item(produto,quantidade,quantidade * produto.getPreco()));
    }

    public List<Item> getItens() {
        return itens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getFoneCliente() {
        return foneCliente;
    }

    public void setFoneCliente(String foneCliente) {
        this.foneCliente = foneCliente;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
