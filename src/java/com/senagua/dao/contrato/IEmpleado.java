/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Empleado;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IEmpleado {

    int insertar(Empleado empleado) throws Exception;

    int modificar(Empleado empleado) throws Exception;

    int eliminar(Empleado empleado) throws Exception;

    Empleado obtener(int idempleado) throws Exception;
    
    Empleado obtener(String cedula) throws Exception;
    
    List<Empleado> obtenernombre(String nombre) throws Exception;
    
    List<Empleado> obtenerapellido(String apellido) throws Exception;

    List<Empleado> obtener() throws Exception;
}
