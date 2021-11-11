/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Competidor;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jairo
 */
public class ArchivoCarreraBin implements IArchivo {
    
    

    @Override
    public Competidor eliminar(String cc) throws IOException {
        System.out.println("Elimina en binario");
        return null;
    }

    @Override
    public Competidor buscar(String cc) throws IOException {
        System.out.println("busca en binario");
        return null;
    }

    @Override
    public List<Competidor> leer() throws IOException {
        System.out.println("lee en binario");
        return null;
    }

    @Override
    public boolean escribir(Competidor c) throws IOException {
        System.out.println("Escribe en binario");
        return true;
    }
}
