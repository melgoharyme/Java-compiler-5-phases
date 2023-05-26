package org.example;

import static org.example.Lexical.word;

public class Semantic{
    public static String[][] tableXYZ = {{"1", "Mahmoud"}, {"2", "Ahmed"}, {"3", "Omar"}, {"4", "Ali"}};
    public Semantic() {
        if (semanticCheck() != 1)
            System.out.println("Error. No semantics analysis.\n");
    }

    int semanticCheck() {
        System.out.println("\nPhase 3 : Semantics Analysis\n============================");
        if ( ( tableXYZ != null) && ( Integer.parseInt(word[6]) - 1 >= 0 ) && ( Integer.parseInt(word[6]) - 1 <= tableXYZ.length  ) ) {
            System.out.println("Valid Statement. Done semantics analysis.");
            Generation generation = new Generation();
            return 1;
        }
        else
            return 0;
    }
}
