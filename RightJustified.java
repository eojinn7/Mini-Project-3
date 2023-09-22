/*
 * Builds a new block that aligns TextBlock to the right of a given width.
 * 
 * @author Jinny Eo
 */


public class RightJustified implements TextBlock {
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
  * Build a new block and align to the right in the space of this.width
  */
  public RightJustified(TextBlock myblock, int width) {
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
    // check is row num is valid
    if (i < 0 || i >= this.height()) {
      throw new Exception("Invalid row " + i);
    }

    String content = this.myblock.row(i);

    // check if content is longer than given width
    if (content.length() > this.width) {
      throw new Exception("Please input width that is larger than width of original TextBlock");
    }
    // calculate needed spaces before the textblock
    int spacesNum = this.width - content.length();

    String spacesBefore = "";
    // adds spaces according to spacesNum
    for (int j = 0; j < spacesNum; j++) {
      spacesBefore += " ";
    }
    // add two strings together
    return spacesBefore += content;
  }

  /**
  * Determine how many rows are in the block.
  */
  public int height() {
    return myblock.height();
  }

  /**
  * Determine how many columns are in the block.
  */
  public int width() {
    return this.width;
  } // width()

}

