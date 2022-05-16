import java.util.Random;
import java.util.SortedSet;

public class PlayableTiles {
    public Num[] tiles= new Num[6];

    public PlayableTiles(){
        tiles[0]= new Num();
        for (int i=1; i<6; i++){
            Num temp= new Num();
            temp.multiply(i);
            tiles[i]= temp;
        }
    }

    public int getRandomTile(){
        Random random= new Random();
        int num= random.nextInt(6);
        return tiles[num].getAmount();
    }

    public int growTilePile(int largest){
        if (largest > ((tiles[5].getAmount())*4)){
            System.out.println("true");
            Num next= new Num(tiles[5].getAmount());
            next.multiply(1);
            for (int i=0; i<5; i++){
                tiles[i]= tiles[i+1];
            }
            tiles[5]= next;
            return tiles[0].getAmount();
        }
        return 0;
    }

    public void printTiles(){
        int i=0;
        while (i<6){
            System.out.println(tiles[i].getAmount());
            i++;
        }
    }
}