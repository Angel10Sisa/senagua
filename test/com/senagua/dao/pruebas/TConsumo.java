/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.IConsumo;
import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.imp.ConsumoImp;
import com.senagua.dao.imp.MedidorImp;
import com.senagua.rnegocio.entidades.Consumo;
import com.senagua.rnegocio.entidades.Debe;
import com.senagua.rnegocio.entidades.Medidor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TConsumo {
    
    public TConsumo() {
    }

     @Test
     public void TestConsumo() {
         int codigo = 1000;
        IConsumo dao = new ConsumoImp();
        Consumo consumo=new Consumo();
        IMedidor dao1=new MedidorImp();
        Medidor medidor=new Medidor();
        //INSERTAR
        int insertado = 0;
        try {
            medidor=dao1.obtener(1);
            Consumo consumo1=new Consumo(codigo, medidor, codigo, new Date(), insertado, new Date(), insertado, new Date(), codigo, new Date(), codigo);
            insertado = dao.insertar(consumo1);
            consumo=consumo1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertado > 0);
        //MODIFICAR        
        int modificados = 0;
        consumo.setConsumo(200);
        try {
            modificados = dao.modificar(consumo);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Consumo obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getMedidor().getCliente().getApellido());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Consumo> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Consumo imp : lista) {
                System.out.println(imp.getMedidor().getCliente().getApellido());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(consumo);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
     }
}
