/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Haber;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IHaber {
    int insertar(Haber haber) throws Exception;

    int modificar(Haber haber) throws Exception;

    int eliminar(Haber haber) throws Exception;

    Haber obtener(int idhaber) throws Exception;

    List<Haber> obtener() throws Exception;
}
