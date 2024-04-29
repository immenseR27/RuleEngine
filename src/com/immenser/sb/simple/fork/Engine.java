package com.immenser.sb.fork;

import java.util.Iterator;
import java.util.List;

public class Engine {

    private List<List<Rule>> rules;

    public Engine(List<List<Rule>> rules) {
        this.rules = rules;
    }

    public void getResult() {
        for (List<Rule> tree : rules){
            boolean result = false;
            Iterator<Rule> iterator = tree.iterator();
            while (iterator.hasNext() && !result){
                Rule rule = iterator.next();
                result = cycle(rule);
            }
        }
    }

    public boolean cycle(Rule rule){
        if (rule.check()) {
            if (rule.getNext() != null) {
                rule = rule.getNext();
                return cycle(rule);
            }
            else {
                rule.getAction().action();
                return true;
            }
        }
        else return false;
    }
}