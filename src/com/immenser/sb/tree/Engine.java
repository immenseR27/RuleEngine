package com.immenser.sb.tree;

import java.util.List;

public class Engine {

    private List<Rule> rules;

    public Engine(List<Rule> rules) {
        this.rules = rules;
    }

    public void getResult() {
        for (Rule rule : rules) {
            cycle(rule);
        }
    }

    public void cycle(Rule rule){
            System.out.println(rule.name);
            if (rule.check()) {
                if (rule.getAction() != null) {
                    rule.getAction().action();
                }
                int nextnulls = 0;
                if (rule.getNext() != null) {
                    for (Rule subrule : rule.getNext()) {
                        if (subrule == null) {
                            nextnulls += 1;
                        }
                    }
                }
                if (rule.getNext() != null && rule.getNext().size() - nextnulls != 0 ) {
                    for (Rule subrule : rule.getNext()) {
                        if (subrule != null){
                        cycle(subrule);
                        }
                    }
                }
                else{
                    int prevnulls = 0;
                    for (Rule subrule : rule.getPrev()){
                        if (subrule == null){
                            prevnulls += 1;
                        }
                    }
                    if (rule.getPrev().size() - prevnulls > 1){
                        for (Rule prev : rule.getPrev()){
                            prev.getNext().set(prev.getNext().indexOf(rule), null);
                        }
                    }
                }
            }
    }
}
