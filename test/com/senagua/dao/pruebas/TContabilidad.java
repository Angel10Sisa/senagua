/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.IContabilidad;
import com.senagua.dao.imp.ContabilidadImp;
import com.senagua.rnegocio.entidades.Contabilidad;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TContabilidad {

    public TContabilidad() {
    }

    @Test
    public void TestContabilidad() {
        int codigo = 1000;
        IContabilidad dao = new ContabilidadImp();
        //INSERTAR
        Contabilidad contabilidad = new Contabilidad(codigo, codigo, codigo, codigo, new Date());
        int insertado = 0;
        try {
            insertado = dao.insertar(contabilidad);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertado > 0);
        //MODIFICAR        
        int modificados = 0;
        contabilidad.setDebe(2000);
        try {
            modificados = dao.modificar(contabilidad);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Contabilidad obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getDebe());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Contabilidad> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Contabilidad imp : lista) {
                System.out.println(imp.getSaldo());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(contabilidad);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
    }
}
