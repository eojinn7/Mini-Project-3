/*
 * Builds a new block that flips the content of the TextBlock horizontally
 * 
 * @author Jinny Eo
 */


public class HorizontallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
// | Fields |
// +--------+

/**
* Contents of block
*/
TextBlock myblock;

// +--------------+------------------------------------------------------
// | Constructors |
// +--------------+

/**
* Build a new block that reverses the order of ch
*/
public HorizontallyFlipped(TextBlock myblock) {
  this.myblock = myblock;
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
  String newContent = "";
  for (int j = content.length() - 1; j >= 0; j--) {
    newContent += content.charAt(j);
  }

  return newContent;
}

/**
* Determine how many rows are in the block.
*/
public int height() {
  return this.myblock.height();
}

/**
* Determine how many columns are in the block.
*/
public int width() {
  return this.myblock.width();
} // width()

}

