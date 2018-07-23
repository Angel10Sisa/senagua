/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.*;
import com.senagua.dao.imp.*;
import com.senagua.dao.imp.MedidorImp;
import com.senagua.rnegocio.entidades.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TMedidor {
    
    public TMedidor() {
    }

     @Test
     public void TestMedidor() {
         int codigo = 1000;
        IMedidor dao = new MedidorImp();
        Medidor medidor=new Medidor();
        ICliente dao1=new ClienteImp();
        Cliente cliente=new Cliente();
        ITipomedidor dao2=new TipomedidorImp();
        Tipomedidor tipomedidor=new Tipomedidor();
        //INSERTAR
        int insertado = 0;
        try {
            cliente=dao1.obtener(1);
            tipomedidor=dao2.obtener(1);
            Medidor medidor1=new Medidor(codigo, "e1232", cliente, tipomedidor, "SENAGUA", "2010", "Ninguno");
            insertado = dao.insertar(medidor1);
            medidor=medidor1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertado > 0);
        //MODIFICAR        
        int modificados = 0;
        medidor.setDetalle("Lo que salga");
        try {
            modificados = dao.modificar(medidor);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Medidor obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getCliente().getApellido());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Medidor> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Medidor imp : lista) {
                System.out.println(imp.getModelo());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(medidor);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
     }
}
