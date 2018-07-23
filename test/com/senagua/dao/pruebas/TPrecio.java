package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.IPrecio;
import com.senagua.dao.imp.PrecioImp;
import com.senagua.dao.imp.TipoempleadoImp;
import com.senagua.rnegocio.entidades.Precio;
import com.senagua.rnegocio.entidades.Tipoempleado;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class TPrecio {

    public TPrecio() {
    }

    @Test
    public void pruebaPrecio() {

        int codigo = 10000;
        IPrecio dao = new PrecioImp();

//INSERTAR        
        Precio precio = new Precio(codigo, 1, 0.12, "insertar");
        int insertados = 0;
        try {
            insertados = dao.insertar(precio);
        } catch (Exception e) {
            System.err.println("Error al insertar");
        }
        assertTrue(insertados > 0);

        //MODIFICAR        
        int modificados = 0;
        precio.setPreciobasico(2);
        precio.setDetalle("modificacion");
        try {
            modificados = dao.modificar(precio);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);

        //OBTENER
        Precio obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getPrecioexceso());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);

//LISTAR
        List<Precio> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Precio imp : lista) {
                System.out.println(imp.getPreciobasico());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
//ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(precio);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);

    }
}
