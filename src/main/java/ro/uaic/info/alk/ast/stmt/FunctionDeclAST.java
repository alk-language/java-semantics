package ro.uaic.info.alk.ast.stmt;

import ro.uaic.info.alk.ast.AST;
import ro.uaic.info.alk.ast.ASTContext;
import ro.uaic.info.alk.ast.attr.ParamASTAttr;
import ro.uaic.info.alk.ast.type.DataTypeAST;
import org.antlr.v4.runtime.ParserRuleContext;
import ro.uaic.info.alk.ast.attr.IdASTAttr;
import ro.uaic.info.alk.util.functions.Parameter;
import ro.uaic.info.alk.visitor.ifaces.VisitorIface;
import ro.uaic.info.alk.visitor.ifaces.stmt.FunctionDeclVisitorIface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionDeclAST
extends StmtAST
{
    private final List<AST> requires = new ArrayList<>();
    private final List<AST> ensures = new ArrayList<>();
    private DataTypeAST dataType;

    public FunctionDeclAST(ASTContext ctx)
    {
        super(ctx);
    }

    @Override
    public <T> T accept(VisitorIface<T> visitor)
    {
        if (visitor instanceof FunctionDeclVisitorIface)
            return ((FunctionDeclVisitorIface<T>) visitor).visit(this);
        return super.accept(visitor);
    }

    public void addRequires(AST expr)
    {
        if (getChildCount() != 0)
        {
            this.children.add(getChildCount() - 1, expr);
        }
        requires.add(expr);
    }

    public void addEnsures(AST expr)
    {
        if (getChildCount() != 0)
        {
            this.children.add(getChildCount() - 1, expr);
        }
        ensures.add(expr);
    }

    public void setDataType(DataTypeAST dataType)
    {
        this.dataType = dataType;
    }

    public AST getBody()
    {
        return getChildCount() == 0 ? null : getChild(getChildCount() - 1);
    }

    public List<AST> getRequires()
    {
        return requires;
    }

    public List<AST> getEnsures()
    {
        return ensures;
    }

    public DataTypeAST getDataType()
    {
        return dataType;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(getAttribute(IdASTAttr.class).getId());
        sb.append("(");

        ParamASTAttr attr = this.getAttribute(ParamASTAttr.class);
        List<Parameter> uses = new ArrayList<>();
        List<Parameter> modifies = new ArrayList<>();

        boolean first = true;

        for (int i = 0 ; i < attr.getParamCount(); i++)
        {
            Parameter param = attr.getParameter(i);
            String text = null;
            switch (param.getType())
            {
                case INPUT: text = param.getName(); break;
                case OUTPUT: text = "out " + param.getName(); break;
                case USES: uses.add(param); break;
                case MODIFIES: modifies.add(param); break;
            }

            if (text == null)
            {
                continue;
            }

            if (!first)
            {
                sb.append(", ");
            }
            else
            {
                first = false;
            }

            sb.append(text);
        }
        sb.append(")\n");
        // TODO toString doesn't include the param and \result types
        if (!uses.isEmpty())
        {
            sb.append("uses ");
            sb.append(uses.stream().map(Parameter::getName).collect(Collectors.joining(", ")));
            sb.append("\n");
        }
        if (!modifies.isEmpty())
        {
            sb.append("modifies ");
            sb.append(modifies.stream().map(Parameter::getName).collect(Collectors.joining(", ")));
            sb.append("\n");
        }
        for (AST req : requires)
        {
            sb.append(req).append("\n");
        }
        for (AST req : ensures)
        {
            sb.append(req).append("\n");
        }
        sb.append("{\n").append(getBody()).append("}");
        return sb.toString();
    }
}
