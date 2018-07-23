/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Facturamulta;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public interface IFacturamulta {
    int  insertar(Facturamulta facturamulta);
    int modificar(Facturamulta facturamulta);
    int eliminar(Facturamulta facturamulta);
    Facturamulta obtener(int idfactura)throws Exception;
    List<Facturamulta> obtener()throws Exception;
}
