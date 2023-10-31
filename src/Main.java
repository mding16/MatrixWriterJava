import java.util.Scanner;

/**
 * USER INTERACTION IN TERMINAL
 * Remember to put this statement at the top of Latex
 * usepackage{nicematrix}
 */
public class Main {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    System.out.println("How many columns do you have?");
    Integer numCols = Integer.parseInt(myScanner.next());

    System.out.println("How many rows do you have?");
    Integer numRows = Integer.parseInt(myScanner.next());

    System.out.println("Does your matrix have a constant column? (true/false)");
    Boolean hasConstant = Boolean.parseBoolean(myScanner.next());

    System.out.println("Enter the matrix: (e.g. 1,1,1;0,0,0;1,1,1)");
    String matrix = myScanner.next();

    MatrixWriter myWriter = new MatrixWriter(numCols, numRows, hasConstant, matrix);

    System.out.println("Here is the latex for your matrix");
    System.out.println(myWriter.writeLatexMatrix());

    System.out.println("Here is the RREF formula for your matrix");
    System.out.println(myWriter.writeRREF());
  }
}