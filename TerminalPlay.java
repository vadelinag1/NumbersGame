import java.util.Scanner;

public class TerminalPlay {
    public static void main(String[] args) {
        Board board= new Board();
        PlayableTiles tiles= new PlayableTiles();
        while (true){
            Scanner scan= new Scanner(System.in);
            int n= tiles.getRandomTile();
            System.out.println("Tile: "+ n);

            System.out.println("Choose column (0-4): ");
            String col= scan.nextLine();
            board.addNum(new Num(n), Integer.parseInt(col));
            int check= tiles.growTilePile(board.largestTile());
            if (check!=0){ board.delete(check);}
            board.printBoard();
            //tiles.printTiles();
        }
    }
}
