/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.IEmpleado;
import com.senagua.dao.contrato.ITipoempleado;
import com.senagua.rnegocio.entidades.Empleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EmpleadoImp implements IEmpleado {

    @Override
    public int insertar(Empleado empleado) throws Exception {
        int afectadas = 0;
        String sql = "INSERT INTO empleado(idempleado, cedula, nombre, apellido, tipo, usuario, clave, celular, \n"
                + "            mail, observacion)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getIdempleado()));
        lstPar.add(new Parametro(2, empleado.getCedula()));
        lstPar.add(new Parametro(3, empleado.getNombre()));
        lstPar.add(new Parametro(4, empleado.getApellido()));
        lstPar.add(new Parametro(5, empleado.getTipo().getIdtipoempleado()));
        lstPar.add(new Parametro(6, empleado.getUsuario()));
        lstPar.add(new Parametro(7, empleado.getClave()));
        lstPar.add(new Parametro(8, empleado.getCelular()));
        lstPar.add(new Parametro(9, empleado.getMail()));
        lstPar.add(new Parametro(10, empleado.getObservacion()));
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
    public int modificar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        
        String sql ="UPDATE empleado SET cedula=?, nombre=?, apellido=?, tipo=?, usuario=?, clave=?, celular=?, mail=?, observacion=?\n"
                + " WHERE idempleado=? ;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getCedula()));
        lstPar.add(new Parametro(2, empleado.getNombre()));
        lstPar.add(new Parametro(3, empleado.getApellido()));
        lstPar.add(new Parametro(4, empleado.getTipo().getIdtipoempleado()));
        lstPar.add(new Parametro(5, empleado.getUsuario()));
        lstPar.add(new Parametro(6, empleado.getClave()));
        lstPar.add(new Parametro(7, empleado.getCelular()));
        lstPar.add(new Parametro(8, empleado.getMail()));
        lstPar.add(new Parametro(9, empleado.getObservacion()));
        lstPar.add(new Parametro(10, empleado.getIdempleado()));
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
    public int eliminar(Empleado empleado) throws Exception {
     int numFilasAfectadas = 0;
        String sql = "DELETE FROM empleado"
                + " WHERE idempleado=" + empleado.getIdempleado();
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
    public Empleado obtener(int idempleado) throws Exception {
        Empleado empleado = null;
        String sql = "SELECT idempleado, cedula, nombre, apellido, tipo, usuario, clave, celular, mail, observacion FROM empleado where idempleado=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idempleado));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                empleado = new Empleado();
                ITipoempleado tipoempleado = new TipoempleadoImp();
                empleado.setIdempleado(rst.getInt(1));
                empleado.setCedula(rst.getString(2));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setTipo(tipoempleado.obtener(rst.getInt(5)));
                empleado.setUsuario(rst.getString(6));
                empleado.setClave(rst.getString(7));
                empleado.setCelular(rst.getString(8));
                empleado.setMail(rst.getString(9));
                empleado.setObservacion(rst.getString(10));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtener() throws Exception {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT idempleado, cedula, nombre, apellido, tipo, usuario, clave, celular, mail, observacion FROM empleado";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Empleado empleado = new Empleado();
                ITipoempleado tipoempleado = new TipoempleadoImp();
                empleado.setIdempleado(rst.getInt(1));
                empleado.setCedula(rst.getString(2));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setTipo(tipoempleado.obtener(rst.getInt(5)));
                empleado.setUsuario(rst.getString(6));
                empleado.setClave(rst.getString(7));
                empleado.setCelular(rst.getString(8));
                empleado.setMail(rst.getString(9));
                empleado.setObservacion(rst.getString(10));
                lista.add(empleado);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista; 
    }

    @Override
    public Empleado obtener(String cedula) throws Exception {
        Empleado empleado = null;
        String sql = "SELECT idempleado, cedula, nombre, apellido, tipo, usuario, clave, celular, mail, observacion FROM empleado where cedula=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cedula));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                empleado = new Empleado();
                ITipoempleado tipoempleado = new TipoempleadoImp();
                empleado.setIdempleado(rst.getInt(1));
                empleado.setCedula(rst.getString(2));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setTipo(tipoempleado.obtener(rst.getInt(5)));
                empleado.setUsuario(rst.getString(6));
                empleado.setClave(rst.getString(7));
                empleado.setCelular(rst.getString(8));
                empleado.setMail(rst.getString(9));
                empleado.setObservacion(rst.getString(10));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtenernombre(String nombre) throws Exception {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT idempleado, cedula, nombre, apellido, tipo, usuario, clave, celular, mail, observacion FROM empleado WHERE nombre=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, nombre));
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                Empleado empleado = new Empleado();
                ITipoempleado tipoempleado = new TipoempleadoImp();
                empleado.setIdempleado(rst.getInt(1));
                empleado.setCedula(rst.getString(2));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setTipo(tipoempleado.obtener(rst.getInt(5)));
                empleado.setUsuario(rst.getString(6));
                empleado.setClave(rst.getString(7));
                empleado.setCelular(rst.getString(8));
                empleado.setMail(rst.getString(9));
                empleado.setObservacion(rst.getString(10));
                lista.add(empleado);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista; 
    }

    @Override
    public List<Empleado> obtenerapellido(String apellido) throws Exception {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT idempleado, cedula, nombre, apellido, tipo, usuario, clave, celular, mail, observacion FROM empleado WHERE apellido=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, apellido));
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                Empleado empleado = new Empleado();
                ITipoempleado tipoempleado = new TipoempleadoImp();
                empleado.setIdempleado(rst.getInt(1));
                empleado.setCedula(rst.getString(2));
                empleado.setNombre(rst.getString(3));
                empleado.setApellido(rst.getString(4));
                empleado.setTipo(tipoempleado.obtener(rst.getInt(5)));
                empleado.setUsuario(rst.getString(6));
                empleado.setClave(rst.getString(7));
                empleado.setCelular(rst.getString(8));
                empleado.setMail(rst.getString(9));
                empleado.setObservacion(rst.getString(10));
                lista.add(empleado);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista; 
    }


}
