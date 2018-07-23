/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.ICuenta;
import com.senagua.dao.contrato.IDebe;
import com.senagua.rnegocio.entidades.Cuenta;
import com.senagua.rnegocio.entidades.Debe;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DebeImp implements IDebe {

    @Override
    public int insertar(Debe debe) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO debe(iddebe, cuenta, documento, valor, detalle, fecha)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, debe.getIddebe()));
        lstPar.add(new Parametro(2, debe.getCuenta().getIdcuenta()));
        lstPar.add(new Parametro(3, debe.getDocumento()));
        lstPar.add(new Parametro(4, debe.getValor()));
        lstPar.add(new Parametro(5, debe.getDetalle()));
        lstPar.add(new Parametro(6, debe.getFecha()));
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
    public int modificar(Debe debe) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE debe SET cuenta=?, documento=?, valor=?, detalle=?, fecha=?\n"
                + " WHERE iddebe=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, debe.getCuenta().getIdcuenta()));
        lstPar.add(new Parametro(2, debe.getDocumento()));
        lstPar.add(new Parametro(3, debe.getValor()));
        lstPar.add(new Parametro(4, debe.getDetalle()));
        lstPar.add(new Parametro(5, debe.getFecha()));
        lstPar.add(new Parametro(6, debe.getIddebe()));
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
    public int eliminar(Debe debe) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM debe"
                + " WHERE iddebe=" + debe.getIddebe();
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
    public Debe obtener(int iddebe) throws Exception {
        Debe debe = null;
        String sql = "SELECT iddebe, cuenta, documento, valor, detalle, fecha\n"
                + "  FROM debe WHERE iddebe=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, iddebe));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                debe = new Debe();
                ICuenta cuenta = new CuentaImp();
                debe.setIddebe(rst.getInt(1));
                debe.setCuenta(cuenta.obtener(rst.getInt(2)));
                debe.setDocumento(rst.getInt(3));
                debe.setValor(rst.getDouble(4));
                debe.setDetalle(rst.getString(5));
                debe.setFecha(rst.getDate(6));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return debe;
    }

    @Override
    public List<Debe> obtener() throws Exception {
        List<Debe> lista = new ArrayList<>();
        String sql = "SELECT iddebe, cuenta, documento, valor, detalle, fecha\n"
                + "  FROM debe;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Debe debe = new Debe();
                ICuenta cuenta = new CuentaImp();
                debe.setIddebe(rst.getInt(1));
                debe.setCuenta(cuenta.obtener(rst.getInt(2)));
                debe.setDocumento(rst.getInt(3));
                debe.setValor(rst.getDouble(4));
                debe.setDetalle(rst.getString(5));
                debe.setFecha(rst.getDate(6));
                lista.add(debe);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
