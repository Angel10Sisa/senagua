/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Tipomedidor;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ITipomedidor {
    int insertar(Tipomedidor tipomedidor) throws Exception;

    int modificar(Tipomedidor tipomedidor) throws Exception;

    int eliminar(Tipomedidor tipomedidor) throws Exception;

    Tipomedidor obtener(int idtipomedidor) throws Exception;

    List<Tipomedidor> obtener() throws Exception;
    
}
