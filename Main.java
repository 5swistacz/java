package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SharedArea sh = new SharedArea();

        CommWriter cw = new CommWriter(sh);
        CommReader cr = new CommReader(sh, 1);
        CommReader cr2 = new CommReader(sh, 2);
        CommReader cr3 = new CommReader(sh, 3);



        Thread t = new Thread(cr);
        Thread t1 = new Thread(cw);
        Thread t2 = new Thread(cr2);
        Thread t3 = new Thread(cr3);
        t1.start();
        t.start();
        t2.start();
        t3.start();
    }
}
