package org.example;

import java.util.Scanner;

public class Lexical {
    public static String grammar;
    public static String[] word;

    public Lexical() {
        grammarEntry();
    }
    public static int grammarEntry() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter your grammar : ");
        grammar = input.nextLine().trim();
        word = grammar.split("\\s+");
        if (grammar.isEmpty()){
            System.out.println("\nGrammar is empty.\n");
            return 0;
        }
        else{
            System.out.println("\nPhase 1 : Lexical Analysis\n==========================");
            for (int i = 0; i < word.length; i++) {
                if (word[i].equals("ALTER") || word[i].equals("CREATE") || word[i].equals("DELETE")
                        || word[i].equals("DROP") || word[i].equals("INSERT") || word[i].equals("SELECT")
                        || word[i].equals("UPDATE"))
                    System.out.println("Statement  : " + word[i]);
                else if (word[i].equals("AND") || word[i].equals("BETWEEN") || word[i].equals("DISTINCT")
                        || word[i].equals("EXISTS") || word[i].equals("FROM") || word[i].equals("GROUP BY")
                        || word[i].equals("HAVING") || word[i].equals("IN") || word[i].equals("JOIN")
                        || word[i].equals("LIKE") || word[i].equals("NOT") || word[i].equals("NULL")
                        || word[i].equals("ON") || word[i].equals("OR") || word[i].equals("ORDER BY")
                        || word[i].equals("TABLE") || word[i].equals("UNION") || word[i].equals("WHERE")
                        || word[i].equals("FOR") || word[i].equals("RESULT") || word[i].equals("SET")
                        || word[i].equals("CURSOR") || word[i].equals("ALLOCATE"))
                    System.out.println(word[i] + " : Keyword");
                else if (word[i].matches("int|float|char|double|boolean"))
                    System.out.println(word[i] + " : Type");
                else if (word[i].matches("[a-zA-Z][a-zA-Z0-9]*"))
                    System.out.println(word[i] + " : Identifier");
                else if (word[i].matches("\\d+") || word[i].matches("^[^<>.';]*$\\n"))
                    System.out.println("Digit : " + word[i]);
                else if (word[i].matches("true|false"))
                    System.out.println("Boolean : " + word[i]);
                else if (word[i].equals("+") || word[i].equals("-") || word[i].equals("*") || word[i].equals("/")
                        || word[i].equals("=") || word[i].equals("<") || word[i].equals(">") || word[i].equals("==")
                        || word[i].equals("!=") || word[i].equals("<=") || word[i].equals(">=") || word[i].equals("::="))
                    System.out.println("Operator : " + word[i]);
                else if (word[i].equals("'"))
                    System.out.println("Quote : " + word[i]);
                else if (word[i].equals("(") || word[i].equals(")") || word[i].equals("{") || word[i].equals("}") || word[i].matches(";"))
                    System.out.println(word[i] + " : Symbol");
            }
            Syntax syntax = new Syntax();
            return 1;
        }
    }
}
