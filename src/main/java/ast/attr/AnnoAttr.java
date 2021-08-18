package ast.attr;

import ast.enums.Anno;

import java.util.ArrayList;
import java.util.List;

public class AnnoAttr
extends ASTAttr
{
    private final List<Anno> annos = new ArrayList<>();

    public AnnoAttr()
    {
    }

    public void add(Anno anno)
    {
        annos.add(anno);
    }

    public List<Anno> getAnnos()
    {
        return annos;
    }
}
