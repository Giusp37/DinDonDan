package dindondan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 @author  Saccani Federico federico.saccani01@gmail.com
 @version 1.0
 */


/**
La classe Main viene utilizzata per l'avvio del metodo start dei 5 ThCavallo. 
Verra' chiesto all'utente di indovinare quale cavallo effettuerá piú step, successivamente
i cavalli inizieranno a galoppare e si fermeranno quando l'utente invierá in console un qualsiasi tasto. 
Se l'utente avra' indovinerá, vincerá il gioco, altrimenti perderá.
 */
public class main {
    public static void main(String args[]){
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        VariabiliCondivise DatiCondivisi = new VariabiliCondivise();
        /** 
        * Attributo di tipo boolean che identifica: Se true di eseguire il delay all'interno dei ThCavallo altrimenti di non eseguirlo
        * @author  Saccani Federico
        * @version 1.0
        */
        boolean DELAY = false;
        
        /** 
        * Attributo di tipo boolean che identifica: Se true di eseguire lo yield all'interno dei ThCavallo altrimenti di non eseguirlo
        * @author  Saccani Federico
        * @version 1.0
        */
        boolean YIELD = true;
        
        Scanner sc = new Scanner(System.in);
        
        ThCavallo cav1 = new ThCavallo("Clop1",DELAY,YIELD,DatiCondivisi);
        ThCavallo cav2 = new ThCavallo("Clop2",DELAY,YIELD,DatiCondivisi);
        ThCavallo cav3 = new ThCavallo("Clop3",DELAY,YIELD,DatiCondivisi);
        ThCavallo cav4 = new ThCavallo("Clop4",DELAY,YIELD,DatiCondivisi);
        ThCavallo cav5 = new ThCavallo("Clop5",DELAY,YIELD,DatiCondivisi);
        ThVisualizza visualizza = new ThVisualizza(DatiCondivisi);
        
        System.out.println("Che cavallo vincera'?");
        String cavVincente = sc.next();
        
        cav1.start();
        cav2.start();
        cav3.start();
        cav4.start();
        cav5.start();
        visualizza.start();
        
        
        //Se scrivo qualcosa, blocco tutto
        try{
        while(!(System.in.available()>0)){
            Thread.sleep(100);
        }
        }catch(InterruptedException e){}
        catch(IOException a){}
        
        
        
        System.out.println("");
        
        cav1.interrupt();
        cav2.interrupt();
        cav3.interrupt();
        cav4.interrupt();
        cav5.interrupt();
        visualizza.interrupt();
        
        try{
            cav1.join();
            cav2.join();
            cav3.join();
            cav4.join();
            cav5.join();  
            visualizza.join();
        }catch(Exception e){}


        CCavallo v[]=DatiCondivisi.getClassifica();
        
        if(v[0].getNome().equals(cavVincente)){
            System.out.println("\nVINTO!");
        }else{
            System.out.println("\nPERSO! Il cavallo vincente era: ");
            System.out.println(v[0].getNome());
        }
        
        System.out.println("Terminato!");
        
    }
}


