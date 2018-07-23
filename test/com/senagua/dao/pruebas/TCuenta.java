/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.ICuenta;
import com.senagua.dao.imp.CuentaImp;
import com.senagua.rnegocio.entidades.Cuenta;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eddyf
 */
public class TCuenta {
    
    public TCuenta() {
    }
    
     @Test
     public void testCuenta() {
     int codigo=1000;
     ICuenta dao=new CuentaImp();
     //INSERTAR
     Cuenta cuanta=new Cuenta(codigo, "Nose", "Nose");
     int insertado=0;
         try {
             insertado=dao.insertar(cuanta);
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         assertTrue(insertado>0);
         //MODIFICAR        
        int modificados = 0;
        cuanta.setNombre("Prueba2");
        cuanta.setDetalle("modificar");
        try {
            modificados = dao.modificar(cuanta);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Cuenta obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getNombre());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Cuenta> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Cuenta imp : lista) {
                System.out.println(imp.getNombre());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(cuanta);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
     }
}
