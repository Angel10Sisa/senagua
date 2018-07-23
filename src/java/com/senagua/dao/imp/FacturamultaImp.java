/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.IEmpleado;
import com.senagua.dao.contrato.IFacturamulta;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.contrato.IMultaxmedidor;
import com.senagua.dao.contrato.IPrecio;
import com.senagua.rnegocio.entidades.Facturamulta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class FacturamultaImp implements IFacturamulta {

    @Override
    public int insertar(Facturamulta facturamulta) {
        int afectadas = 0;
        String sql = "INSERT INTO facturamulta(idfactura, medidor, empleado, fecha, direccion, idmultamedidor, \n"
                + "            subtotalmulta, descuento, totalpagar, detalle, estado)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturamulta.getIdfactura()));
        lstPar.add(new Parametro(2, facturamulta.getMedidor().getIdmedidor()));
        lstPar.add(new Parametro(3, facturamulta.getEmpleado().getIdempleado()));
        lstPar.add(new Parametro(4, facturamulta.getFecha()));
        lstPar.add(new Parametro(5, facturamulta.getDireccion()));
        lstPar.add(new Parametro(6, facturamulta.getMultamedidor().getIdmultamedidor()));
        lstPar.add(new Parametro(7, facturamulta.getSubtotalmulta()));
        lstPar.add(new Parametro(8, facturamulta.getDescuento()));
        lstPar.add(new Parametro(9, facturamulta.getTotalpagar()));
        lstPar.add(new Parametro(10, facturamulta.getDetalle()));
        lstPar.add(new Parametro(11, facturamulta.getEstado()));
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
    public int modificar(Facturamulta facturamulta) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE facturamulta SET medidor=?, empleado=?, fecha=?, direccion=?, idmultamedidor=?, \n"
                + "       subtotalmulta=?, descuento=?, totalpagar=?, detalle=?, estado=? WHERE idfactura=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturamulta.getMedidor().getIdmedidor()));
        lstPar.add(new Parametro(2, facturamulta.getEmpleado().getIdempleado()));
        lstPar.add(new Parametro(3, facturamulta.getFecha()));
        lstPar.add(new Parametro(4, facturamulta.getDireccion()));
        lstPar.add(new Parametro(5, facturamulta.getMultamedidor().getIdmultamedidor()));
        lstPar.add(new Parametro(6, facturamulta.getSubtotalmulta()));
        lstPar.add(new Parametro(7, facturamulta.getDescuento()));
        lstPar.add(new Parametro(8, facturamulta.getTotalpagar()));
        lstPar.add(new Parametro(9, facturamulta.getDetalle()));
        lstPar.add(new Parametro(10, facturamulta.getEstado()));
        lstPar.add(new Parametro(11, facturamulta.getIdfactura()));
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
    public int eliminar(Facturamulta facturamulta) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM facturamulta"
                + " WHERE idfactura=" + facturamulta.getIdfactura();
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
    public Facturamulta obtener(int idfactura) throws Exception {
        Facturamulta factura = null;
        String sql = "SELECT idfactura, medidor, empleado, fecha, direccion, idmultamedidor, \n"
                + "       subtotalmulta, descuento, totalpagar, detalle, estado\n"
                + "  FROM facturamulta WHERE idfactura=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idfactura));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                factura = new Facturamulta();
                IMedidor medidor = new MedidorImp();
                IEmpleado empleado = new EmpleadoImp();
                IMultaxmedidor multa = new MultaxmedidorImp();
                factura.setIdfactura(rst.getInt(1));
                factura.setMedidor(medidor.obtener(rst.getInt(2)));
                factura.setEmpleado(empleado.obtener(rst.getInt(3)));
                factura.setFecha(rst.getDate(4));
                factura.setDireccion(rst.getString(5));
                factura.setMultamedidor(multa.obtener(rst.getInt(6)));
                factura.setSubtotalmulta(rst.getDouble(7));
                factura.setDescuento(rst.getDouble(8));
                factura.setTotalpagar(rst.getDouble(9));
                factura.setDetalle(rst.getString(10));
                factura.setEstado(rst.getString(11));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return factura;
    }

    @Override
    public List<Facturamulta> obtener() throws Exception {
        List<Facturamulta> lista = new ArrayList<>();
        String sql = "SELECT idfactura, medidor, empleado, fecha, direccion, idmultamedidor, \n"
                + "       subtotalmulta, descuento, totalpagar, detalle, estado\n"
                + "  FROM facturamulta;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Facturamulta factura = new Facturamulta();
                IMedidor medidor = new MedidorImp();
                IEmpleado empleado = new EmpleadoImp();
                IMultaxmedidor multa = new MultaxmedidorImp();
                factura.setIdfactura(rst.getInt(1));
                factura.setMedidor(medidor.obtener(rst.getInt(2)));
                factura.setEmpleado(empleado.obtener(rst.getInt(3)));
                factura.setFecha(rst.getDate(4));
                factura.setDireccion(rst.getString(5));
                factura.setMultamedidor(multa.obtener(rst.getInt(6)));
                factura.setSubtotalmulta(rst.getDouble(7));
                factura.setDescuento(rst.getDouble(8));
                factura.setTotalpagar(rst.getDouble(9));
                factura.setDetalle(rst.getString(10));
                factura.setEstado(rst.getString(11));
                lista.add(factura);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
