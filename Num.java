import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

/**
An Object that holds information for a number item in the game board.

@author Valeria Garcia
 */
public class Num{

    private int value, index=0;
    private Color col;

    public enum Color{BLUE, RED, GREEN, PINK, YELLOW, 
    ORANGE};

    private Color[] colors={Color.BLUE, Color.RED, Color.GREEN, Color.PINK, Color.YELLOW, 
    Color.ORANGE};

    private Map<Integer, Color> key= new HashMap<Integer, Color>();


    public Num(){
        value=1;
        col= colors[index];
        key.put(value, col);
    }

    public Num(int v){
        value= v;
        col= key.get(v);
    }


    /**
     * Transforms number to new amount properties.
     * @param amount This is the amount of identical neighbors a number has.
     */
    public void multiply(int amount){
        value= value* (int)Math.pow(2, amount);
        if (key.get(value)== null){
            index+=1;
            index%=6;
            col= colors[index];
            key.put(value, col);
        }
        else{
            col= key.get(value);
        }
    } // 1 2 4 8 16 32 64

    /**
     * Returns the value of the number object.
     * @return int
     */
    public int getAmount(){
        return value;
    }

    /**
     * Returns the value of the number object
     * @return int
     */
    public Color getColor(){
        return col;
    }
}