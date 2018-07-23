/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.IContabilidad;
import com.senagua.rnegocio.entidades.Contabilidad;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ContabilidadImp implements IContabilidad {

    @Override
    public int insertar(Contabilidad contabilidad) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO contabilidad(idcontabilidad, debe, haber, saldo, fecha)\n"
                + "    VALUES (?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, contabilidad.getIdcontabilidad()));
        lstPar.add(new Parametro(2, contabilidad.getDebe()));
        lstPar.add(new Parametro(3, contabilidad.getHaber()));
        lstPar.add(new Parametro(4, contabilidad.getSaldo()));
        lstPar.add(new Parametro(5, contabilidad.getFecha()));
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
    public int modificar(Contabilidad contabilidad) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE contabilidad SET debe=?, haber=?, saldo=?, fecha=?\n"
                + " WHERE idcontabilidad=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, contabilidad.getDebe()));
        lstPar.add(new Parametro(2, contabilidad.getHaber()));
        lstPar.add(new Parametro(3, contabilidad.getSaldo()));
        lstPar.add(new Parametro(4, contabilidad.getFecha()));
        lstPar.add(new Parametro(5, contabilidad.getIdcontabilidad()));
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
    public int eliminar(Contabilidad contabilidad) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM contabilidad"
                + " WHERE idcontabilidad=" + contabilidad.getIdcontabilidad();
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
    public Contabilidad obtener(int idcontabilidad) throws Exception {
        Contabilidad contabilidad = null;
        String sql = "SELECT idcontabilidad, debe, haber, saldo, fecha\n"
                + "  FROM contabilidad WHERE idcontabilidad=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idcontabilidad));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                contabilidad = new Contabilidad();
                contabilidad.setIdcontabilidad(rst.getInt(1));
                contabilidad.setDebe(rst.getDouble(2));
                contabilidad.setHaber(rst.getDouble(3));
                contabilidad.setSaldo(rst.getDouble(4));
                contabilidad.setFecha(rst.getDate(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return contabilidad;
    }

    @Override
    public List<Contabilidad> obtener() throws Exception {
        List<Contabilidad> lista = new ArrayList<>();
        String sql = "SELECT idcontabilidad, debe, haber, saldo, fecha\n"
                + "  FROM contabilidad;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Contabilidad contabilidad = new Contabilidad();
                contabilidad = new Contabilidad();
                contabilidad.setIdcontabilidad(rst.getInt(1));
                contabilidad.setDebe(rst.getDouble(2));
                contabilidad.setHaber(rst.getDouble(3));
                contabilidad.setSaldo(rst.getDouble(4));
                contabilidad.setFecha(rst.getDate(5));
                lista.add(contabilidad);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
