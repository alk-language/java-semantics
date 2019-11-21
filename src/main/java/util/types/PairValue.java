package util.types;

import parser.types.alkInt.AlkInt;

import java.math.BigDecimal;
import java.util.Iterator;

public class PairValue extends Value implements Iterable<AlkInt> {

    private AlkInt left, right;

    public PairValue(AlkInt left, AlkInt right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Iterator<AlkInt> iterator() {
        return new PairValueIterator();
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
