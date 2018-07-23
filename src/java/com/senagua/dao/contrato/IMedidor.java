/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Medidor;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IMedidor {
    
    int insertar(Medidor medidor) throws Exception;

    int modificar(Medidor medidor) throws Exception;

    int eliminar(Medidor medidor) throws Exception;

    Medidor obtener(int idmedidor) throws Exception;

    List<Medidor> obtener() throws Exception;
    
}
