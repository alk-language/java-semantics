package ro.uaic.info.alk.ast.attr;


public class IdASTAttr
extends ASTAttr
{
    private String text;

    public IdASTAttr(String text)
    {
        this.text = text;
    }

    public String getId()
    {
        return text;
    }

   public void setId(String text)
   {
      this.text = text;
   }
}
