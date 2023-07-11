package com.example.zalando.takehome;

import java.util.LinkedList;
import java.util.Queue;

/** only "AA" "AB" "BB" with counts AA, AB , BB given   , make longestString with no AAA, BBB  */

class Model {
    public StringBuilder currentString = new StringBuilder();
    public String previousString;
    public int AA;
    public int BB;
    public int AB;

    public Model() {};
    public Model(String currentString, String previousString, int aA, int aB, int bB) {
        this.currentString.append(currentString);
        this.previousString = previousString;
        AA = aA;
        AB = aB;
        BB = bB;
    }

    public Model updateModel(String string, String previousString, int aA, int aB, int bB) {
        Model newModel = new Model();
        newModel.currentString = this.currentString.append(string);
        newModel.previousString = previousString;
        newModel.AA = aA;
        newModel.BB = bB;
        newModel.AB = aB;
        return newModel;
    }    
}

public class Question3 {
    public String solution(int AA, int AB, int BB) {
        Queue<Model> queue = new LinkedList<>();
        String maxString = "";
        Model model = null;
        int tempAA = AA;
        int tempAB = AB;
        int tempBB = BB;

        if(AA > 0) {
            model = new Model("AA", "AA",AA-1, tempAB, tempBB);
            queue.add(model);
        }

        if(AB > 0) {
            model = new Model("AB", "AB", tempAA, AB-1, tempBB);
            queue.add(model);

        }

        if(BB > 0) {
            model = new Model("BB", "BB",tempAA, tempAB, BB-1);
            queue.add(model);
        }

        while (!queue.isEmpty()) {
            model = queue.poll();

            if(model.currentString.toString().length() > maxString.length()) {
                maxString = model.currentString.toString();
            }

            if(model.previousString.compareTo("AA") == 0) {
                if(optionsAvailable(model.BB)) {
                    Model newModel = model.updateModel("BB", "BB", model.AA, model.AB, model.BB-1);
                    queue.add(newModel);
                }
            } else if(model.previousString.compareTo("AB") == 0) {
                if(optionsAvailable(model.AA)) {
                    Model newModel = model.updateModel("AA", "AA", model.AA-1, model.AB, model.BB);
                    queue.add(newModel);
                }
                if(optionsAvailable(model.AB)) {
                     Model newModel = model.updateModel("AB", "AB", model.AA, model.AB-1, model.BB);
                    queue.add(newModel);
                }
            } else {
                if (optionsAvailable(model.AA)) {
                    Model newModel = model.updateModel("AA", "AA", model.AA-1, model.AB, model.BB);
                    queue.add(newModel);
                } 

                if (optionsAvailable(model.AB)) {
                    Model newModel =model.updateModel("AB", "AB", model.AA, model.AB-1, model.BB);
                    queue.add(newModel);
                }
            }
        }
        return maxString;

     }

    private boolean optionsAvailable(int count) {
        return count > 0;
    }
        
}
