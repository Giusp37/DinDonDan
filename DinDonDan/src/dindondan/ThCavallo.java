package dindondan;

import java.util.Random;
import javax.swing.DefaultListModel;
import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 * @author Saccani Federico federico.saccani01@gmail.com
 * @version 1.0
 */
/**
 * La classe viene utilizzata per la gestione di un Thread che come compito ha
 * quello di far visualizzare su console l'attributo stringa della classe
 */
public class ThCavallo extends Thread {

    /**
     * Attributo di tipo VariabiliCondivise che viene utilizzato per la gestione
     * di varibili condivise
     *
     * @author Saccani Federico
     * @version 1.0
     */
    private VariabiliCondivise ptrVariabili;

    /**
     * Attributo di tipo boolean che identifica se bisogna eseguire il delay
     * (aspettando un tempo random) all'interno del thread oppure non eseguirlo
     *
     * @author Saccani Federico
     * @version 1.0
     */
    private boolean delay;

    /**
     * Attributo di tipo boolean che identifica se bisogna eseguire lo yield
     * all'interno del thread oppure non eseguirlo
     *
     * @author Saccani Federico
     * @version 1.0
     */
    private boolean yield;

    /**
     * Attributo di tipo int che si riferisce al numero di volte che dovra'
     * essere visualizzato l'attributo verso di tipo String in console
     *
     * @author Saccani Federico
     * @version 1.0
     */
    //private int stepsToDo=0;
    /**
     * Attributo di tipo String che rappresente la stringa che dovra' essere
     * visualizzata su console
     *
     * @author Saccani Federico
     * @version 1.0
     */
    private String verso = "";

    /**
     * @brief Costruttore della classe
     *
     * Il costruttore permette di associare ad ogni attributo della classe i
     * relativi valore passati come parametro
     * @param ptrVariabili oggetto di tipo VariabiliCondivise che viene
     * utilizzato per gestione alcune variabili condivise
     * @param verso valore String che identifica la stringa che dovra' essere
     * visualizzata su console
     * @param delay identifica se bisogna eseguire oppure no il delay (true=lo
     * eseguo)
     * @param yield identifica se bisogna eseguire oppure no lo yield (true=lo
     * eseguo)
     *
     * @author Saccani Federico
     * @version 1.0
     */
    public ThCavallo(/*int numOfStep,*/String verso, boolean delay, boolean yield, VariabiliCondivise ptrVariabili) {
        //this.stepsToDo=numOfStep;
        this.delay = delay;
        this.yield = yield;
        this.verso = verso;
        this.ptrVariabili = ptrVariabili;
    }

    /**
     * @brief Metodo run del Thread
     *
     * Il metodo permette di salvare nell'ultima posizione dell'array Schermo
     * presente in ptrVariabili l'attributo verso fino a quando non viene
     * interrotto. Ogni volta che pushato nell'array, eseguira' il delay
     * (aspettando un tempo random) o lo yield a seconda agli attributi booleani
     * "yield" e "delay" della classe Inoltre ad ogni verso "emesso" verra'
     * incrementata la variabile corrispondente al cavallo presente nell'oggetto
     * ptrVariabili Si controllerá inolre se é stato richiesto un Interrupt, in
     * caso affermativo, si uscirá dal metodo.
     *
     * @author Saccani Federico
     * @version 1.0
     */
    @Override
    public void run() {
        try {
            Random rn = new Random();
            while (true) {
                
                
                ptrVariabili.getLettoSchermo().Wait();
                
                ptrVariabili.getSemSchermo().Wait();
                ptrVariabili.getSchermo().push(verso);
                ptrVariabili.getSemSchermo().Signal();
                
                ptrVariabili.getScrittoSchermo().Signal();

                ptrVariabili.getSemStep().Wait();
                ptrVariabili.incStep(verso);
                ptrVariabili.getSemStep().Signal();

                if (delay) {
                    Thread.sleep(rn.nextInt(2000));
                }
                if (yield) {
                    Thread.yield();
                }

                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("errore: " + e.toString());
        }

    }
}
