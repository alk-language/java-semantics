package util.types;

import parser.env.Location;
import parser.env.LocationMapper;
import parser.exceptions.AlkException;
import execution.types.alkInt.AlkInt;
import util.lambda.LocationGenerator;

import java.util.Iterator;

public class IntervalValue implements Value, Iterable<AlkInt> {

    private AlkInt left, right;

    public IntervalValue(AlkInt left, AlkInt right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Iterator<AlkInt> iterator() {
        return new PairValueIterator();
    }

    @Override
    public Value clone(LocationGenerator locationGenerator) {
        return new IntervalValue((AlkInt) left.clone(locationGenerator), (AlkInt) right.clone(locationGenerator));
    }

    @Override
    public Value weakClone(LocationMapper locationMapper) {
        return new IntervalValue((AlkInt) left.weakClone(locationMapper), (AlkInt) right.weakClone(locationMapper));
    }

    @Override
    public Value toRValue() {
        return this;
    }

    @Override
    public Location toLValue() {
        throw new AlkException("Can't obtain a reference out of this expression");
    }

    class PairValueIterator implements Iterator<AlkInt> {

        private AlkInt index = left;

        public boolean hasNext() {
            return index.lowereq(right).isTrue();
        }

        public AlkInt next() {
            // TODO: reimplement after post ++ is implemented
            AlkInt value = index;
            index = (AlkInt) index.add(new AlkInt(1));
            return value;
        }
    }
}
