/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Multaxmedidor;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public interface IMultaxmedidor {
    int insertar(Multaxmedidor multaxmedidor) throws Exception;

    int modificar(Multaxmedidor multaxmedidor) throws Exception;

    int eliminar(Multaxmedidor multaxmedidor) throws Exception;
    
    int eliminar() throws Exception;

    Multaxmedidor obtener(int idmultamedidor) throws Exception;

    List<Multaxmedidor> obtener() throws Exception;
}
