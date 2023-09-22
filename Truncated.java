/*
 * Truncates a TextBlock to an indicated width.
 * 
 * @author Jinny Eo
 */

public class Truncated implements TextBlock {

      // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Contents of block
   */
  TextBlock myblock;
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by truncating according to width
   */
  public Truncated(TextBlock myblock, int width) {
    this.myblock = myblock;
    this.width = width;
  } // Truncated(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    if (i < 0 || i >= this.height()) {
      throw new Exception("Invalid row " + i);
  }

    String content = this.myblock.row(i);
    // Compare length of original text and width 
    if (content.length() > this.width) {
      // return the truncated
      return content.substring(0, this.width);
    }
    else if (content.length() < this.width) {
      // if width is larger than content length, then add spaces
      for (int j = 0; j < this.width - content.length(); j++) {
        content += " ";
      }
      return content;
    }
    else {
      return content;
    }
  }

    /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.myblock.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.myblock.width();
  } // width()

}