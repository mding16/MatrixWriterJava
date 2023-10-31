import java.util.ArrayList;
import java.util.List;

public class MatrixWriter {
  Integer numCol;
  Integer numRow;
  Boolean hasConstant;
  String values;
  List<List<String>> contents;
  public MatrixWriter(Integer numCol, Integer numRow, Boolean hasConstant, String values){
    this.numCol = numCol;
    this.numRow = numRow;
    this.hasConstant = hasConstant;
    this.values = values;
    this.contents = new ArrayList<>();
    String[] listOfRows = this.values.split(";");
    for (int i=0; i<this.numRow; i++){
      this.contents.add(List.of(listOfRows[i].split(",")));
    }
  }
  public String getContents(){
    return this.contents.toString();
  }
  public String writeLatexMatrix(){
    String begin = "\\begin{bNiceArray}";
    String rowPattern = "";
    if (this.hasConstant) {
      rowPattern = "{" + "r".repeat(numCol-1) + "|" + "r" + "}";
    }
    else {
      rowPattern = "{" + "r".repeat(numCol) + "}";
    }
    String end = "\\end{bNiceArray}";
    String body = "";
    for (int i=0; i< numRow; i++){
      for (int j=0; j<numCol; j++){
        String val = this.contents.get(i).get(j);
        body = body + val;
        if (j!=numCol-1) { body += "&"; }
      }
      if (i!=numRow-1){body = body + "\\\\";}
    }
    return begin+rowPattern+body+end;
  }

  public String writeRREF(){
    String rref = "rref([";
    String end = "])";
    String body = "";
    for (int i=0; i< numRow; i++){
      for (int j=0; j<numCol; j++){
        String val = this.contents.get(i).get(j);
        body = body + val;
        if (j!=numCol-1) { body += ","; }
      }
      if (i!=numRow-1){body = body + ";";}
    }
    return rref + body + end;
  }
}
