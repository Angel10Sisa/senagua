/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Facturaagua;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public interface IFacturaagua {
    int  insertar(Facturaagua facturaagua);
    int modificar(Facturaagua facturaagua);
    int eliminar(Facturaagua facturaagua);
    Facturaagua obtener(int idfactura)throws Exception;
    List<Facturaagua> obtener()throws Exception;
}
