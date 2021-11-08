/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import datos.ArchivoCarrera;
import entidades.Competidor;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jairo
 */
public class Test {
    public static void main(String[] args) {
        
        String cc = new Scanner(System.in).next();
        ArchivoCarrera archivoTexto = new ArchivoCarrera();
        Competidor comp1 = new Competidor(cc, "Montoya", "BMW", 1, 1.30);
        
        archivoTexto.escribir(comp1);
        
        List<Competidor> lista = archivoTexto.leer();
        imprimirLista(lista);
        
    }
    
    public static void imprimirCompetidor(Competidor c){
        
        System.out.printf("%10s %10s %10s %10d %10.2f %n", c.getCc(), c.getNombrePiloto(), c.getEquipoPiloto(), 
                c.getPosicioClasificacion(), c.getTiempoCarrera());
    }
    
    public static void imprimirLista(List<Competidor> lista){
        for(Competidor c: lista){
            imprimirCompetidor(c);
        }
    }
    
}
