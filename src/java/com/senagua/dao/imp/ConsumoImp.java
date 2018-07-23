/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.IConsumo;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.rnegocio.entidades.Consumo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ConsumoImp implements IConsumo {

    @Override
    public int insertar(Consumo consumo) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO consumo(idconsumo, medidor, lecturainicial, fechalecturainicial, lecturaanterior, \n"
                + "            fechalecturaanterior, lecturaactual, fechalecturaactual, lecturafinal, fechalecturafinal, consumo)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, consumo.getIdconsumo()));
        lstPar.add(new Parametro(2, consumo.getMedidor().getIdmedidor()));
        lstPar.add(new Parametro(3, consumo.getLecturainicial()));
        lstPar.add(new Parametro(4, consumo.getFechalecturainicial()));
        lstPar.add(new Parametro(5, consumo.getLecturanterior()));
        lstPar.add(new Parametro(6, consumo.getFechalecturaanterior()));
        lstPar.add(new Parametro(7, consumo.getLecturaactual()));
        lstPar.add(new Parametro(8, consumo.getFechalecturaactual()));
        lstPar.add(new Parametro(9, consumo.getLecturafinal()));
        lstPar.add(new Parametro(10, consumo.getFechalecturafinal()));
        lstPar.add(new Parametro(11, consumo.getConsumo()));
        Conexion con = new Conexion();
        try {
            afectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return afectadas;
    }

    @Override
    public int modificar(Consumo consumo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE consumo SET medidor=?, lecturainicial=?, fechalecturainicial=?, \n"
                + "       lecturaanterior=?, fechalecturaanterior=?, lecturaactual=?, fechalecturaactual=?, \n"
                + "       lecturafinal=?, fechalecturafinal=?, consumo=? WHERE idconsumo=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, consumo.getMedidor().getIdmedidor()));
        lstPar.add(new Parametro(2, consumo.getLecturainicial()));
        lstPar.add(new Parametro(3, consumo.getFechalecturainicial()));
        lstPar.add(new Parametro(4, consumo.getLecturanterior()));
        lstPar.add(new Parametro(5, consumo.getFechalecturaanterior()));
        lstPar.add(new Parametro(6, consumo.getLecturaactual()));
        lstPar.add(new Parametro(7, consumo.getFechalecturaactual()));
        lstPar.add(new Parametro(8, consumo.getLecturafinal()));
        lstPar.add(new Parametro(9, consumo.getFechalecturafinal()));
        lstPar.add(new Parametro(10, consumo.getConsumo()));
        lstPar.add(new Parametro(11, consumo.getIdconsumo()));
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Consumo consumo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM consumo"
                + " WHERE idconsumo=" + consumo.getIdconsumo();
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public Consumo obtener(int idconsumo) throws Exception {
        Consumo consumo = null;
        String sql = "SELECT idconsumo, medidor, lecturainicial, fechalecturainicial, lecturaanterior, \n"
                + "       fechalecturaanterior, lecturaactual, fechalecturaactual, lecturafinal, \n"
                + "       fechalecturafinal, consumo FROM consumo WHERE idconsumo=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idconsumo));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                consumo = new Consumo();
                IMedidor medidor = new MedidorImp();
                consumo.setIdconsumo(rst.getInt(1));
                consumo.setMedidor(medidor.obtener(rst.getInt(2)));
                consumo.setLecturainicial(rst.getInt(3));
                consumo.setFechalecturainicial(rst.getDate(4));
                consumo.setLecturanterior(rst.getInt(5));
                consumo.setFechalecturaanterior(rst.getDate(6));
                consumo.setLecturaactual(rst.getInt(7));
                consumo.setFechalecturaactual(rst.getDate(8));
                consumo.setLecturafinal(rst.getInt(9));
                consumo.setFechalecturafinal(rst.getDate(10));
                consumo.setConsumo(rst.getInt(11));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return consumo;
    }

    @Override
    public List<Consumo> obtener() throws Exception {
        List<Consumo> lista = new ArrayList<>();
        String sql = "SELECT idconsumo, medidor, lecturainicial, fechalecturainicial, lecturaanterior, \n"
                + "       fechalecturaanterior, lecturaactual, fechalecturaactual, lecturafinal, \n"
                + "       fechalecturafinal, consumo FROM consumo;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Consumo consumo = new Consumo();
                IMedidor medidor = new MedidorImp();
                consumo.setIdconsumo(rst.getInt(1));
                consumo.setMedidor(medidor.obtener(rst.getInt(2)));
                consumo.setLecturainicial(rst.getInt(3));
                consumo.setFechalecturainicial(rst.getDate(4));
                consumo.setLecturanterior(rst.getInt(5));
                consumo.setFechalecturaanterior(rst.getDate(6));
                consumo.setLecturaactual(rst.getInt(7));
                consumo.setFechalecturaactual(rst.getDate(8));
                consumo.setLecturafinal(rst.getInt(9));
                consumo.setFechalecturafinal(rst.getDate(10));
                consumo.setConsumo(rst.getInt(11));
                lista.add(consumo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
