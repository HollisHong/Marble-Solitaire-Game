package cs3500.marblesolitaire.model.hw04;


import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.Grid;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * represent a ASolitaireModelImpl class which is a model contains all the data of the game. A
 * SolitaireModelImpl can be a MarbleSolitaireModelImp, EuropeanSolitaireModelImp,
 * TriangleSolitaireModelImpl and other later Models.
 */
public abstract class ASolitaireModelImpl implements MarbleSolitaireModel {

  protected ArrayList<ArrayList<Grid>> state;
  protected int arm;


  /**
   * create the graph of every marble.
   */
  protected void create() {
    int length = 3 * arm - 2;
    for (int i = 0; i < length; i++) {
      state.add(new ArrayList<Grid>());
      for (int q = 0; q < length; q++) {
        state.get(i).add(new Grid());
      }
      if (i < arm - 1 || i > arm * 2 - 2) {
        for (int q = 0; q < length; q++) {
          if (q < arm - 1 || q > arm * 2 - 2) {
            state.get(i).get(q).isValid = false;
          }
        }
      }
    }
  }

  /**
   * create the graph of every marble.
   */
  protected void create1() {
    int length = 3 * arm - 2;
    int a = arm - 1;
    int d = 2 - arm * 2;
    for (int i = 0; i < length; i++) {
      state.add(new ArrayList<Grid>());
      for (int q = 0; q < length; q++) {
        state.get(i).add(new Grid());
      }
      for (int q = 0; q < length; q++) {
        if (i < arm - 1) {
          for (int b = 0; b < a; b++) {
            state.get(i).get(b).isValid = false;
            state.get(i).get(length - 1 - b).isValid = false;
          }
        }
        if (i > arm * 2 - 2) {
          for (int c = 0; c < d; c++) {
            state.get(i).get(c).isValid = false;
            state.get(i).get(length - 1 - c).isValid = false;
          }
        }
      }
      a--;
      d++;
    }
  }


  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int length = 3 * arm - 2;
    if (fromRow < 0 || fromCol < 0 || fromRow >= length || fromCol >= length || toRow < 0
            || toCol < 0 || toRow >= length || toCol >= length) {
      throw new IllegalArgumentException("invalid(outbound) input given");
    }

    if (!(state.get(fromRow).get(fromCol).isValid && state.get(toRow).get(toCol).isValid)) {
      throw new IllegalArgumentException("from or to position is invalid");
    } else if (state.get(fromRow).get(fromCol).isEmpty) {
      throw new IllegalArgumentException("Need a marble at the “from” position");
    } else if (!(state.get(toRow).get(toCol).isEmpty)) {
      throw new IllegalArgumentException("Need a empty space at the “to” position");
    } else if (!(Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 0
            || (Math.abs(fromRow - toRow) == 0 && Math.abs(fromCol - toCol) == 2))) {
      throw new IllegalArgumentException(
              "the “to” and “from” positions need exactly two positions away");
    } else if (Math.abs(fromRow - toRow) == 2) {
      if (state.get((fromRow + toRow) / 2).get(fromCol).isEmpty) {
        throw new IllegalArgumentException("a marble needed between from and to");
      } else {
        state.get(fromRow).get(fromCol).isEmpty = true;
        state.get((fromRow + toRow) / 2).get(fromCol).isEmpty = true;
        state.get(toRow).get(fromCol).isEmpty = false;
      }
    } else if (Math.abs(fromCol - toCol) == 2) {
      if (state.get(fromRow).get((fromCol + toCol) / 2).isEmpty) {
        throw new IllegalArgumentException("a marble needed between from and to");
      } else {
        state.get(fromRow).get(fromCol).isEmpty = true;
        state.get(fromRow).get((fromCol + toCol) / 2).isEmpty = true;
        state.get(toRow).get(toCol).isEmpty = false;
      }

    }

  }

  @Override
  public boolean isGameOver() {
    boolean boo = true;
    int length = 3 * arm - 2;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (state.get(i).get(j).isValid && !(state.get(i).get(j).isEmpty)) {
          if (j < length - 2 && state.get(i).get(j + 1).isValid
                  && !(state.get(i).get(j + 1).isEmpty) && state.get(i).get(j + 2).isValid
                  && state.get(i).get(j + 2).isEmpty) {
            boo = false;
          }

          if (j > 1 && state.get(i).get(j - 1).isValid && !(state.get(i).get(j - 1).isEmpty)
                  && state.get(i).get(j - 2).isValid && state.get(i).get(j - 2).isEmpty) {
            boo = false;
          }

          if (i < length - 2 && state.get(i + 1).get(j).isValid
                  && !(state.get(i + 1).get(j).isEmpty) && state.get(i + 2).get(j).isValid
                  && state.get(i + 2).get(j).isEmpty) {
            boo = false;
          }

          if (i > 1 && state.get(i - 1).get(j).isValid && !(state.get(i - 1).get(j).isEmpty)
                  && state.get(i - 2).get(j).isValid && state.get(i - 2).get(j).isEmpty) {
            boo = false;
          }
        }
      }
    }
    return boo;
  }

  @Override
  public String getGameState() {
    String init = "";
    int length = 3 * arm - 2;
    if (state == null) {
      return "";
    }

    for (int i = 0; i < length; i++) {
      for (int g = 0; g < length; g++) {
        if (!(state.get(i).get(g).isValid)) {
          init = init + "  ";
        } else if (state.get(i).get(g).isEmpty) {
          if (g < length - 1 && state.get(i).get(g + 1).isValid) {
            init = init + "_ ";
          } else if (i == length - 1) {
            init = init + "_";
            break;
          } else {
            init = init + "_" + "\n";
            break;
          }
        } else if (!(state.get(i).get(g).isEmpty)) {

          if (g < length - 1 && state.get(i).get(g + 1).isValid) {
            init = init + "O ";
          } else if (i == length - 1) {
            init = init + "O";
            break;
          } else {
            init = init + "O" + "\n";
            break;
          }
        }
      }
    }
    return init;
  }

  @Override
  public int getScore() {
    int counter = 0;
    int length = arm * 3 - 2;
    for (int i = 0; i < length; i++) {
      for (int q = 0; q < length; q++) {
        if (state.get(i).get(q).isValid) {
          if (!(state.get(i).get(q).isEmpty)) {
            counter++;
          }
        }
      }
    }
    return counter;
  }
}
