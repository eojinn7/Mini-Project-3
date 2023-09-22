/*
 * Builds a new block that flips the content of the Texblock vertically
 * 
 * @author Jinny Eo
 */


public class VerticallyFlipped implements TextBlock {
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
* Build a new block and flip the content vertically (reverse order of row)
*/
public VerticallyFlipped(TextBlock myblock) {
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
int rowNum = this.height();
return this.myblock.row(rowNUm - 1 - i);
  
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
