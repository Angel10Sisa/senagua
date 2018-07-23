/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.IEmpleado;
import com.senagua.dao.contrato.ITipoempleado;
import com.senagua.dao.imp.EmpleadoImp;
import com.senagua.dao.imp.TipoempleadoImp;
import com.senagua.rnegocio.entidades.Debe;
import com.senagua.rnegocio.entidades.Empleado;
import com.senagua.rnegocio.entidades.Tipoempleado;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author david
 */
public class TEmpleado {
        public TEmpleado() {
    }
    @Test
    public void   TestEmpleado() {
        int codigo = 1000;
        IEmpleado dao = new EmpleadoImp();
        Empleado empleado=new Empleado();
        ITipoempleado dao1=new TipoempleadoImp();
        Tipoempleado tipo=new Tipoempleado();
        //INSERTAR
        int insertado = 0;
        try {
            tipo=dao1.obtener(1);
            Empleado empleado1=new Empleado(codigo, "0605431287", "Brigith", "Palmay", tipo, "BRI", "123", "0968759242", "bp@unach.edu.ec", "Ninguna");
            insertado = dao.insertar(empleado1);
            empleado=empleado1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertado > 0);
        //MODIFICAR        
        int modificados = 0;
        empleado.setNombre("Lisbeth");
        try {
            modificados = dao.modificar(empleado);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        
       //OBTENER
        Empleado obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getIdempleado());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Empleado> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Empleado imp : lista) {
                System.out.println(imp.getNombre());
                System.out.println(imp.getTipo().getNombre());
                
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(empleado);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
        //OBTENER CEDULA
        Empleado obtenida1 = null;
        try {
            obtenida1 = dao.obtener("1804921508");
            System.out.println(obtenida1.getCedula());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR Nombre
        List<Empleado> EmpleadoNombre = new ArrayList<>();
        try {
            EmpleadoNombre = dao.obtenernombre("Angel Isaias");
            for (Empleado imp : EmpleadoNombre) {
                System.out.println(imp.getNombre());
                System.out.println(imp.getTipo().getNombre());
                
            }
        } catch (Exception e) {
        }
        assertTrue(EmpleadoNombre.size() > 0);
        //LISTAR Apellido
        List<Empleado> EmpleadoApe = new ArrayList<>();
        try {
            EmpleadoApe = dao.obtenerapellido("Sisa Sisa");
            for (Empleado imp : EmpleadoApe) {
                System.out.println(imp.getNombre());
                System.out.println(imp.getTipo().getNombre());
                
            }
        } catch (Exception e) {
        }
        assertTrue(EmpleadoNombre.size() > 0);
    }
    
}
