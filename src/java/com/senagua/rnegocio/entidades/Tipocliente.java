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
public class Tipocliente {

    private int idtipocliente;
    private String nombre;
    private String descuento;
    private double valor;
    private String detalle;

    public Tipocliente() {
    }

    public Tipocliente(int idtipocliente, String nombre, String descuento, double valor, String detalle) {
        this.idtipocliente = idtipocliente;
        this.nombre = nombre;
        this.descuento = descuento;
        this.valor = valor;
        this.detalle = detalle;
    }

    public int getIdtipocliente() {
        return idtipocliente;
    }

    public void setIdtipocliente(int idtipocliente) {
        this.idtipocliente = idtipocliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
