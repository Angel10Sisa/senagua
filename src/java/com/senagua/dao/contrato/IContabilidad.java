/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Contabilidad;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IContabilidad {

    int insertar(Contabilidad contabilidad) throws Exception;

    int modificar(Contabilidad contabilidad) throws Exception;

    int eliminar(Contabilidad contabilidad) throws Exception;

    Contabilidad obtener(int idcontabilidad) throws Exception;

    List<Contabilidad> obtener() throws Exception;
}
