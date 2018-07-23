/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.ITipoempleado;
import com.senagua.rnegocio.entidades.Tipoempleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TipoempleadoImp implements ITipoempleado {

    @Override
    public int insertar(Tipoempleado tipoempleado) {
        int afectadas = 0;
        String sql = "INSERT INTO public.tipoempleado(idtipoempleado, nombre, observacion) VALUES (?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, tipoempleado.getIdtipoempleado()));
        lstPar.add(new Parametro(2, tipoempleado.getNombre()));
        lstPar.add(new Parametro(3, tipoempleado.getObservacion()));
        Conexion con = new Conexion();
        try {
            afectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        }
        return afectadas;
    }

    @Override
    public int modificar(Tipoempleado tipoempleado) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE tipoempleado SET nombre=?, observacion=? WHERE idtipoempleado=?";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(3, tipoempleado.getIdtipoempleado()));
        lstPar.add(new Parametro(1, tipoempleado.getNombre()));
        lstPar.add(new Parametro(2, tipoempleado.getObservacion()));
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
    public int eliminar(Tipoempleado tipoempleado) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM tipoempleado"
                + " WHERE idtipoempleado=" + tipoempleado.getIdtipoempleado();
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
    public Tipoempleado obtener(int idtipoempleado) throws Exception {
        Tipoempleado tipoempleado = null;
        String sql = "SELECT idtipoempleado, nombre, observacion"
                + "  FROM tipoempleado WHERE idtipoempleado=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idtipoempleado));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                tipoempleado = new Tipoempleado();
                tipoempleado.setIdtipoempleado(rst.getInt(1));
                tipoempleado.setNombre(rst.getString(2));
                tipoempleado.setObservacion(rst.getString(3));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return tipoempleado;
    }

    @Override
    public List<Tipoempleado> obtener() throws Exception {
        List<Tipoempleado> lista = new ArrayList<>();
        String sql = "SELECT idtipoempleado, nombre, observacion"
                + "  FROM tipoempleado;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Tipoempleado tipoempleado = new Tipoempleado();
                tipoempleado = new Tipoempleado();
                tipoempleado.setIdtipoempleado(rst.getInt(1));
                tipoempleado.setNombre(rst.getString(2));
                tipoempleado.setObservacion(rst.getString(3));
                lista.add(tipoempleado);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

    @Override
    public Tipoempleado obtener(String nombre) throws Exception {
        Tipoempleado tipoempleado = null;
        String sql = "SELECT idtipoempleado, nombre, observacion"
                + "  FROM tipoempleado WHERE nombre=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, nombre));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                tipoempleado = new Tipoempleado();
                tipoempleado.setIdtipoempleado(rst.getInt(1));
                tipoempleado.setNombre(rst.getString(2));
                tipoempleado.setObservacion(rst.getString(3));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return tipoempleado;
    }

}
