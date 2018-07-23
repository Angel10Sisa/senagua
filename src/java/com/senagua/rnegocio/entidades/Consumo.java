/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.rnegocio.entidades;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Consumo {
    private int idconsumo;
    private Medidor medidor;
    private int lecturainicial;
    private Date fechalecturainicial;
    private int lecturanterior;
    private Date fechalecturaanterior;
    private int lecturaactual;
    private Date  fechalecturaactual;
    private int lecturafinal;
    private Date fechalecturafinal;
    private int consumo;

    public Consumo() {
    }

    public Consumo(int idconsumo, Medidor medidor, int lecturainicial, Date fechalecturainicial, int lecturanterior, Date fechalecturaanterior, int lecturaactual, Date fechalecturaactual, int lecturafinal, Date fechalecturafinal, int consumo) {
        this.idconsumo = idconsumo;
        this.medidor = medidor;
        this.lecturainicial = lecturainicial;
        this.fechalecturainicial = fechalecturainicial;
        this.lecturanterior = lecturanterior;
        this.fechalecturaanterior = fechalecturaanterior;
        this.lecturaactual = lecturaactual;
        this.fechalecturaactual = fechalecturaactual;
        this.lecturafinal = lecturafinal;
        this.fechalecturafinal = fechalecturafinal;
        this.consumo = consumo;
    }

    public int getIdconsumo() {
        return idconsumo;
    }

    public void setIdconsumo(int idconsumo) {
        this.idconsumo = idconsumo;
    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public int getLecturainicial() {
        return lecturainicial;
    }

    public void setLecturainicial(int lecturainicial) {
        this.lecturainicial = lecturainicial;
    }

    public Date getFechalecturainicial() {
        return fechalecturainicial;
    }

    public void setFechalecturainicial(Date fechalecturainicial) {
        this.fechalecturainicial = fechalecturainicial;
    }

    public int getLecturanterior() {
        return lecturanterior;
    }

    public void setLecturanterior(int lecturanterior) {
        this.lecturanterior = lecturanterior;
    }

    public Date getFechalecturaanterior() {
        return fechalecturaanterior;
    }

    public void setFechalecturaanterior(Date fechalecturaanterior) {
        this.fechalecturaanterior = fechalecturaanterior;
    }

    public int getLecturaactual() {
        return lecturaactual;
    }

    public void setLecturaactual(int lecturaactual) {
        this.lecturaactual = lecturaactual;
    }

    public Date getFechalecturaactual() {
        return fechalecturaactual;
    }

    public void setFechalecturaactual(Date fechalecturaactual) {
        this.fechalecturaactual = fechalecturaactual;
    }

    public int getLecturafinal() {
        return lecturafinal;
    }

    public void setLecturafinal(int lecturafinal) {
        this.lecturafinal = lecturafinal;
    }

    public Date getFechalecturafinal() {
        return fechalecturafinal;
    }

    public void setFechalecturafinal(Date fechalecturafinal) {
        this.fechalecturafinal = fechalecturafinal;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    
}
