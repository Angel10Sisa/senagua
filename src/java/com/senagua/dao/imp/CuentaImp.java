/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.ICuenta;
import com.senagua.rnegocio.entidades.Cuenta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CuentaImp implements ICuenta {

    @Override
    public int insertar(Cuenta cuenta) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO cuenta(idcuenta, nombre, detalle) VALUES (?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getIdcuenta()));
        lstPar.add(new Parametro(2, cuenta.getNombre()));
        lstPar.add(new Parametro(3, cuenta.getDetalle()));
        Conexion con = new Conexion();
        try {
            afectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        }finally{
            con.desconectar();
        }
        return afectadas;
    }

    @Override
    public int modificar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuenta SET nombre=?, detalle=? WHERE idcuenta=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getNombre()));
        lstPar.add(new Parametro(2, cuenta.getDetalle()));
        lstPar.add(new Parametro(3, cuenta.getIdcuenta()));
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
    public int eliminar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM cuenta"
                + " WHERE idcuenta=" + cuenta.getIdcuenta();
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
    public Cuenta obtener(int idcuenta) throws Exception {
        Cuenta cuenta = null;
        String sql = "SELECT idcuenta, nombre, detalle"
                + "  FROM cuenta WHERE idcuenta=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idcuenta));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                cuenta = new Cuenta();
                cuenta.setIdcuenta(rst.getInt(1));
                cuenta.setNombre(rst.getString(2));
                cuenta.setDetalle(rst.getString(3));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cuenta;
    }

    @Override
    public List<Cuenta> obtener() throws Exception {
        List<Cuenta> lista = new ArrayList<>();
        String sql = "SELECT idcuenta, nombre, detalle"
                + "  FROM cuenta;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setIdcuenta(rst.getInt(1));
                cuenta.setNombre(rst.getString(2));
                cuenta.setDetalle(rst.getString(3));
                lista.add(cuenta);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
