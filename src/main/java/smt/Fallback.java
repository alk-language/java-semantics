package smt;

interface Fallback<T extends SMTMethodSolver>
{
    T resolve();
}
