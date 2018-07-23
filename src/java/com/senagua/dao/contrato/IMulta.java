/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Multa;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IMulta {
    int insertar(Multa multa) throws Exception;

    int modificar(Multa multa) throws Exception;

    int eliminar(Multa multa) throws Exception;

    Multa obtener(int idmulta) throws Exception;

    List<Multa> obtener() throws Exception;
    
    
}
