package org.example;

import static org.example.Lexical.grammar;
import static org.example.Lexical.word;

public class Syntax{
    public Syntax(){
        syntaxCheck();
    }
    public static int syntaxCheck(){
        System.out.println("\nPhase 2 : Syntax Analysis\n=========================");
        if (word[0].equals("ALLOCATE") && word[1].equals(word[1]) &&
                word[2].matches("CURSOR") && word[3].matches("FOR") &&
                word[4].matches("RESULT") && word[5].matches("SET") && word[6].equals(word[6]) &&
                grammar.endsWith(";")){
            System.out.println("Valid Statement.\n");
            System.out.println(grammar+"\n");
            System.out.println("< allocate cursor statement > ::= ALLOCATE < extended cursor name > [ INSENSITIVE ] [ SCROLL ] CURSOR FOR < extended statement name > ;\n");
            System.out.println("Parse Tree\n---------");
            System.out.println("< allocate cursor statement > ::= ALLOCATE CURSOR < allocate cursor statement >\n" +
                    "└── < allocate cursor statement > ::= ALLOCATE < extended cursor name > [ INSENSITIVE ] [ SCROLL ] CURSOR FOR < extended statement name >\n" +
                    "    ├── < extended cursor name > ::= [ < scope option > ] < simple value specification >\n" +
                    "    │   └── < scope option > ::= GLOBAL | LOCAL\n" +
                    "    └── < extended statement name > ::= [ < scope option > ] < simple value specification >\n" +
                    "        └── < scope option > ::= GLOBAL | LOCAL\n");
            System.out.println("Done Syntax analysis.");
            Semantic semantic = new Semantic();
            return 1;
        }
        else {
            if (grammar.contains("OPEN"))
                System.out.println("Syntax Error. An allocated cursor cannot be opened with the OPEN statement.\n");
            if (grammar.contains("DELETE") || grammar.contains("UPDATE"))
                System.out.println("Syntax Error. An allocated cursor cannot be used in a positioned UPDATE or DELETE statement\n");
            if (grammar.contains("CLOSE"))
                System.out.println("Syntax Error. An allocated cursor can be closed with the CLOSE statement. Closing an allocated cursor closes the associated cursor.\n");
            if(!grammar.endsWith(";"))
                System.out.println("Syntax Error. Grammar must ends with semicolon.");
            else
                System.out.println("Syntax Error. Your grammar is wrong.");
            return 0;
        }
    }
}
