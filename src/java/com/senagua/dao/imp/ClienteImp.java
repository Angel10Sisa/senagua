/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.ICliente;
import com.senagua.dao.contrato.ITipocliente;
import com.senagua.rnegocio.entidades.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClienteImp implements ICliente {

    @Override
    public int insertar(Cliente cliente) {
        int afectadas = 0;
        String sql = "INSERT INTO cliente(idcliente, cedula, nombre, apellido, tipo, celular, direccion, \n"
                + "            email, observacion)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getIdcliente()));
        lstPar.add(new Parametro(2, cliente.getCedula()));
        lstPar.add(new Parametro(3, cliente.getNombre()));
        lstPar.add(new Parametro(4, cliente.getApellido()));
        lstPar.add(new Parametro(5, cliente.getTipocliente().getIdtipocliente()));
        lstPar.add(new Parametro(6, cliente.getCelular()));
        lstPar.add(new Parametro(7, cliente.getDireccion()));
        lstPar.add(new Parametro(8, cliente.getEmail()));
        lstPar.add(new Parametro(9, cliente.getObservacion()));
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
    public int modificar(Cliente cliente) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente SET cedula=?, nombre=?, apellido=?, tipo=?, celular=?, \n"
                + "       direccion=?, email=?, observacion=?\n"
                + " WHERE idcliente=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));
        lstPar.add(new Parametro(4, cliente.getTipocliente().getIdtipocliente()));
        lstPar.add(new Parametro(5, cliente.getCelular()));
        lstPar.add(new Parametro(6, cliente.getDireccion()));
        lstPar.add(new Parametro(7, cliente.getEmail()));
        lstPar.add(new Parametro(8, cliente.getObservacion()));
        lstPar.add(new Parametro(9, cliente.getIdcliente()));
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
    public int eliminar(Cliente cliente) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM cliente"
                + " WHERE idcliente=" + cliente.getIdcliente();
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
    public Cliente obtener(int idcliente) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT idcliente, cedula, nombre, apellido, tipo, celular, direccion, \n"
                + "       email, observacion FROM cliente WHERE idcliente=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idcliente));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                ITipocliente tipo = new TipoclienteImp();
                cliente.setIdcliente(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setTipocliente(tipo.obtener(rst.getInt(5)));
                cliente.setCelular(rst.getString(6));
                cliente.setDireccion(rst.getString(7));
                cliente.setEmail(rst.getString(8));
                cliente.setObservacion(rst.getString(9));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT idcliente, cedula, nombre, apellido, tipo, celular, direccion, \n"
                + "       email, observacion FROM cliente;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Cliente cliente = new Cliente();
                ITipocliente tipo = new TipoclienteImp();
                cliente.setIdcliente(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setTipocliente(tipo.obtener(rst.getInt(5)));
                cliente.setCelular(rst.getString(6));
                cliente.setDireccion(rst.getString(7));
                cliente.setEmail(rst.getString(8));
                cliente.setObservacion(rst.getString(9));
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

    @Override
    public Cliente obtenercedula(String cedula) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT idcliente, cedula, nombre, apellido, tipo, celular, direccion, \n"
                + "       email, observacion FROM cliente WHERE cedula=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cedula));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                ITipocliente tipo = new TipoclienteImp();
                cliente.setIdcliente(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setTipocliente(tipo.obtener(rst.getInt(5)));
                cliente.setCelular(rst.getString(6));
                cliente.setDireccion(rst.getString(7));
                cliente.setEmail(rst.getString(8));
                cliente.setObservacion(rst.getString(9));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtenernombre(String nombre) throws Exception {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT idcliente, cedula, nombre, apellido, tipo, celular, direccion, \n"
                + "       email, observacion FROM cliente WHERE nombre=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, nombre));
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                Cliente cliente = new Cliente();
                ITipocliente tipo = new TipoclienteImp();
                cliente.setIdcliente(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setTipocliente(tipo.obtener(rst.getInt(5)));
                cliente.setCelular(rst.getString(6));
                cliente.setDireccion(rst.getString(7));
                cliente.setEmail(rst.getString(8));
                cliente.setObservacion(rst.getString(9));
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista; 
    }

    @Override
    public List<Cliente> obtenerapellido(String apellido) throws Exception {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT idcliente, cedula, nombre, apellido, tipo, celular, direccion, \n"
                + "       email, observacion FROM cliente WHERE apellido=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, apellido));
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                Cliente cliente = new Cliente();
                ITipocliente tipo = new TipoclienteImp();
                cliente.setIdcliente(rst.getInt(1));
                cliente.setCedula(rst.getString(2));
                cliente.setNombre(rst.getString(3));
                cliente.setApellido(rst.getString(4));
                cliente.setTipocliente(tipo.obtener(rst.getInt(5)));
                cliente.setCelular(rst.getString(6));
                cliente.setDireccion(rst.getString(7));
                cliente.setEmail(rst.getString(8));
                cliente.setObservacion(rst.getString(9));
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista; 
    }

}
