/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.ICliente;
import com.senagua.dao.contrato.ITipocliente;
import com.senagua.dao.imp.ClienteImp;
import com.senagua.dao.imp.TipoclienteImp;
import com.senagua.rnegocio.entidades.Cliente;
import com.senagua.rnegocio.entidades.Tipocliente;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TCliente {
    
    public TCliente() {
    }

     @Test
     public void hello() {
         int codigo = 1000;
        ICliente dao = new ClienteImp();
        Cliente cliente=new Cliente();
         ITipocliente dao1=new TipoclienteImp();
        Tipocliente tipo=new Tipocliente();
        //INSERTAR
        int insertado = 0;
        try {
            tipo=dao1.obtener(1);
            Cliente cliente1=new Cliente(codigo, "1234567891", "Beto", "Cardenas", tipo, "0968759242", "Ambato", "bc@quti.com", "Ninguna");
            insertado = dao.insertar(cliente1);
            cliente=cliente1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertado > 0);
        //MODIFICAR        
        int modificados = 0;
        cliente.setNombre("Alan");
        cliente.setApellido("Brito");
        try {
            modificados = dao.modificar(cliente);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Cliente obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getTipocliente().getNombre());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
         //LISTAR
        List<Cliente> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Cliente imp : lista) {
                System.out.println(imp.getNombre()+" "+imp.getApellido());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(cliente);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
     }
}
