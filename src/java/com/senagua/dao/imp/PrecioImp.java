package com.senagua.dao.imp;

import com.senagua.accesoadatos.Conexion;
import com.senagua.accesoadatos.Parametro;
import com.senagua.dao.contrato.IPrecio;
import com.senagua.rnegocio.entidades.Precio;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PrecioImp implements IPrecio {

    @Override
    public int insertar(Precio precio) {
        int afectadas = 0;
        String sql = "INSERT INTO precio(idprecio, preciobasico, precioexceso, detalle)\n"
                + "    VALUES (?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, precio.getIdprecio()));
        lstPar.add(new Parametro(2, precio.getPreciobasico()));
        lstPar.add(new Parametro(3, precio.getPrecioexceso()));
        lstPar.add(new Parametro(4, precio.getDetalle()));
        Conexion con = new Conexion();
        try {
            afectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        }
        return afectadas;
    }

    @Override
    public int modificar(Precio precio) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE precio SET preciobasico=?, precioexceso=?, detalle=?\n"
                + " WHERE idprecio=?;";

        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, precio.getPreciobasico()));
        lstPar.add(new Parametro(2, precio.getPrecioexceso()));
        lstPar.add(new Parametro(3, precio.getDetalle()));
        lstPar.add(new Parametro(4, precio.getIdprecio()));
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
    public int eliminar(Precio precio) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM precio"
                + " WHERE idprecio=" + precio.getIdprecio();
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
    public Precio obtener(int idprecio) throws Exception {
        Precio precio = null;
        String sql = "SELECT idprecio, preciobasico, precioexceso, detalle\n"
                + "  FROM precio WHERE idprecio=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idprecio));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                precio = new Precio();
                precio.setIdprecio(rst.getInt(1));
                precio.setPreciobasico(rst.getDouble(2));
                precio.setPrecioexceso(rst.getDouble(3));
                precio.setDetalle(rst.getString(4));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return precio;
    }

    @Override
    public List<Precio> obtener() throws Exception {
        List<Precio> lista = new ArrayList<>();
        String sql = "SELECT idprecio, preciobasico, precioexceso, detalle\n"
                + "  FROM precio;";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Precio precio = new Precio();
                precio = new Precio();
                precio.setIdprecio(rst.getInt(1));
                precio.setPreciobasico(rst.getDouble(2));
                precio.setPrecioexceso(rst.getDouble(3));
                precio.setDetalle(rst.getString(4));
                lista.add(precio);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
