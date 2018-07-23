/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Tipoempleado;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ITipoempleado {

    int insertar(Tipoempleado tipoempleado) throws Exception;

    int modificar(Tipoempleado tipoempleado) throws Exception;

    int eliminar(Tipoempleado tipoempleado) throws Exception;

    Tipoempleado obtener(int idtipoempleado) throws Exception;
    
    Tipoempleado obtener(String nombre) throws Exception;

    List<Tipoempleado> obtener() throws Exception;

}
