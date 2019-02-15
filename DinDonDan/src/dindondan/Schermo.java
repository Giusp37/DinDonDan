/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

/**
 @author  Saccani Federico federico.saccani01@gmail.com
 @version 1.0
 */

/**
La classe viene utilizzata per la gestione di un array di Stringhe contenente tutti i versi emessi dai thCavallo
 */
public class Schermo {
    /** 
     * Attributo di tipo int che rappresente il numero massimo di stringhe presenti nel vettore
     * @author  Saccani Federico
     * @version 1.0
     */
    private int MAXEL;
    
    /** 
     * Attributo di tipo int che rappresente il numero attuale di stringhe presenti nel vettore
     * @author  Saccani Federico
     * @version 1.0
     */
    private int numEl;
    
    /** 
     * L'attributo rappresenta un vettore di Stringhe 
     * @author  Saccani Federico
     * @version 1.0
     */
    private String schermo[];
    
    
    
    /**
    @brief Costruttore della classe

    Il costruttore permette di inizializzare gli attributi della classe a valori di default 
    @author  Saccani Federico
    @version 1.0
    */
    public Schermo(){
        MAXEL=10000;
        numEl=0;
        schermo = new String[MAXEL];
        
        for(int i = 0; i < MAXEL; i++)
            schermo[i] = "";
    }
    
    /**
    @brief Il metodo permette di aggiungere la stringa passata come parametro in coda all'attributo vettore
     
    Il metodo controlla se c'e' ancora spazio nel vettore, in caso affermativo, aggiunge nella prima posizione libera del vettore 
    l'oggetto Stringa passato come parametro
    
    @param verso oggetto di tipo Stringa che dovra' essere aggiunto all'attributo array (schermo) 
    @author  Saccani Federico
    @version 1.0
    */
    public void push(String verso){
        if(numEl<MAXEL){
            schermo[numEl]=verso;
            
            numEl++;
        }
    }
    
    /**
    @brief Il metodo ritorna il valore dell'oggetto di tipo Stringa presente nel vettore in base alla posizione passata come parametro
     
    Il metodo restituisce la stringa presente nel vettore in base alla posizione pos passata come parametro
    
    @param pos posizione del vettore della quale si vuole ottenere il valore String
    @return oggetto Stringa presente nella posizione pos passata come parametro
    @author  Saccani Federico
    @version 1.0
    */
    public String getPos(int pos){
        return schermo[pos];
    }
    
    /**
    @brief Il metodo ritorna il valore dell'attributo numEl della classe
     
    Il metodo restituisce il valore di tipo int presente nell'attributo numEl della classe 
    
    @return valore int dell'attributo numEl
    @author  Saccani Federico
    @version 1.0
    */
    public int getNumEl(){
        return numEl;
    }

    void visualizza() {
      System.out.println("\n\n\nVisualizzazione stato gara");
      for(int i = 0; i < numEl; i++)
          System.out.println(schermo[i]);
      }
}
