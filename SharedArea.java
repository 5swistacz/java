package com.company;

        import java.util.*;

public class SharedArea {
    private boolean status;
    private String com;
    private Integer id;
    private List<Integer> coll = new ArrayList<>();

    public SharedArea() {
        this.status = true;
    }

    public synchronized boolean putId(Integer id) {
        coll.add(id);
        notify();
        return true;
    }

    public synchronized String readComm(Integer id) {
        if( "quit".equals(this.com)) {
            return this.com;
        }


        if(this.id == id && !status) {
            this.status = true; //komunikat zosta� przeczytany
            notify();
            return com;
        }
        else {
            return null;
        }
    }

    public synchronized void writeComm(String s) {
        while(!status || this.coll.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int index = coll.indexOf(this.id);
        if(index +1 == coll.size()) {
            index = -1;
        }
        this.id = coll.get(index + 1);

        this.com = s;
        this.status = false;
    }
}
