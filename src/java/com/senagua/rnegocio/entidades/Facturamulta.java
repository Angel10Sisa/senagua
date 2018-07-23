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
public class Facturamulta {
    private int idfactura;
    private Medidor medidor;
    private Empleado empleado;
    private Date fecha;
    private String direccion;
    private Multaxmedidor multamedidor;
    private double subtotalmulta;
    private double descuento;
    private double totalpagar;
    private String detalle;
    private String estado;

    public Facturamulta() {
    }

    public Facturamulta(int idfactura, Medidor medidor, Empleado empleado, Date fecha, String direccion, Multaxmedidor multamedidor, double subtotalmulta, double descuento, double totalpagar, String detalle, String estado) {
        this.idfactura = idfactura;
        this.medidor = medidor;
        this.empleado = empleado;
        this.fecha = fecha;
        this.direccion = direccion;
        this.multamedidor = multamedidor;
        this.subtotalmulta = subtotalmulta;
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

    public Multaxmedidor getMultamedidor() {
        return multamedidor;
    }

    public void setMultamedidor(Multaxmedidor multamedidor) {
        this.multamedidor = multamedidor;
    }

    public double getSubtotalmulta() {
        return subtotalmulta;
    }

    public void setSubtotalmulta(double subtotalmulta) {
        this.subtotalmulta = subtotalmulta;
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
