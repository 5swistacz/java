package com.company;


public class CommReader implements Runnable {
    private SharedArea sh;
    private boolean running = true;
    private Integer id;

    public CommReader(SharedArea sh, Integer id) {
        this.sh = sh;
        this.id = id;
    }

    public void run() {
        sh.putId(id);
        while(running) {
                String com = sh.readComm(id);
                if(com != null){
                    System.out.println(id + ": " + com);
                }
                if(( "quit".equals(com))) {
                    running = false;
                }

        }
    }
}
