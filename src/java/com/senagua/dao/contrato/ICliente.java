/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senagua.dao.contrato;

import com.senagua.rnegocio.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface ICliente {
    int  insertar(Cliente cliente);
    int modificar(Cliente cliente);
    int eliminar(Cliente cliente);
    Cliente obtener(int idcliente)throws Exception;
    List<Cliente> obtener()throws Exception;
    
}
