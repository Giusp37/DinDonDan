/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dindondan;

import java.io.IOException;

/**
 *
 * @author saccani_federico
 */
public class ThVisualizza extends Thread {

    private VariabiliCondivise ptrVariabili;

    public ThVisualizza(VariabiliCondivise ptrVariabili) {
        this.ptrVariabili = ptrVariabili;
    }

    @Override
    public void run() {
        //visualizzo il vettore schermo
        boolean continua = true;
        int i = 0;
        ptrVariabili.getSemSchermo().Wait();
        Schermo schermo = ptrVariabili.getSchermo();
        ptrVariabili.getSemSchermo().Signal();

        while (continua) {
            ptrVariabili.getScrittoSchermo().Wait();
            ptrVariabili.getSemSchermo().Wait();
            schermo.visualizza();
            ptrVariabili.getSemSchermo().Signal();
            ptrVariabili.getLettoSchermo().Signal();

            if (Thread.currentThread().isInterrupted()) {
                continua = false;
                ptrVariabili.getLettoSchermo().Signal();
                ptrVariabili.getLettoSchermo().Signal();
                ptrVariabili.getLettoSchermo().Signal();
                ptrVariabili.getLettoSchermo().Signal();
                ptrVariabili.getLettoSchermo().Signal();
            }

        }
    }
}
