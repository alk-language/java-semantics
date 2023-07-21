package ro.uaic.info.alk.preproc;

public class AlkPreprocessor
extends PreprocessorQueue
{
   public AlkPreprocessor()
   {
      this.add(new AlkIncludePreprocessor());
      this.add(new AlkMainGatherer(true));
      this.add(new AlkSpecificationBinding());
   }
}
