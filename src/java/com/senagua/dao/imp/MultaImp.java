/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.IMulta;
import com.senagua.rnegocio.entidades.Multa;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MultaImp implements IMulta {

    @Override
    public int insertar(Multa multa) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO multa(idmulta, nombre, valor, fecha, descripcion)\n"
                + "    VALUES (?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, multa.getIdmulta()));
        lstPar.add(new Parametro(2, multa.getNombre()));
        lstPar.add(new Parametro(3, multa.getValor()));
        lstPar.add(new Parametro(4, multa.getFecha()));
        lstPar.add(new Parametro(5, multa.getDescripcion()));
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
    public int modificar(Multa multa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE multa SET nombre=?, valor=?, fecha=?, descripcion=? WHERE idmulta=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, multa.getNombre()));
        lstPar.add(new Parametro(2, multa.getValor()));
        lstPar.add(new Parametro(3, multa.getFecha()));
        lstPar.add(new Parametro(4, multa.getDescripcion()));
        lstPar.add(new Parametro(5, multa.getIdmulta()));
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
    public int eliminar(Multa multa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM multa"
                + " WHERE idmulta=" + multa.getIdmulta();
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
    public Multa obtener(int idmulta) throws Exception {
        Multa multa = null;
        String sql = "SELECT idmulta, nombre, valor, fecha, descripcion\n"
                + "  FROM multa WHERE idmulta=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idmulta));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                multa = new Multa();
                multa.setIdmulta(rst.getInt(1));
                multa.setNombre(rst.getString(2));
                multa.setValor(rst.getDouble(3));
                multa.setFecha(rst.getDate(4));
                multa.setDescripcion(rst.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return multa;
    }

    @Override
    public List<Multa> obtener() throws Exception {
        List<Multa> lista = new ArrayList<>();
        String sql = "SELECT idmulta, nombre, valor, fecha, descripcion\n"
                + "  FROM multa;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Multa multa = new Multa();
                multa.setIdmulta(rst.getInt(1));
                multa.setNombre(rst.getString(2));
                multa.setValor(rst.getDouble(3));
                multa.setFecha(rst.getDate(4));
                multa.setDescripcion(rst.getString(5));
                lista.add(multa);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
