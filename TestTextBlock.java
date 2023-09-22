import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for procedures in Mini Project 3
 * 
 * @author Jinny Eo
 */

public class TextBlockTests {
  private TextBlock originalBlock;

  @BeforeEach
  void prepare() {
    content = new TextBlock();
      public String row (int i) throws Exception {
        if (i <= 0 || i > 2) {
          throw new Exception("Invalid row " + i);
        }
        return row(i);
      }



       public int height() {
        return 2;
      }

      public int width() {
       return 6;
      }

    }
  }


