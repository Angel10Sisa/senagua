package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.ITipocliente;
import com.senagua.rnegocio.entidades.Tipocliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TipoclienteImp implements ITipocliente {

    @Override
    public int insertar(Tipocliente tipocliente) {
        int afectadas = 0;
        String sql = "INSERT INTO tipocliente(idtipocliente, nombre, descuento, valor, detalle) VALUES (?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, tipocliente.getIdtipocliente()));
        lstPar.add(new Parametro(2, tipocliente.getNombre()));
        lstPar.add(new Parametro(3, tipocliente.getDescuento()));
        lstPar.add(new Parametro(4, tipocliente.getValor()));
        lstPar.add(new Parametro(5, tipocliente.getDetalle()));
        Conexion con = new Conexion();
        try {
            afectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        }
        return afectadas;
    }

    @Override
    public int modificar(Tipocliente tipocliente) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE tipocliente SET nombre=?, descuento=?, valor=?, detalle=? WHERE idtipocliente=?";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, tipocliente.getNombre()));
        lstPar.add(new Parametro(2, tipocliente.getDescuento()));
        lstPar.add(new Parametro(3, tipocliente.getValor()));
        lstPar.add(new Parametro(4, tipocliente.getDetalle()));
        lstPar.add(new Parametro(5, tipocliente.getIdtipocliente()));
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
    public int eliminar(Tipocliente tipocliente) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM tipocliente"
                + " WHERE idtipocliente=" + tipocliente.getIdtipocliente();
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
    public Tipocliente obtener(int idtipocliente) throws Exception {
        Tipocliente tipocliente = null;
        String sql = "SELECT idtipocliente, nombre, descuento, valor, detalle\n"
                + "  FROM public.tipocliente WHERE idtipocliente=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idtipocliente));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                tipocliente = new Tipocliente();
                tipocliente.setIdtipocliente(rst.getInt(1));
                tipocliente.setNombre(rst.getString(2));
                tipocliente.setDescuento(rst.getString(3));
                tipocliente.setValor(rst.getDouble(4));
                tipocliente.setDetalle(rst.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return tipocliente;
    }

    @Override
    public List<Tipocliente> obtener() throws Exception {
        List<Tipocliente> lista = new ArrayList<>();
        String sql = "SELECT idtipocliente, nombre, descuento, valor, detalle\n"
                + "  FROM public.tipocliente;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Tipocliente tipocliente = new Tipocliente();
                tipocliente.setIdtipocliente(rst.getInt(1));
                tipocliente.setNombre(rst.getString(2));
                tipocliente.setDescuento(rst.getString(3));
                tipocliente.setValor(rst.getDouble(4));
                tipocliente.setDetalle(rst.getString(5));
                lista.add(tipocliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
