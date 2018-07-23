/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.*;
import com.senagua.rnegocio.entidades.*;
import com.senagua.rnegocio.entidades.Facturaagua;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class FacturaaguaImp implements IFacturaagua {

    @Override
    public int insertar(Facturaagua facturaagua) {
        int afectadas = 0;
        String sql = "INSERT INTO facturaagua(idfactura, medidor, empleado, fecha, direccion, precio, idconsumo, \n"
                + "            consumobasico, consumoexceso, valorconsumobasico, valorconsumoexceso, \n"
                + "            subtotalconsumo, descuento, totalpagar, detalle, estado)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaagua.getIdfactura()));
        lstPar.add(new Parametro(2, facturaagua.getMedidor().getIdmedidor()));
        lstPar.add(new Parametro(3, facturaagua.getEmpleado().getIdempleado()));
        lstPar.add(new Parametro(4, facturaagua.getFecha()));
        lstPar.add(new Parametro(5, facturaagua.getDireccion()));
        lstPar.add(new Parametro(6, facturaagua.getPrecio().getIdprecio()));
        lstPar.add(new Parametro(7, facturaagua.getIdconsumo().getIdconsumo()));
        lstPar.add(new Parametro(8, facturaagua.getConsumobasico()));
        lstPar.add(new Parametro(9, facturaagua.getConsumoexceso()));
        lstPar.add(new Parametro(10, facturaagua.getValorconsumobasico()));
        lstPar.add(new Parametro(11, facturaagua.getValorconsumoexceso()));
        lstPar.add(new Parametro(12, facturaagua.getSubtotalconsumo()));
        lstPar.add(new Parametro(13, facturaagua.getDescuento()));
        lstPar.add(new Parametro(14, facturaagua.getTotalpagar()));
        lstPar.add(new Parametro(15, facturaagua.getDetalle()));
        lstPar.add(new Parametro(16, facturaagua.getEstado()));
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
    public int modificar(Facturaagua facturaagua) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE facturaagua SET medidor=?, empleado=?, fecha=?, direccion=?, precio=?, \n"
                + "       idconsumo=?, consumobasico=?, consumoexceso=?, valorconsumobasico=?, \n"
                + "       valorconsumoexceso=?, subtotalconsumo=?, descuento=?, totalpagar=?, \n"
                + "       detalle=?, estado=?\n"
                + " WHERE idfactura=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaagua.getMedidor().getIdmedidor()));
        lstPar.add(new Parametro(2, facturaagua.getEmpleado().getIdempleado()));
        lstPar.add(new Parametro(3, facturaagua.getFecha()));
        lstPar.add(new Parametro(4, facturaagua.getDireccion()));
        lstPar.add(new Parametro(5, facturaagua.getPrecio().getIdprecio()));
        lstPar.add(new Parametro(6, facturaagua.getIdconsumo().getIdconsumo()));
        lstPar.add(new Parametro(7, facturaagua.getConsumobasico()));
        lstPar.add(new Parametro(8, facturaagua.getConsumoexceso()));
        lstPar.add(new Parametro(9, facturaagua.getValorconsumobasico()));
        lstPar.add(new Parametro(10, facturaagua.getValorconsumoexceso()));
        lstPar.add(new Parametro(11, facturaagua.getSubtotalconsumo()));
        lstPar.add(new Parametro(12, facturaagua.getDescuento()));
        lstPar.add(new Parametro(13, facturaagua.getTotalpagar()));
        lstPar.add(new Parametro(14, facturaagua.getDetalle()));
        lstPar.add(new Parametro(15, facturaagua.getEstado()));
        lstPar.add(new Parametro(16, facturaagua.getIdfactura()));
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
    public int eliminar(Facturaagua facturaagua) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM facturaagua"
                + " WHERE idfactura=" + facturaagua.getIdfactura();
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
    public Facturaagua obtener(int idfactura) throws Exception {
        Facturaagua factura = null;
        String sql = "SELECT idfactura, medidor, empleado, fecha, direccion, precio, idconsumo, \n"
                + "       consumobasico, consumoexceso, valorconsumobasico, valorconsumoexceso, \n"
                + "       subtotalconsumo, descuento, totalpagar, detalle, estado\n"
                + "  FROM facturaagua WHERE idfactura=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idfactura));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                factura = new Facturaagua();
                IMedidor medidor = new MedidorImp();
                IEmpleado empleado = new EmpleadoImp();
                IPrecio precio = new PrecioImp();
                IConsumo consumo = new ConsumoImp();
                factura.setIdfactura(rst.getInt(1));
                factura.setMedidor(medidor.obtener(rst.getInt(2)));
                factura.setEmpleado(empleado.obtener(rst.getInt(3)));
                factura.setFecha(rst.getDate(4));
                factura.setDireccion(rst.getString(5));
                factura.setPrecio(precio.obtener(rst.getInt(6)));
                factura.setIdconsumo(consumo.obtener(rst.getInt(7)));
                factura.setConsumobasico(rst.getInt(8));
                factura.setConsumoexceso(rst.getInt(9));
                factura.setValorconsumobasico(rst.getDouble(10));
                factura.setValorconsumoexceso(rst.getDouble(11));
                factura.setSubtotalconsumo(rst.getDouble(12));
                factura.setDescuento(rst.getDouble(13));
                factura.setTotalpagar(rst.getDouble(14));
                factura.setDetalle(rst.getString(15));
                factura.setEstado(rst.getString(16));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return factura;
    }

    @Override
    public List<Facturaagua> obtener() throws Exception {
        List<Facturaagua> lista = new ArrayList<>();
        String sql = "SELECT idfactura, medidor, empleado, fecha, direccion, precio, idconsumo, \n"
                + "       consumobasico, consumoexceso, valorconsumobasico, valorconsumoexceso, \n"
                + "       subtotalconsumo, descuento, totalpagar, detalle, estado\n"
                + "  FROM facturaagua;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Facturaagua factura = new Facturaagua();
                IMedidor medidor = new MedidorImp();
                IEmpleado empleado = new EmpleadoImp();
                IPrecio precio = new PrecioImp();
                IConsumo consumo = new ConsumoImp();
                factura.setIdfactura(rst.getInt(1));
                factura.setMedidor(medidor.obtener(rst.getInt(2)));
                factura.setEmpleado(empleado.obtener(rst.getInt(3)));
                factura.setFecha(rst.getDate(4));
                factura.setDireccion(rst.getString(5));
                factura.setPrecio(precio.obtener(rst.getInt(6)));
                factura.setIdconsumo(consumo.obtener(rst.getInt(7)));
                factura.setConsumobasico(rst.getInt(8));
                factura.setConsumoexceso(rst.getInt(9));
                factura.setValorconsumobasico(rst.getDouble(10));
                factura.setValorconsumoexceso(rst.getDouble(11));
                factura.setSubtotalconsumo(rst.getDouble(12));
                factura.setDescuento(rst.getDouble(13));
                factura.setTotalpagar(rst.getDouble(14));
                factura.setDetalle(rst.getString(15));
                factura.setEstado(rst.getString(16));
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
