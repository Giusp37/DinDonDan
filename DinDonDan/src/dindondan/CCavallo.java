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
La classe viene utilizzata per la gestione di un cavallo caratterizzato da nome e numero di step effettuati
 */
public class CCavallo {
    /** 
     * Attributo di tipo String che identifica il nome del cavallo
     * @author  Saccani Federico
     * @version 1.0
     */
    private String nome;
    
    /** 
     * Attributo di tipo Int, e' un contatore che identifica il numero di passi (step) fatti da un cavallo 
     * @author  Saccani Federico
     * @version 1.0
     */
    private int step;
    
    /**
    @brief Costruttore Vuoto della classe

    Il costruttore permette inizializzare gli attributi

    @author  Saccani Federico
    @version 1.0
    */
    public CCavallo(){
        nome="";
        step=0;
    }
    
    /**
    @brief Costruttore della classe con un solo parametro

    Il costruttore permette di associare all'attributo nome, il parametro passato come parametro, inoltre imposta l'attributo step a 0
    @param nome nome che assumera' il cavallo
    
    @author  Saccani Federico
    @version 1.0
    */
    public CCavallo(String nome){
        this.nome=nome;
        step=0;
    }
    
    /**
    @brief Costruttore della classe 

    Il costruttore permette di associare gli attributi della classe in base ai valori passati come parametro
    @param nome nome che assumera' il cavallo
    @param step step iniziali fatti da un cavallo
    * 
    @author  Saccani Federico
    @version 1.0
    */
    public CCavallo(String nome, int step){
        this.nome=nome;
        this.step=step;
    }
    
    /**
    @brief Metodo che permette di incrementare l'attributo step

    Il metodo permette incrementare di una unitá l'attributo step della classe
    
    @author  Saccani Federico
    @version 1.0
    */
    public void incStep(){
        step++;
    }
    
    /**
    @brief Metodo che restituisce l'attributo step della classe

    Il metodo ritorna il valore dell'attributo step
    
    @return valore dell'attributo step della classe
    @author  Saccani Federico
    @version 1.0
    */
    public int getStep(){
        return step;
    }
    
    /**
    @brief Metodo che restituisce l'attributo nome della classe

    Il metodo ritorna il valore dell'attributo nome
    
    @return valore String dell'attributo nome della classe
    @author  Saccani Federico
    @version 1.0
    */
    public String getNome(){
        return nome;
    }
}
