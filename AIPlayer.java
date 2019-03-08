import java.util.ArrayList;

/**
 *
 * @version
 * @author
 * @since
 */

public class AIPlayer extends Player{

  public AIPlayer(String name, Board board){
    super(name, board);
  }

  @Override
  protected void draft(){
    System.out.println("\n--------------- "+getPlayerName().toUpperCase()+"'S TURN ---------------");
    System.out.println("-----DRAFT-----");
  }

  @Override
  protected void attack(){
    System.out.println("-----ATTACK-----");

  }

  @Override
  protected void fortify(){
    System.out.println("-----FORTIFY-----");
  }


}
