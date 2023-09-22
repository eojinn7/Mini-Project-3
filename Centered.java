/*
 * Builds a new block that centers text within a given width.
 * 
 * @author Jinny Eo
 */


public class Centered implements TextBlock {
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
   * Build a new block and center the text of the given TextBlock within width.
   */
  public Centered(TextBlock myblock, int width) {
    this.myblock = myblock;
    this.width = width;
  } // Centered(TextBlock, int)

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

    if (content.length() > this.width) {
      throw new Exception("Please input width that is larger than width of original TextBlock");
    }

    int spacesNum = this.width - content.length();
    int spaces1 = spacesNum / 2;
    int spaces2 = spacesNum - spaces1;

    // initialize the newContent as empty string
    String newContent = "";

    for (int j = 0; j < spaces1; j++) {
      newContent += " ";
    }
    // add the spaces before content
    newContent += content;

    for (int k = 0; k < spaces2; k++) {
      newContent += " ";
    }

    return newContent;

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
    return this.width;
  } // width()

}

