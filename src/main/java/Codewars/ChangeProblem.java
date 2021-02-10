package Codewars;

import java.util.HashMap;
import java.util.Map;

public class ChangeProblem {
    public static void main(String[] args) {
        Change.looseChange((int) 56.54f);
    }
}

class Change {
    public static HashMap<String, Integer> looseChange(int cent) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);
        if(cent <= 0){
            return map;
        }
        int q = cent / 25;
        if(q > 0){
            map.put("Quarters", q);
        }
        int remQ = cent % 25;
        int d = remQ / 10;
        if(d > 0){
            map.put("Dimes", d);
        }
        int remD = remQ % 10;
        int n = remD / 5;
        if(n > 0){
            map.put("Nickels", n);
        }
        int remN = remD % 5;
        map.put("Pennies", remN);
        return map;
    }
}