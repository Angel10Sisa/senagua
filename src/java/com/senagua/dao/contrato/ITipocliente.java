/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Tipocliente;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ITipocliente {

    int insertar(Tipocliente tipocliente) throws Exception;

    int modificar(Tipocliente tipocliente) throws Exception;

    int eliminar(Tipocliente tipocliente) throws Exception;

    Tipocliente obtener(int idtipocliente) throws Exception;

    List<Tipocliente> obtener() throws Exception;
}
