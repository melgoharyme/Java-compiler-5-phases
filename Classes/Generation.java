package org.example;

import static org.example.Lexical.word;
import static org.example.Semantic.tableXYZ;

public class Generation{
    public Generation() {
        if (makeGeneration() == 1) {
            System.out.println("Done generation code.");
            Optimization optimization = new Optimization();
        }
        else
            System.out.println("Error. No generation code.\n");
    }
    int makeGeneration(){
        System.out.println("\nPhase 4 : Code Generation\n=========================");
        System.out.println(tableXYZ[Integer.parseInt(word[6]) - 1][1]+"\n");
        return 1;
    }
}
