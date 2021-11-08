/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Competidor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jairo
 */
public class ArchivoCarrera {
    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoCarrera() {
        this.archivo = new File("ClasificacionF1.dat");
    }
    
    public ArchivoCarrera(String name){
        this.archivo = new File(name);
    }

    /**
     * @return the archivo
     */
    public File getArchivo() {
        return archivo;
    }

    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * @return the aEscritura
     */
    public FileWriter getaEscritura() {
        return aEscritura;
    }

    /**
     * @param aEscritura the aEscritura to set
     */
    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    /**
     * @return the aLectura
     */
    public Scanner getaLectura() {
        return aLectura;
    }

    /**
     * @param aLectura the aLectura to set
     */
    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }
    
    public Competidor leerCompetidor(String linea[]){
        Competidor c = new Competidor();
        c.setCc(linea[0]);
        c.setNombrePiloto(linea[1]);
        c.setEquipoPiloto(linea[2]);
        c.setPosicioClasificacion(Integer.valueOf(linea[3]));
        c.setTiempoCarrera(Double.valueOf(linea[4]));
        return c;
    }
    
    public List<Competidor> leer(){
       List<Competidor> lista = null;
        try {
            
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while(this.aLectura.hasNext()){
                String linea[] = this.aLectura.nextLine().split(";");
                Competidor c = this.leerCompetidor(linea);
                lista.add(c);
            }
            return lista;
            
        } catch (FileNotFoundException ex) {
                System.out.println("EL archivo no se encuentra o no pueder ser leido");
                return null;
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
        
    }
    
    public boolean escribir(Competidor c){
        PrintWriter escritor = null;
        boolean error=false;
        try{
            this.aEscritura = new FileWriter(this.archivo, true); // edicio
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(c.getDatosFileText());
            error = true;
        }catch(IOException ioe){
            System.out.println("Error al abrir el archivo para escritura...");
           
        }
        finally{
            if(escritor!=null)
                escritor.close();
            
            if(this.aEscritura!=null){
                try{
                    this.aEscritura.close();
                }catch(IOException io){
                    System.out.println(io);
                }    
            }    
            return error;
        }
    }
    
    
}
