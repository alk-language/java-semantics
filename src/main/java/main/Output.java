package main;

import analysis.Analysis;
import impl.env.Environment;
import impl.exceptions.AlkWarning;

public class Output {

    public static void printAll(Environment e) {
        System.out.println(e);
        printAlgorithmType();
        AlkWarning.printAll();
    }

    public static void printAlgorithmType() {
        if (Analysis.algorithm_type.equals("probabilist"))
            System.out.println("The probability for this execution is: " + Analysis.probability);
        else if (Analysis.algorithm_type.equals("nedeterminist"))
            System.out.println("Note that the executed algorithm is nondeterministic.");
    }

}
