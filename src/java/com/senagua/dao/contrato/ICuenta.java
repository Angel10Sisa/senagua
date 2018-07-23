/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Cuenta;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICuenta {

    int insertar(Cuenta cuenta) throws Exception;

    int modificar(Cuenta cuenta) throws Exception;

    int eliminar(Cuenta cuenta) throws Exception;

    Cuenta obtener(int idcuenta) throws Exception;

    List<Cuenta> obtener() throws Exception;
}
