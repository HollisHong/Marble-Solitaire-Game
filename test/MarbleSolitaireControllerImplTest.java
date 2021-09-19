
import org.junit.Test;

import java.io.StringReader;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static org.junit.Assert.assertEquals;



/**
 * represents a test class for MarbleSolitaireController.
 */
public class MarbleSolitaireControllerImplTest {

  MarbleSolitaireModelImpl mar1;
  MarbleSolitaireModelImpl mar2;
  MarbleSolitaireModelImpl mar3;
  MarbleSolitaireModelImpl mar4;
  MarbleSolitaireModelImpl mar5;

  /**
   * init the data we need to use for test.
   */
  public void init() {
    mar1 = new MarbleSolitaireModelImpl();
    mar2 = new MarbleSolitaireModelImpl(4, 3);
    mar3 = new MarbleSolitaireModelImpl(9);
    mar4 = new MarbleSolitaireModelImpl(9, 10, 10);
    mar5 = new MarbleSolitaireModelImpl(1);

  }

  // test if the game works well and quit with a "Q".
  @Test
  public void testPlayGame() {
    this.init();
    Readable rd = new StringReader("4 6 4 4 Q");
    Appendable ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", ap.toString());
  }

  // test if the game works well and quit with a "q".
  @Test
  public void testPlayGame0() {
    this.init();
    Readable rd = new StringReader("4 6 4 4 4 3 4 5 q");
    Appendable ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O _ _ O _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n", ap.toString());
  }

  // test the game will quit when fromRow is "q"
  @Test
  public void testPlayGame1() {
    this.init();
    Readable rd = new StringReader("q");
    Appendable ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", ap.toString());
  }

  // test the game will quit when fromRow is "q" and four valid numbers behind.
  @Test
  public void testPlayGame2() {
    this.init();
    Readable rd = new StringReader("q 1 2 3 4");
    Appendable ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", ap.toString());
  }

  // test the game will quit when fromCol is "q".
  @Test
  public void testPlayGame3() {
    this.init();
    Readable rd = new StringReader("1 q 1 2 3 4");
    Appendable ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", ap.toString());
  }


  // test the game will quit when toRow is "q".
  @Test
  public void testPlayGame4() {
    this.init();
    Readable rd = new StringReader("1 2 q 3 4 5 6");
    Appendable ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", ap.toString());
  }

  // test the game will quit when toCol is "q".
  @Test
  public void testPlayGame5() {
    this.init();
    Readable rd = new StringReader("1 2 3 q 4 ");
    Appendable ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", ap.toString());
  }

