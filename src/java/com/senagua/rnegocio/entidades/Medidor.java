/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.rnegocio.entidades;

/**
 *
 * @author Usuario
 */
public class Medidor {
    private int idmedidor;
    private String numeromedidor;
    private Cliente cliente;
    private Tipomedidor tipo;
    private String marca;
    private String modelo;
    private String detalle;

    public Medidor() {
    }

    public Medidor(int idmedidor, String numeromedidor, Cliente cliente, Tipomedidor tipo, String marca, String modelo, String detalle) {
        this.idmedidor = idmedidor;
        this.numeromedidor = numeromedidor;
        this.cliente = cliente;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.detalle = detalle;
    }

    public int getIdmedidor() {
        return idmedidor;
    }

    public void setIdmedidor(int idmedidor) {
        this.idmedidor = idmedidor;
    }

    public String getNumeromedidor() {
        return numeromedidor;
    }

    public void setNumeromedidor(String numeromedidor) {
        this.numeromedidor = numeromedidor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tipomedidor getTipo() {
        return tipo;
    }

    public void setTipo(Tipomedidor tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    
}
