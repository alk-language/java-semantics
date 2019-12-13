package util;

import org.antlr.v4.runtime.tree.ParseTree;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CtxState {
    Class<? extends ParseTree> ctxClass();
}
