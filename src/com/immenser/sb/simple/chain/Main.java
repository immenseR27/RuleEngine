package com.immenser.sb.chain;

import com.immenser.sb.Callback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Rule rule1 = new Rule(10, "<", 20);
        Rule rule2 = new Rule(10, "<", 20);
        Rule rule3 = new Rule(10, "=", 20);

        Callback callback1 = () -> System.out.println("Speed faster!");
        Callback callback2 = () -> System.out.println("Do something other!");
        Callback callback3 = () -> System.out.println("Do something other again!");

        rule1.chain(new Rule(10, "<", 20)).setAction(callback1);
        rule2.chain(new Rule(10, "=", 10)).setAction(callback2);
        rule3.chain(new Rule(10, ">", 20)).setAction(callback3);

        List<Rule> chain = new ArrayList<>(Arrays.asList(rule1, rule2, rule3));

        Engine engine = new Engine(chain);
        engine.getResult();
    }
}
