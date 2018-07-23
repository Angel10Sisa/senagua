/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.ICuenta;
import com.senagua.dao.contrato.IHaber;
import com.senagua.rnegocio.entidades.Haber;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class HaberImp implements IHaber{

    @Override
    public int insertar(Haber haber) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO haber(idhaber, cuenta, documento, valor, detalle, fecha)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, haber.getIdhaber()));
        lstPar.add(new Parametro(2, haber.getCuenta().getIdcuenta()));
        lstPar.add(new Parametro(3, haber.getDocumento()));
        lstPar.add(new Parametro(4, haber.getValor()));
        lstPar.add(new Parametro(5, haber.getDetalle()));
        lstPar.add(new Parametro(6, haber.getFecha()));
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
    public int modificar(Haber haber) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE haber SET cuenta=?, documento=?, valor=?, detalle=?, fecha=?\n"
                + " WHERE idhaber=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, haber.getCuenta().getIdcuenta()));
        lstPar.add(new Parametro(2, haber.getDocumento()));
        lstPar.add(new Parametro(3, haber.getValor()));
        lstPar.add(new Parametro(4, haber.getDetalle()));
        lstPar.add(new Parametro(5, haber.getFecha()));
        lstPar.add(new Parametro(6, haber.getIdhaber()));
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
    public int eliminar(Haber haber) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM haber"
                + " WHERE idhaber=" + haber.getIdhaber();
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
    public Haber obtener(int idhaber) throws Exception {
        Haber haber = null;
        String sql = "SELECT idhaber, cuenta, documento, valor, detalle, fecha\n"
                + "  FROM haber WHERE idhaber=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idhaber));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                haber = new Haber();
                ICuenta cuenta = new CuentaImp();
                haber.setIdhaber(rst.getInt(1));
                haber.setCuenta(cuenta.obtener(rst.getInt(2)));
                haber.setDocumento(rst.getInt(3));
                haber.setValor(rst.getDouble(4));
                haber.setDetalle(rst.getString(5));
                haber.setFecha(rst.getDate(6));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return haber;
    }

    @Override
    public List<Haber> obtener() throws Exception {
        List<Haber> lista = new ArrayList<>();
        String sql = "SELECT idhaber, cuenta, documento, valor, detalle, fecha\n"
                + "  FROM haber;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Haber haber = new Haber();
                ICuenta cuenta = new CuentaImp();
                haber.setIdhaber(rst.getInt(1));
                haber.setCuenta(cuenta.obtener(rst.getInt(2)));
                haber.setDocumento(rst.getInt(3));
                haber.setValor(rst.getDouble(4));
                haber.setDetalle(rst.getString(5));
                haber.setFecha(rst.getDate(6));
                lista.add(haber);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
