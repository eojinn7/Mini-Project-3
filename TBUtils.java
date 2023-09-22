import java.io.PrintWriter;
import org.w3c.dom.Text;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

   /**
   * Determine whether two TextBlocks are equal depending on their content (the same lines)
   * @throws Exception
   */
  public static boolean equal(TextBlock t1, TextBlock t2) throws Exception {
    // check equality of two instances
    if (t1 == t2) {
      return true;
    }
    
    // compare height and width
    if (t1.height() != t2.height() || t1.width() != t2.width()){
      return false;
    }

    // prepare greater variable to prepare to compare each row
    int greater = 0;
    if (t1.height() > t2.height() || t1.height() == t2.height()) {
      greater = t1.height();
    }
    else {
      greater = t2.height();
    }

    // compare rows of t1 and t2
    for (int i = 0; i < greater; i++) {
      if (!t1.row(i).equals(t2.row(i))) {
        return false;
      }
    }

    return true;
  }

     /**
   * Determine whether two TextBlocks are equal depending on how they are constructed
   * @throws Exception
   */
  public static boolean eqv(TextBlock t1, TextBlock t2) throws Exception {

    // checks whether they are both an instance of TextBlock
    if ((t1 instanceof TextBlock) != (t2 instanceof TextBlock)) {
      return false;
    }

    // check if they're the same class
    if (t1.getClass() != t2.getClass()) {
      return false;
    }

    return true;
  }

     /**
   * Determine whether two TextBlocks are equal depending on their memory location
   * @throws Exception
   */
  public static boolean eq(TextBlock t1, TextBlock t2) {
    // the two objects are equal if they have the same memory location
    return t1 == t2;
  }

} // class TBUtils