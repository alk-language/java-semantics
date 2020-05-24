package util;

public interface AlgorithmTypeDetector {

    boolean isProbabilistic();

    boolean nonDeterministic();

    void setProbabilistic(boolean b);

    void setNonDeterministic(boolean b);

}
