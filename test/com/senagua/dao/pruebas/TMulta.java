/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.IMulta;
import com.senagua.dao.imp.MultaImp;
import com.senagua.rnegocio.entidades.Multa;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TMulta {
    
    public TMulta() {
    }
    
     @Test
     public void TestMulta() {
         int codigo=1000;
     IMulta dao=new MultaImp();
     //INSERTAR
     Multa multa=new Multa(codigo, "Nose", codigo, new Date(), "Nose");
     int insertado=0;
         try {
             insertado=dao.insertar(multa);
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
         assertTrue(insertado>0);
         //MODIFICAR        
        int modificados = 0;
        multa.setNombre("Prueba2");
        multa.setValor(45.0);
        DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            multa.setFecha(formato.parse("20-08-2013"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        multa.setDescripcion("Descripción");
        try {
            modificados = dao.modificar(multa);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Multa obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getFecha());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Multa> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Multa imp : lista) {
                System.out.println(imp.getNombre());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(multa);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
     }
}
