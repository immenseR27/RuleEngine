package com.immenser.sb.chain;

import java.util.List;

public class Engine {

    private List<Rule> rules;
    //private boolean result;

    public Engine(List<Rule> rules) {
        this.rules = rules;
    }

    public void getResult() {
        //result = true;
        for (Rule rule : rules) {
            cycle(rule);

        }
        //return result;
    }

    public void cycle(Rule rule){
        if (rule.check()) {
            if (rule.getNext() != null) {
                rule = rule.getNext();
                cycle(rule);
            }
            else rule.getAction().action();
//            result = result & rule.check();
        }
    }
}
