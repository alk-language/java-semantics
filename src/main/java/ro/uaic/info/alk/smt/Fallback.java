package ro.uaic.info.alk.smt;

interface Fallback<T extends SMTMethodSolver>
{
    T resolve();
}
