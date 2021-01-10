package ast;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

public class SimpleToken<T> implements Token {

    T value;
    int type;

    public SimpleToken(T value, int type)
    {
        this.value = value;
        this.type = type;
    }

    @Override
    public String getText() {
        return value.toString();
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public int getLine() {
        return -1;
    }

    @Override
    public int getCharPositionInLine() {
        return -1;
    }

    @Override
    public int getChannel() {
        return -1;
    }

    @Override
    public int getTokenIndex() {
        return -1;
    }

    @Override
    public int getStartIndex() {
        return 0;
    }

    @Override
    public int getStopIndex() {
        return 0;
    }

    @Override
    public TokenSource getTokenSource() {
        return null;
    }

    @Override
    public CharStream getInputStream() {
        return null;
    }
}
