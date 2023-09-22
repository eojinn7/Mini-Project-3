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
  // make an array for each row of the content
  String[] rows = new String[this.height()];
  for (int j = 0; j < this.height(); j++) {
    rows[j] = this.myblock.row(j);
  } 

  // reverse order by use of indices
  int length = rows.length;
  for (int beg = 0; beg < length / 2; beg++) {
      int end = length - beg - 1;
      String temp = rows[beg];
      rows[beg] = rows[end];
      rows[end] = temp;
  }
  // return array into String
  return rows[i].toString();
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