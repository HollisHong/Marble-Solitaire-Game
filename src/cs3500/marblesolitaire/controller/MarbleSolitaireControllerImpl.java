package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;


/**
 * represents a controller class to let user control the game.
 * The user will gave the fromRow, fromCol, toRow, toCol to move the game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Readable rd;
  private final Appendable ap;

  /**
   * the constructor accepts and stores the objects for doing input and output.
   * @param rd any input coming from the user will be received via the Readable object
   * @param ap any output sent to the user should be written to the Appendable object
   * @throws IllegalArgumentException when either rd or ap is null
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Either of its arguments are null");
    }
    this.rd = rd;
    this.ap = ap;
  }


  @Override
  public void playGame(MarbleSolitaireModel model) {
    if (model == null) {
      throw new IllegalArgumentException("a null model is passed");
    }

    int i = 0;
    ArrayList<Integer> ints = new ArrayList<Integer>();
    Scanner scan = new Scanner(this.rd);

    try {
      this.ap.append(model.getGameState()
              + String.format("\nScore: %d\n", model.getScore()));
    } catch (IOException e) {
      throw new IllegalStateException("Appendable unable to transmit output " +
              "or Readable unable to provide inputs");
    }

    while (!model.isGameOver() && scan.hasNext()) {
      String str = scan.next();
      if (str.equals("q") || str.equals("Q")) {
        try {
          this.ap.append("Game quit!\nState of game when quit:\n" + model.getGameState()
                  + "\n" + "Score: " + model.getScore() + "\n");
        } catch (IOException e) {
          throw new IllegalStateException("Appendable unable to transmit output " +
                  "or Readable unable to provide inputs");
        }
        return;
      } else {
        try {
          ints.add(Integer.parseInt(str) - 1);
          i++;
        } catch (Exception e) {
          try {
            ap.append("Invalid input.\n" + e.getMessage() + "\n");
          } catch (IOException ee) {
            throw new IllegalStateException("Appendable unable to transmit output " +
                    "or Readable unable to provide inputs");
          }
        }

        if (i == 4) {
          try {
            model.move(ints.get(0), ints.get(1), ints.get(2), ints.get(3));
          } catch (Exception e) {
            try {
              ap.append("Invalid move. Play again. " + e.getMessage() + "\n");
            } catch (IOException ee) {
              throw new IllegalStateException("Appendable unable to transmit output " +
                      "or Readable unable to provide inputs");
            }
          }

          try {
            this.ap.append(model.getGameState()
                    + String.format("\nScore: %d\n", model.getScore()));
          } catch (IOException e) {
            throw new IllegalStateException("Appendable unable to transmit output " +
                    "or Readable unable to provide inputs");
          }

          i = 0;
          ints = new ArrayList<Integer>();
        }
      }
    }
    if (!model.isGameOver()) {
      throw new IllegalStateException("No more input but the game is not over");
    }

    try {
      this.ap.append("Game over!\n" + model.getGameState()
              + String.format("\nScore: %d\n", model.getScore()));
    } catch (IOException e) {
      throw new IllegalStateException("Appendable unable to transmit output " +
              "or Readable unable to provide inputs");
    }
  }


  public static void main(String[] args) {
    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
            .playGame(new TriangleSolitaireModelImpl(5, 0, 0));
  }


}
