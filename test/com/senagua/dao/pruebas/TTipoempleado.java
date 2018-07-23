/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.ITipoempleado;
import com.senagua.dao.imp.TipoempleadoImp;
import com.senagua.rnegocio.entidades.Empleado;
import com.senagua.rnegocio.entidades.Tipoempleado;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class TTipoempleado {
    public TTipoempleado(){
    }

    @Test
    public void pruebaTipoEmpleado() {
        int codigo = 1000;
       ITipoempleado imp = new TipoempleadoImp();
        // Ingreso
        Tipoempleado tipoemple = new Tipoempleado(codigo, "prueba", "solo estamos probando");
        int insertado = 0;
        try {
            insertado = imp.insertar(tipoemple);
        } catch (Exception e) {
            System.out.println("Error al ingresar");
        }
        assertTrue(insertado > 0);
        
        //MODIFICAR
        int modificados = 0;
        tipoemple.setNombre("Prueba2");
        tipoemple.setObservacion("veamos que pasa");
        try {
            modificados = imp.modificar(tipoemple);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        
        //OBTENER
        Tipoempleado obtenida = null;
        try {
            obtenida = imp.obtener(codigo);
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //OBTENER POR NOMBRE
        Tipoempleado obtenida1 = null;
        try {
            obtenida1 = imp.obtener("GERENTE");
            System.out.println(obtenida1.getIdtipoempleado());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
//LISTAR
        List<Tipoempleado> lista = new ArrayList<>();
        try {
            lista = imp.obtener();
        } catch (Exception e) {
            assertTrue(lista.size() > 0);
        }
                
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = imp.eliminar(tipoemple);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);

        
    }
}
