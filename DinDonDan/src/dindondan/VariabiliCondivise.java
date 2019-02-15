/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

import java.util.concurrent.Semaphore;

/**
 @author  Saccani Federico federico.saccani01@gmail.com
 @version 1.0
 */

/**
La classe viene utilizzata per la gestione di 4 variabili condivise utilizzabili dai cavalli presenti nella classe ThCavallo
 */
public class VariabiliCondivise {
    
    /** 
     * Attributo di tipo Schermo; é un oggetto in grado di gestire un vettore contenete i versi emessi da ogni cavallo
     * @author  Saccani Federico
     * @version 1.0
     */
    private Schermo schermo = new Schermo();
    
    
    /** 
     * Attributo di tipo CCavallo; é un vettore che rappresenta 5 cavalli di tipo CCavallo
     * @author  Saccani Federico
     * @version 1.0
     */
    private CCavallo stepCavallo[]=new CCavallo[5];

    private Semaforo mutexSchermo = new Semaforo(1);
    private Semaforo mutexStep = new Semaforo(1);
    private Semaforo lettoSchermo = new Semaforo(1);
    private Semaforo scrittoSchermo = new Semaforo(0);

    
    /**
    @brief Costruttore della classe

    Il costruttore inizializza gli elementi del vettore con 5 elementi di tipo CCavallo passandogli i nomi dei 5 cavalli che verranno utilizzati
    
    @author  Saccani Federico
    @version 1.0
    */
    public VariabiliCondivise(){   
        stepCavallo[0] = new CCavallo("Clop1");
        stepCavallo[1] = new CCavallo("Clop2");
        stepCavallo[2] = new CCavallo("Clop3");
        stepCavallo[3] = new CCavallo("Clop4");
        stepCavallo[4] = new CCavallo("Clop5");
    }
    
    
    /**
    @brief Metodo che incrementa gli step fatti da un cavallo

    Il metodo incremente gli step fatti dal nome del cavallo passato come parametro. Ricerca il cavallo nel vettore e richiama il metodo incStep dell'oggetto corrispondente presente nel vettore
    @param versoDelCavallo verso emmesso dal cavallo che servira' a individuare il cavallo al quale bisognerá incrementare gli step
    
    
    @author  Saccani Federico
    @version 1.0
    */
    public void incStep(String versoDelCavallo) {
        switch (versoDelCavallo) {
            case "Clop1":
                stepCavallo[0].incStep();
                break;
            case "Clop2":
                stepCavallo[1].incStep();
            case "Clop3":
                stepCavallo[2].incStep();
                break;
            case "Clop4":
                stepCavallo[3].incStep();
                break;
            case "Clop5":
                stepCavallo[4].incStep();
                break;
            default:
                break;
        }
    }

    /**
    @brief Metodo che restituisce il numero di step fatti da un cavallo presente nel vettore

    Il metodo restituisce gli step effettuati da un cavallo presente nel vettore in base alla posizione passata come parametro
    @param numDiCavallo posizione del cavallo presente nel vettore del quale si vuole ottenere il numero degli step effettuati
    
    @return valore step dell'oggetto CCavallo presente nella posizione passata come parametro
    @author  Saccani Federico
    @version 1.0
    */
    public int getStep(int numDiCavallo) {
        if (numDiCavallo>=0 && numDiCavallo<=4)
            return stepCavallo[numDiCavallo-1].getStep();
        else
            return -1;
    }
    
    /**
     
    @brief Metodo che restituisce un vettore CCavallo contenete i cavalli ordinati in base agli step effettuati (dal maggiore al minore)

    Il metodo effettua un booble sort dei cavalli presenti nel vettore in base agli step effettuati da ciascuno. 
    Ritornerá quindi il vettore ordinato; Il vettore sará quindi ordinato in modo decrescente
    
    @return vettore ordinato degli oggetti CCavallo presenti nell'attributo stepCavallo
    @author  Saccani Federico
    @version 1.0
    */
    public CCavallo[] getClassifica(){
        int j=0;
        boolean ordinato=false;
        while(ordinato==false){
            ordinato=true;
            for(int i=0; i<5-1-j; i++){
                if(stepCavallo[i].getStep() < stepCavallo[i+1].getStep()){
                    ordinato=false;
                    CCavallo tmp = stepCavallo[i];
                    stepCavallo[i]=stepCavallo[i+1];
                    stepCavallo[i+1]=tmp;
                }
            }
            j++;
        }
        
        
        return stepCavallo;
    }
    
    
    /**
    @brief Metodo che restituisce l'attributo schermo della classe

    @return oggetto schermo della classe 
    @author  Saccani Federico
    @version 1.0
    */
    public Schermo getSchermo(){
        return schermo;
    }
    
    
    public Semaforo getSemSchermo(){
        return mutexSchermo;
    }
    
    public Semaforo getSemStep(){
        return mutexStep;
    }

    public CCavallo[] getStepCavallo() {
        return stepCavallo;
    }

    public void setStepCavallo(CCavallo[] stepCavallo) {
        this.stepCavallo = stepCavallo;
    }

    public Semaforo getMutexSchermo() {
        return mutexSchermo;
    }

    public void setMutexSchermo(Semaforo mutexSchermo) {
        this.mutexSchermo = mutexSchermo;
    }

    public Semaforo getMutexStep() {
        return mutexStep;
    }

    public void setMutexStep(Semaforo mutexStep) {
        this.mutexStep = mutexStep;
    }

    public Semaforo getLettoSchermo() {
        return lettoSchermo;
    }

    public void setLettoSchermo(Semaforo lettoSchermo) {
        this.lettoSchermo = lettoSchermo;
    }

    public Semaforo getScrittoSchermo() {
        return scrittoSchermo;
    }

    public void setScrittoSchermo(Semaforo scrittoSchermo) {
        this.scrittoSchermo = scrittoSchermo;
    }
    
    

    
}
