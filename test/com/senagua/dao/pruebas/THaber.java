/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.pruebas;

import com.senagua.dao.contrato.ICuenta;
import com.senagua.dao.contrato.IHaber;
import com.senagua.dao.imp.CuentaImp;
import com.senagua.dao.imp.*;
import com.senagua.rnegocio.entidades.Cuenta;
import com.senagua.rnegocio.entidades.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class THaber {
    
    public THaber() {
    }

     @Test
     public void TestHaber() {
         int codigo = 1000;
        IHaber dao = new HaberImp();
        Haber haber=new Haber();
        ICuenta dao1=new CuentaImp();
        Cuenta cuenta=new Cuenta();
        //INSERTAR
        int insertado = 0;
        try {
            cuenta=dao1.obtener(1);
            Haber haber1=new Haber(codigo, cuenta, codigo, codigo, "Nose", new Date());
            insertado = dao.insertar(haber1);
            haber=haber1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(insertado > 0);
        //MODIFICAR        
        int modificados = 0;
        haber.setDetalle("Lo que salga");
        try {
            modificados = dao.modificar(haber);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);
        //OBTENER
        Haber obtenida = null;
        try {
            obtenida = dao.obtener(codigo);
            System.out.println(obtenida.getFecha());
        } catch (Exception e) {
        }
        assertTrue(obtenida != null);
        //LISTAR
        List<Haber> lista = new ArrayList<>();
        try {
            lista = dao.obtener();
            for (Haber imp : lista) {
                System.out.println(imp.getCuenta().getNombre());
            }
        } catch (Exception e) {
        }
        assertTrue(lista.size() > 0);
         //ELIMINAR
        int eliminados = 0;
        try {
            eliminados = dao.eliminar(haber);
        } catch (Exception e) {
        }
        assertTrue(eliminados > 0);
     }
}
