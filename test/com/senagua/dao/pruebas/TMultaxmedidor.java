/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.IMedidor;
import com.senagua.dao.contrato.IMulta;
import com.senagua.dao.contrato.IMultaxmedidor;
import com.senagua.dao.imp.MedidorImp;
import com.senagua.dao.imp.MultaImp;
import com.senagua.dao.imp.MultaxmedidorImp;
import com.senagua.rnegocio.entidades.Medidor;
import com.senagua.rnegocio.entidades.Multa;
import com.senagua.rnegocio.entidades.Multaxmedidor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class TMultaxmedidor {
    
    public TMultaxmedidor() {
    }

    @Test
    public void TMultaxmedidor() {
    
        int codigo = 1000;
        IMultaxmedidor dao = new MultaxmedidorImp();
        Multaxmedidor multaxmedidor =new Multaxmedidor();
        IMedidor dao1=new MedidorImp();
        Medidor medidor=new Medidor();
        IMulta dao2=new MultaImp();
        Multa multa = new Multa();
        int insertado = 0;
        try {
            medidor=dao1.obtener(1);
            multa=dao2.obtener(1);
            Multaxmedidor multaxmedidor1= new Multaxmedidor(codigo, medidor, multa, new Date(), "Probando");
            insertado = dao.insertar(multaxmedidor1);
            multaxmedidor=multaxmedidor1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertado > 0);
        //MODIFICAR        
        int modificados = 0;
        multaxmedidor.setDetalle("Probando x2");
        try {
            modificados = dao.modificar(multaxmedidor);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Multaxmedidor obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getFecha());
            System.out.println(obtenida.getDetalle());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Multaxmedidor> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Multaxmedidor imp : lista) {
                System.out.println(imp.getMedidor().getIdmedidor());
                System.out.println(imp.getMulta().getDescripcion());
        } }catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
        //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(multaxmedidor);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
    
    }
}
