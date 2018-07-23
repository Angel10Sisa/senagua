/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Consumo;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IConsumo {
    
        int insertar(Consumo consumo) throws Exception;

    int modificar(Consumo consumo) throws Exception;

    int eliminar(Consumo consumo) throws Exception;

    Consumo obtener(int idconsumo) throws Exception;

    List<Consumo> obtener() throws Exception;
    
}
