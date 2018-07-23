/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Precio;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IPrecio {
    int insertar(Precio precio) throws Exception;

    int modificar(Precio precio) throws Exception;

    int eliminar(Precio precio) throws Exception;

    Precio obtener(int idprecio) throws Exception;

    List<Precio> obtener() throws Exception;
}
