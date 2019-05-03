public class TicTacToeModel {
  boolean isGameOver(String[] tileTexts, boolean[] isClicked){
    boolean isGameOver = false;
    if(isClicked[0]){
      if(((tileTexts[0] == tileTexts[1]) && (tileTexts[1] == tileTexts[2])) || ((tileTexts[0] == tileTexts[3]) && (tileTexts[3] == tileTexts[6])) || ((tileTexts[0] == tileTexts[4]) && (tileTexts[4] == tileTexts[8]))){
        isGameOver = true;
      }
    }
    if(isClicked[1]){
      if((tileTexts[1] == tileTexts[4]) && (tileTexts[4] == tileTexts[7])){
        isGameOver = true;
      }
    }
    if(isClicked[2]){
      if(((tileTexts[2] == tileTexts[5]) && (tileTexts[5] == tileTexts[8])) || ((tileTexts[2] == tileTexts[4]) && (tileTexts[4] == tileTexts[6]))){
        isGameOver = true;
      }
    }
    if(isClicked[3]){
      if((tileTexts[3] == tileTexts[4]) && (tileTexts[4] == tileTexts[5])){
        isGameOver = true;
      }
    }
    if(isClicked[6])
      if((tileTexts[6] == tileTexts[7]) && (tileTexts[7] == tileTexts[8])){
        isGameOver = true;
      }
    return isGameOver;
  }
}