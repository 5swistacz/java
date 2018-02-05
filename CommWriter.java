package com.company;
import java.util.Random;


public class CommWriter implements Runnable {
    private SharedArea sh;
    private boolean running = true;
    Random generator;

    public CommWriter(SharedArea sh ) {
        this.sh = sh;
        generator = new Random();
    }
    public void run() {
        int i=0;
        while(running){
            //int i = generator.nextInt(100);

            i++;

            if(i == 100) {
                sh.writeComm("quit");
                running = false;
            } else {
                sh.writeComm("aaaa" + i);
            }
        }

    }
}