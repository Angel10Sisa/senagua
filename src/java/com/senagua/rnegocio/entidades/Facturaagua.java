/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.rnegocio.entidades;

import java.util.Date;

/**
 *
 * @author Angel-Pc
 */
public class Facturaagua {
    private int idfactura;
    private Medidor medidor;
    private Empleado empleado;
    private Date fecha;
    private String direccion;
    private Precio precio;
    private Consumo idconsumo;
    private int consumobasico;
    private int consumoexceso;
    private double valorconsumobasico;
    private double valorconsumoexceso;
    private double subtotalconsumo;
    private double descuento;
    private double totalpagar;
    private String detalle;
    private String estado;

    public Facturaagua() {
    }

    public Facturaagua(int idfactura, Medidor medidor, Empleado empleado, Date fecha, String direccion, Precio precio, Consumo idconsumo, int consumobasico, int consumoexceso, double valorconsumobasico, double valorconsumoexceso, double subtotalconsumo, double descuento, double totalpagar, String detalle, String estado) {
        this.idfactura = idfactura;
        this.medidor = medidor;
        this.empleado = empleado;
        this.fecha = fecha;
        this.direccion = direccion;
        this.precio = precio;
        this.idconsumo = idconsumo;
        this.consumobasico = consumobasico;
        this.consumoexceso = consumoexceso;
        this.valorconsumobasico = valorconsumobasico;
        this.valorconsumoexceso = valorconsumoexceso;
        this.subtotalconsumo = subtotalconsumo;
        this.descuento = descuento;
        this.totalpagar = totalpagar;
        this.detalle = detalle;
        this.estado = estado;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public Consumo getIdconsumo() {
        return idconsumo;
    }

    public void setIdconsumo(Consumo idconsumo) {
        this.idconsumo = idconsumo;
    }

    public int getConsumobasico() {
        return consumobasico;
    }

    public void setConsumobasico(int consumobasico) {
        this.consumobasico = consumobasico;
    }

    public int getConsumoexceso() {
        return consumoexceso;
    }

    public void setConsumoexceso(int consumoexceso) {
        this.consumoexceso = consumoexceso;
    }

    public double getValorconsumobasico() {
        return valorconsumobasico;
    }

    public void setValorconsumobasico(double valorconsumobasico) {
        this.valorconsumobasico = valorconsumobasico;
    }

    public double getValorconsumoexceso() {
        return valorconsumoexceso;
    }

    public void setValorconsumoexceso(double valorconsumoexceso) {
        this.valorconsumoexceso = valorconsumoexceso;
    }

    public double getSubtotalconsumo() {
        return subtotalconsumo;
    }

    public void setSubtotalconsumo(double subtotalconsumo) {
        this.subtotalconsumo = subtotalconsumo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotalpagar() {
        return totalpagar;
    }

    public void setTotalpagar(double totalpagar) {
        this.totalpagar = totalpagar;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
