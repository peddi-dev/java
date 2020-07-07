package org.peddi.javase.collections.core.queue;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class QueueDemo {

    public void countDownDemo(int time){
        out.println("countDownDemo");
        Queue<Integer> queue = new LinkedList();

        for(int i=time; i>0; i--){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            out.println(queue.remove());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  static void main(String[] args){
        QueueDemo app = new QueueDemo();
        app.countDownDemo(10);
    }
}
