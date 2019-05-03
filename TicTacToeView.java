import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToeView {
  TicTacToeModel model;
  JLabel[] labels;
  String tileText = "x";
  String[] tileTexts = new String[9];
  boolean[] isClicked = new boolean[9];
  boolean isGameOver = false;

  public TicTacToeView(TicTacToeModel model){
    this.model = model;

    SwingUtilities.invokeLater(
            new Runnable() {
              @Override
              public void run() {
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
                JPanel gameBoard = new JPanel();
                gameBoard.setLayout(new GridLayout(3,3));
                labels = new JLabel[9];

                for (int i = 0; i < labels.length; i++) {
                  labels[i] = new JLabel();
                  int tileNumber = i;

                  gameBoard.add(labels[i]);
                  labels[i].setPreferredSize(new Dimension(100,100));
                  labels[i].setFont(new Font("Font", Font.PLAIN, 80));
                  labels[i].setBorder(BorderFactory.createEtchedBorder());
                  labels[i].setHorizontalAlignment(SwingConstants.CENTER);
                  labels[i].addMouseListener(new MouseListener(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                      tileClicked(tileNumber);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                  });
                }

                JButton newGame = new JButton("New Game");
                newGame.setPreferredSize(new Dimension(400,50));
                newGame.setFont(new Font("Font", Font.PLAIN, 20));
                newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
                newGame.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e){
                    for(int i = 0; i < tileTexts.length; i++){ // sets everything back to its starting state
                      labels[i].setText("");
                      tileTexts[i] = "";
                      isClicked[i] = false;
                      tileText = "x";
                      isGameOver = false;
                    }
                  }
                });

                mainPanel.add(gameBoard);
                mainPanel.add(newGame);

                JFrame mainFrame = new JFrame();
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.getContentPane().add(mainPanel);
                mainFrame.pack();
                mainFrame.setVisible(true);
              }
            }
    );
  }

  void tileClicked(int tileNumber){
    if(isClicked[tileNumber]){
      return;
    }

    if(isGameOver){
      return;
    }

    if(tileText == "x"){ // the first player uses Xs
      labels[tileNumber].setText(tileText);
      tileTexts[tileNumber] = tileText;
      isClicked[tileNumber] = true;
      tileText = "o"; // makes it the second player's turn
    }
    else{ // the second player uses Os
      labels[tileNumber].setText(tileText);
      tileTexts[tileNumber] = tileText;
      isClicked[tileNumber] = true;
      tileText = "x"; // makes it the first player's turn
    }

    if(model.isGameOver(tileTexts, isClicked)){
      isGameOver = true;
    }
  }
}