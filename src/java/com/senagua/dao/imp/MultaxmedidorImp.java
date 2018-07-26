/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.contrato.IMulta;
import com.senagua.dao.contrato.IMultaxmedidor;
import com.senagua.rnegocio.entidades.Multaxmedidor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class MultaxmedidorImp implements IMultaxmedidor {

    @Override
    public int insertar(Multaxmedidor multaxmedidor) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO multaxmedidor(idmultamedidor, idmedidor, idmulta, fecha, detalle)\n"
                + "    VALUES (?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, multaxmedidor.getIdmultamedidor()));
        lstPar.add(new Parametro(2, multaxmedidor.getMedidor().getIdmedidor()));
        lstPar.add(new Parametro(3, multaxmedidor.getMulta().getIdmulta()));
        lstPar.add(new Parametro(4, multaxmedidor.getFecha()));
        lstPar.add(new Parametro(5, multaxmedidor.getDetalle()));

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
    public int modificar(Multaxmedidor multaxmedidor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE multaxmedidor SET idmedidor=?, idmulta=?, fecha=?, detalle=?\n"
                + " WHERE idmultamedidor=? ";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, multaxmedidor.getMedidor().getIdmedidor()));
        lstPar.add(new Parametro(2, multaxmedidor.getMulta().getIdmulta()));
        lstPar.add(new Parametro(3, multaxmedidor.getFecha()));
        lstPar.add(new Parametro(4, multaxmedidor.getDetalle()));
        lstPar.add(new Parametro(5, multaxmedidor.getIdmultamedidor()));
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
    public int eliminar(Multaxmedidor multaxmedidor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM multaxmedidor"
                + " WHERE idmultamedidor=" + multaxmedidor.getIdmultamedidor();
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
    public Multaxmedidor obtener(int idmultamedidor) throws Exception {
        Multaxmedidor multaxmedidor = null;
        String sql = "SELECT idmultamedidor, idmedidor, idmulta, fecha, detalle\n"
                + "  FROM multaxmedidor WHERE idmultamedidor=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idmultamedidor));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                multaxmedidor = new Multaxmedidor();
                IMedidor medidor = new MedidorImp();
                IMulta multa = new MultaImp();
                multaxmedidor.setIdmultamedidor(rst.getInt(1));
                multaxmedidor.setMedidor(medidor.obtener(rst.getInt(2)));
                multaxmedidor.setMulta(multa.obtener(rst.getInt(3)));
                multaxmedidor.setFecha(rst.getDate(4));
                multaxmedidor.setDetalle(rst.getString(5));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return multaxmedidor;
    }

    @Override
    public List<Multaxmedidor> obtener() throws Exception {
        List<Multaxmedidor> lista = new ArrayList<>();
        String sql = "SELECT idmultamedidor, idmedidor, idmulta, fecha, detalle\n"
                + "  FROM multaxmedidor";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Multaxmedidor multaxmedidor = new Multaxmedidor();
                IMedidor medidor = new MedidorImp();
                IMulta multa = new MultaImp();
                multaxmedidor.setIdmultamedidor(rst.getInt(1));
                multaxmedidor.setMedidor(medidor.obtener(rst.getInt(2)));
                multaxmedidor.setMulta(multa.obtener(rst.getInt(3)));
                multaxmedidor.setFecha(rst.getDate(4));
                multaxmedidor.setDetalle(rst.getString(5));
                lista.add(multaxmedidor);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

    @Override
    public int eliminar() throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM multaxmedidor";
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

}
