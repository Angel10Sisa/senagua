/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.IPrecio;
import com.senagua.dao.contrato.ITipocliente;
import com.senagua.dao.imp.PrecioImp;
import com.senagua.dao.imp.TipoclienteImp;
import com.senagua.rnegocio.entidades.Precio;
import com.senagua.rnegocio.entidades.Tipocliente;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class TTipocliente {
    
    public TTipocliente() {
    }
    
 @Test
   public void pruebaTipoCliente() {
     
        int codigo = 10000;
        ITipocliente dao = new TipoclienteImp();

//INSERTAR        
        Tipocliente tipocli = new Tipocliente(codigo, "Prueba", "010%", 0.20, "Insersion");
        int insertados = 0;
        try {
            insertados = dao.insertar(tipocli);
        } catch (Exception e) {
            System.err.println("Error al insertar");
        }
        assertTrue(insertados > 0);
        
        //MODIFICAR        
        int modificados = 0;
        tipocli.setNombre("Prueba2");
        tipocli.setDescuento("005%");
        tipocli.setValor(0.40);
        tipocli.setDetalle("modificacion");
        try {
            modificados = dao.modificar(tipocli);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Tipocliente obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //OBTENER NOMBRE
        obtenida = null;
        try {
            obtenida = dao.obtenernombre("normal");
            System.out.println(obtenida.getNombre());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);

//LISTAR
        List<Tipocliente> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
        } catch (Exception e) {
            assertTrue(lista.size() > 0);
        }
        
 //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(tipocli);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
        
   
   }
}
