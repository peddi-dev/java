package org.peddi.javase.collections.core.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import static java.lang.System.out;

public class DequeDemo {

    public void arrayDequeDemo(){

        out.println("********ArrayDeque");

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(10);
        deque.addLast(20);

        out.printf("%nDeque: %n%s",deque);

        deque.addFirst(30);
        out.printf("%naddFirst: %n%s",deque);

        deque.offerLast(40);
        out.printf("%nofferLast: %n%s",deque);

        deque.offerFirst(50);
        out.printf("%nofferLast: %n%s",deque);

        deque.offerFirst(60);
        out.printf("%nofferLast: %n%s",deque);

        out.printf("%npeekFirst: %n%s",deque.peekFirst());
        out.printf("%npeekLast: %n%s",deque.peekLast());

        out.printf("%ngetFirst: %n%s",deque.getFirst());
        out.printf("%ngetLast: %n%s",deque.getLast());

        out.printf("%nDeque: %n%s",deque);

        out.printf("%nremoveFirst: %s%n%s",deque.removeFirst(), deque);
        out.printf("%nremoveLast: %s%n%s",deque.removeLast(), deque);

        out.printf("%npollirst: %s%n%s",deque.pollFirst(), deque);
        out.printf("%npollLast: %s%n%s",deque.pollLast(), deque);


    }

    public void linkedListDemo(){
        out.println("\n********Deque with LinkedList");

        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(10);
        deque.addLast(20);

        out.printf("%nDeque: %n%s",deque);

        deque.addFirst(30);
        out.printf("%naddFirst: %n%s",deque);

        deque.offerLast(40);
        out.printf("%nofferLast: %n%s",deque);

        deque.offerFirst(50);
        out.printf("%nofferLast: %n%s",deque);

        deque.offerFirst(60);
        out.printf("%nofferLast: %n%s",deque);

        out.printf("%npeekFirst: %n%s",deque.peekFirst());
        out.printf("%npeekLast: %n%s",deque.peekLast());

        out.printf("%ngetFirst: %n%s",deque.getFirst());
        out.printf("%ngetLast: %n%s",deque.getLast());

        out.printf("%nDeque: %n%s",deque);

        out.printf("%nremoveFirst: %s%n%s",deque.removeFirst(), deque);
        out.printf("%nremoveLast: %s%n%s",deque.removeLast(), deque);

        out.printf("%npollirst: %s%n%s",deque.pollFirst(), deque);
        out.printf("%npollLast: %s%n%s",deque.pollLast(), deque);
    }

    public  static void main(String[] args){
        DequeDemo app = new  DequeDemo();
        app.arrayDequeDemo();
        app.linkedListDemo();
    }
}
