/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.ICliente;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.contrato.ITipomedidor;
import com.senagua.rnegocio.entidades.Medidor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MedidorImp implements IMedidor {

    @Override
    public int insertar(Medidor medidor) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO medidor(idmedidor, numeromedidor, cliente, tipo, marca, modelo, detalle)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, medidor.getIdmedidor()));
        lstPar.add(new Parametro(2, medidor.getNumeromedidor()));
        lstPar.add(new Parametro(3, medidor.getCliente().getIdcliente()));
        lstPar.add(new Parametro(4, medidor.getTipo().getIdtipomedidor()));
        lstPar.add(new Parametro(5, medidor.getMarca()));
        lstPar.add(new Parametro(6, medidor.getModelo()));
        lstPar.add(new Parametro(7, medidor.getDetalle()));
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
    public int modificar(Medidor medidor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE medidor SET numeromedidor=?, cliente=?, tipo=?, marca=?, modelo=?, \n"
                + "       detalle=? WHERE idmedidor=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, medidor.getNumeromedidor()));
        lstPar.add(new Parametro(2, medidor.getCliente().getIdcliente()));
        lstPar.add(new Parametro(3, medidor.getTipo().getIdtipomedidor()));
        lstPar.add(new Parametro(4, medidor.getMarca()));
        lstPar.add(new Parametro(5, medidor.getModelo()));
        lstPar.add(new Parametro(6, medidor.getDetalle()));
        lstPar.add(new Parametro(7, medidor.getIdmedidor()));
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
    public int eliminar(Medidor medidor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM medidor"
                + " WHERE idmedidor=" + medidor.getIdmedidor();
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
    public Medidor obtener(int idmedidor) throws Exception {
        Medidor medidor = null;
        String sql = "SELECT idmedidor, numeromedidor, cliente, tipo, marca, modelo, detalle\n"
                + "  FROM medidor WHERE idmedidor=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idmedidor));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                medidor = new Medidor();
                ICliente cliente = new ClienteImp();
                ITipomedidor tipomedidor = new TipomedidorImp();
                medidor.setIdmedidor(rst.getInt(1));
                medidor.setNumeromedidor(rst.getString(2));
                medidor.setCliente(cliente.obtener(rst.getInt(3)));
                medidor.setTipo(tipomedidor.obtener(rst.getInt(4)));
                medidor.setMarca(rst.getString(5));
                medidor.setModelo(rst.getString(6));
                medidor.setDetalle(rst.getString(7));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return medidor;
    }

    @Override
    public List<Medidor> obtener() throws Exception {
        List<Medidor> lista = new ArrayList<>();
        String sql = "SELECT idmedidor, numeromedidor, cliente, tipo, marca, modelo, detalle\n"
                + "  FROM medidor;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Medidor medidor = new Medidor();
                ICliente cliente = new ClienteImp();
                ITipomedidor tipomedidor = new TipomedidorImp();
                medidor.setIdmedidor(rst.getInt(1));
                medidor.setNumeromedidor(rst.getString(2));
                medidor.setCliente(cliente.obtener(rst.getInt(3)));
                medidor.setTipo(tipomedidor.obtener(rst.getInt(4)));
                medidor.setMarca(rst.getString(5));
                medidor.setModelo(rst.getString(6));
                medidor.setDetalle(rst.getString(7));
                lista.add(medidor);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

    @Override
    public Medidor obtenernumero(String numeromedidor) throws Exception {
        Medidor medidor = null;
        String sql = "SELECT idmedidor, numeromedidor, cliente, tipo, marca, modelo, detalle\n"
                + "  FROM medidor WHERE numeromedidor=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, numeromedidor));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                medidor = new Medidor();
                ICliente cliente = new ClienteImp();
                ITipomedidor tipomedidor = new TipomedidorImp();
                medidor.setIdmedidor(rst.getInt(1));
                medidor.setNumeromedidor(rst.getString(2));
                medidor.setCliente(cliente.obtener(rst.getInt(3)));
                medidor.setTipo(tipomedidor.obtener(rst.getInt(4)));
                medidor.setMarca(rst.getString(5));
                medidor.setModelo(rst.getString(6));
                medidor.setDetalle(rst.getString(7));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return medidor;
    }

}
