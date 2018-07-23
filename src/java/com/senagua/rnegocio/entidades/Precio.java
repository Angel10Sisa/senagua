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
public class Precio {

    private int idprecio;
    private double preciobasico;
    private double precioexceso;
    private String detalle;

    public Precio() {
    }

    public Precio(int idprecio, double preciobasico, double precioexceso, String detalle) {
        this.idprecio = idprecio;
        this.preciobasico = preciobasico;
        this.precioexceso = precioexceso;
        this.detalle = detalle;
    }

    public int getIdprecio() {
        return idprecio;
    }

    public void setIdprecio(int idprecio) {
        this.idprecio = idprecio;
    }

    public double getPreciobasico() {
        return preciobasico;
    }

    public void setPreciobasico(double preciobasico) {
        this.preciobasico = preciobasico;
    }

    public double getPrecioexceso() {
        return precioexceso;
    }

    public void setPrecioexceso(double precioexceso) {
        this.precioexceso = precioexceso;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    

}
