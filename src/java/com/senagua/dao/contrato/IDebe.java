/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Debe;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IDebe {
    int insertar(Debe debe) throws Exception;

    int modificar(Debe debe) throws Exception;

    int eliminar(Debe debe) throws Exception;

    Debe obtener(int iddebe) throws Exception;

    List<Debe> obtener() throws Exception;
}
