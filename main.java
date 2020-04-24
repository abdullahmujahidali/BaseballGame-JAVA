import java.util.Scanner;
import java.util.Random;

public class main {

   public static main(String[] args) {
       BaseballGame game = new BaseballGame();
      
       game.setName(0,"TeamA");
       game.setName(1,"TeamB");
      
       Random rand = new Random();
       for(int team = 0; team < 2; team++)
           for(int inning = 0; inning < 9; inning++)
               game.setScore(team, inning, rand.nextInt());
      
       int scoreA, scoreB;
       scoreA = 0;
       scoreB = 0;
       for(int inning = 0; inning < 9; inning++)
           scoreA += game.getScore(0, inning);
       for(int inning = 0; inning < 9; inning++)
           scoreB += game.getScore(1, inning);
      
       if(scoreA == scoreB)
           System.out.println("Tie");
       else if(scoreA > scoreB)
           System.out.println(game.getName(0)+"wins!");
       else if(scoreA < scoreB)
           System.out.println(game.getName(1)+"wins!");
   }

}


public class BaseballGame {
   protected String[] names = new String[2];
   protected int[][] scores;
   protected int innings;

   public BaseballGame() {
       innings = 9;
       scores = new int[2][9];
       for(int i = 0; i < 9; i++)
           scores[1][i] = scores[0][i] = -1;
   }
  
   public String getName(int team) {
       return names[team];
   }

   public void setNames(int team, String name) {
       names[team] = name;
   }
  
   public int getScore(int team, int inning) throws Exception {
       if(team < 0 || team >= 2)
           throw new Exception("Team is ut of bounds.");
       if(inning < 0 || inning >= innings)
           throw new Exception("Inning is ut of bounds.");
      
       return scores[team][inning];
   }

   public void setScores(int team, int inning, int score) throws Exception {
       if(team < 0 || team >= 2)
           throw new Exception("Team is ut of bounds.");
       if(inning < 0 || inning >= innings)
           throw new Exception("Inning is ut of bounds.");
       if(score < 0)
           throw new Exception("Score is ut of bounds.");
       for(int i = 0; i < inning; i++)
           if(scores[team][i] == -1)
               throw new Exception("Previous scores are not set.");
      
       scores[team][inning] = score;
   }
  
}


public class HighSchoolBaseballGame extends BaseballGame {

   public HighSchoolBaseballGame() {
       innings = 7;
       scores = new int[2][7];
       for(int i = 0; i < 7; i++)
           scores[1][i] = scores[0][i] = -1;
   }

}


public class LittleLeagueBaseballGame extends BaseballGame {

   public LittleLeagueBaseballGame() {
       innings = 6;
       scores = new int[2][6];
       for(int i = 0; i < 6; i++)
           scores[1][i] = scores[0][i] = -1;
   }

}
