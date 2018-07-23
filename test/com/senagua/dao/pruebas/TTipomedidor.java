/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.ITipomedidor;
import com.senagua.dao.imp.TipomedidorImp;
import com.senagua.rnegocio.entidades.Tipomedidor;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TTipomedidor {

    public TTipomedidor() {
    }

    @Test
    public void TestTipoMedidor() {
        int codigo = 1000;
        ITipomedidor dao = new TipomedidorImp();
        //INSERTAR
        Tipomedidor tipomedidor = new Tipomedidor(codigo, "Industrial", codigo, "Ninguna");
        int insertado = 0;
        try {
            insertado = dao.insertar(tipomedidor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertado > 0);
        //MODIFICAR        
        int modificados = 0;
        tipomedidor.setObservacion("medidor no permitido");
        try {
            modificados = dao.modificar(tipomedidor);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Tipomedidor obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getCaracteristica());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Tipomedidor> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Tipomedidor imp : lista) {
                System.out.println(imp.getCaracteristica());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(tipomedidor);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
    }
}
