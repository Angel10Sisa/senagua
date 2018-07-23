/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.IConsumo;
import com.senagua.dao.contrato.IEmpleado;
import com.senagua.dao.contrato.IFacturaagua;
import com.senagua.dao.contrato.IFacturamulta;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.contrato.IMultaxmedidor;
import com.senagua.dao.contrato.IPrecio;
import com.senagua.dao.imp.ConsumoImp;
import com.senagua.dao.imp.EmpleadoImp;
import com.senagua.dao.imp.FacturaaguaImp;
import com.senagua.dao.imp.FacturamultaImp;
import com.senagua.dao.imp.MedidorImp;
import com.senagua.dao.imp.MultaxmedidorImp;
import com.senagua.dao.imp.PrecioImp;
import com.senagua.rnegocio.entidades.Consumo;
import com.senagua.rnegocio.entidades.Empleado;
import com.senagua.rnegocio.entidades.Facturaagua;
import com.senagua.rnegocio.entidades.Facturamulta;
import com.senagua.rnegocio.entidades.Medidor;
import com.senagua.rnegocio.entidades.Multaxmedidor;
import com.senagua.rnegocio.entidades.Precio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TFacturamulta {
    
    public TFacturamulta() {
    }

     @Test
     public void TestMulta() {
         int codigo = 10000;
         Facturamulta factura = new Facturamulta();
         IFacturamulta dao = new FacturamultaImp();
        IMedidor dao1 = new MedidorImp();
        Medidor medidor = new Medidor();
        IEmpleado dao2 = new EmpleadoImp();
        Empleado empleado = new Empleado();
        IMultaxmedidor dao3 = new MultaxmedidorImp();
        Multaxmedidor multa = new Multaxmedidor();
        //INSERTAR
        int insertado = 0;
        try {
            medidor = dao1.obtener(1);
            empleado = dao2.obtener(1);
            multa = dao3.obtener(1);
            Facturamulta factura1 = new Facturamulta(codigo, medidor, empleado, new Date(), "direccion", multa, insertado, insertado, codigo, "detalle","Cencelado");
            insertado = dao.insertar(factura1);
            factura=factura1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertado > 0);
        //MODIFICAR        
        int modificados = 0;
        factura.setDetalle("Lo que salga");
        try {
            modificados = dao.modificar(factura);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Facturamulta obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getFecha());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Facturamulta> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Facturamulta imp : lista) {
                System.out.println(imp.getDetalle());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(factura);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
     }
}