  // test if the game stop when no move is available.
  @Test
  public void testPlayGame6() {
    this.init();
    Readable rd = new StringReader("4 2 4 4 4 5 4 3 2 5 4 5 2 4 4 4 3 2 3 4 5 3 3 3 4 5 4 3 " +
            "3 3 5 3 6 4 4 4 5 2 5 4 5 5 5 3 4 4 2 4 2 3 2 5 1 5 3 5 3 6 3 4 6 3 4 3 5 7 5 5 " +
            "6 5 4 5 4 6 4 4 1 3 1 5 4 3 4 5 3 7 5 7");
    Appendable ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O _ _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O O O O _ O O\n" +
            "O _ O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O _ _ O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O _ _ O _ O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O _ O O _ O O\n" +
            "O _ _ O O O O\n" +
            "O O _ O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O _ O O _ O O\n" +
            "O _ O _ _ O O\n" +
            "O O _ O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 25\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O _ _ O _ O O\n" +
            "O _ _ _ _ O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 24\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O _ _ O _ O O\n" +
            "O _ _ O _ O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 23\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O _ _ O _ O O\n" +
            "O _ _ O _ O O\n" +
            "O _ _ O O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 22\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O _ _ O _ O O\n" +
            "O _ _ O _ O O\n" +
            "O _ O _ _ O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 21\n" +
            "    O O O\n" +
            "    O O _\n" +
            "O _ _ _ _ O O\n" +
            "O _ _ _ _ O O\n" +
            "O _ O _ _ O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 20\n" +
            "    O O O\n" +
            "    _ _ O\n" +
            "O _ _ _ _ O O\n" +
            "O _ _ _ _ O O\n" +
            "O _ O _ _ O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 19\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ _ O O O\n" +
            "O _ _ _ _ O O\n" +
            "O _ O _ _ O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 18\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "O _ _ _ _ O O\n" +
            "O _ O _ _ O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 17\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "O _ O _ _ O O\n" +
            "O _ _ _ _ O O\n" +
            "    _ _ O\n" +
            "    O O O\n" +
            "Score: 16\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "O _ O _ _ O O\n" +
            "O _ _ _ O _ _\n" +
            "    _ _ O\n" +
            "    O O O\n" +
            "Score: 15\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "O _ O _ O O O\n" +
            "O _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 14\n" +
            "    O O _\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "O _ O O _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 13\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "O _ O O _ _ O\n" +
            "O _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 12\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ O\n" +
            "O _ _ _ O _ O\n" +
            "O _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 11\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ _\n" +
            "O _ _ _ O _ _\n" +
            "O _ _ _ _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 10\n" +
            "Game over!\n" +
            "    _ _ O\n" +
            "    _ _ _\n" +
            "O _ _ O _ _ _\n" +
            "O _ _ _ O _ _\n" +
            "O _ _ _ _ _ O\n" +
            "    _ _ _\n" +
            "    O O O\n" +
            "Score: 10\n", ap.toString());
  }

  @Test
  public void testPlayGame7() {
    this.init();
    Readable rd = new StringReader(" a 4 6 4 4 Q");
    Appendable ap = new StringBuffer();
    new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid input.\n" +
            "For input string: \"a\"\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", ap.toString());
  }

  // test if a exception will be thrown when Readable is null.
  @Test
  public void testException() {
    this.init();
    Readable rd = null;
    Appendable ap = new StringBuffer();
    try {
      new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    } catch (IllegalArgumentException e) {
      assertEquals("Either of its arguments are null", e.getMessage());
    }
  }

  // test if a exception will be thrown when Appendable is null.
  @Test
  public void testException1() {
    this.init();
    Readable rd = new StringReader("");
    Appendable ap = null;
    try {
      new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    } catch (IllegalArgumentException e) {
      assertEquals("Either of its arguments are null", e.getMessage());
    }
  }

  // test if a exception will be thrown when Readable and Appendable are both null.
  @Test
  public void testException2() {
    this.init();
    Readable rd = null;
    Appendable ap = null;
    try {
      new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    } catch (IllegalArgumentException e) {
      assertEquals("Either of its arguments are null", e.getMessage());
    }
  }

  // test if a exception will be thrown when no more input but the game is not over.
  @Test
  public void testException3() {
    Readable rd = new StringReader("4 3 ");
    Appendable ap = new StringBuffer();
    try {
      new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    } catch (IllegalStateException e) {
      assertEquals("No more input but the game is not over", e.getMessage());
    }
  }


  // test if a exception will be thrown when a null mode is passed into.
  @Test
  public void testException4() {
    this.init();
    MarbleSolitaireModel m1 = null;
    Readable rd = new StringReader("4 3 ");
    Appendable ap = new StringBuffer();
    try {
      new MarbleSolitaireControllerImpl(rd, ap).playGame(m1);
    } catch (IllegalArgumentException e) {
      assertEquals("a null model is passed", e.getMessage());
    }
  }

  // test if a exception will be thrown when Appendable is unable to transmit output.
  @Test
  public void testException5() {
    this.init();
    Readable rd = new StringReader("4 3 ");
    Appendable ap = new FailingAppendable();
    try {
      new MarbleSolitaireControllerImpl(rd, ap).playGame(mar1);
    } catch (IllegalStateException e) {
      assertEquals("Appendable unable to transmit output or " +
              "Readable unable to provide inputs", e.getMessage());
    }
  }
}
