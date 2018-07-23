/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.ITipomedidor;
import com.senagua.rnegocio.entidades.Tipomedidor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TipomedidorImp implements ITipomedidor {

    @Override
    public int insertar(Tipomedidor tipomedidor) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO tipomedidor(idtipomedidor, caracteristica, multa, observacion) VALUES (?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, tipomedidor.getIdtipomedidor()));
        lstPar.add(new Parametro(2, tipomedidor.getCaracteristica()));
        lstPar.add(new Parametro(3, tipomedidor.getMulta()));
        lstPar.add(new Parametro(4, tipomedidor.getObservacion()));
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
    public int modificar(Tipomedidor tipomedidor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE tipomedidor SET caracteristica=?, multa=?, observacion=? WHERE idtipomedidor=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, tipomedidor.getCaracteristica()));
        lstPar.add(new Parametro(2, tipomedidor.getMulta()));
        lstPar.add(new Parametro(3, tipomedidor.getObservacion()));
        lstPar.add(new Parametro(4, tipomedidor.getIdtipomedidor()));
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
    public int eliminar(Tipomedidor tipomedidor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM tipomedidor"
                + " WHERE idtipomedidor=" + tipomedidor.getIdtipomedidor();
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
    public Tipomedidor obtener(int idtipomedidor) throws Exception {
        Tipomedidor medidor = null;
        String sql = "SELECT idtipomedidor, caracteristica, multa, observacion FROM tipomedidor WHERE idtipomedidor=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idtipomedidor));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                medidor = new Tipomedidor();
                medidor.setIdtipomedidor(rst.getInt(1));
                medidor.setCaracteristica(rst.getString(2));
                medidor.setMulta(rst.getDouble(3));
                medidor.setObservacion(rst.getString(4));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return medidor;
    }

    @Override
    public List<Tipomedidor> obtener() throws Exception {
        List<Tipomedidor> lista = new ArrayList<>();
        String sql = "SELECT idtipomedidor, caracteristica, multa, observacion FROM tipomedidor;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Tipomedidor medidor = new Tipomedidor();
                medidor.setIdtipomedidor(rst.getInt(1));
                medidor.setCaracteristica(rst.getString(2));
                medidor.setMulta(rst.getDouble(3));
                medidor.setObservacion(rst.getString(4));
                lista.add(medidor);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
