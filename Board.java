import java.util.SortedSet;
import java.util.TreeSet;

public class Board {
    private Num[][] board;
    private int[] nextAvailable;
    private SortedSet<Integer> set= new TreeSet<Integer>();


    public Board(){
        board= new Num[7][5];
        nextAvailable= new int[5];
    }

    public void addNum(Num item, int col){
        set.add(item.getAmount());
        board[nextAvailable[col]][col]= item;
        nextAvailable[col]+=1;
        minimizeBoard(col);
    }

    private void minimizeBoard(int start) {
        int i=nextAvailable[start]-1, j=start;
        while (i<7){
            Num a= board[i][j];
            if (a==null){
                j++;
                if (j>4){
                    j=0; i++;
                }
                continue;
            }
            int[][] neighbors= {{i-1, j}, {i-1, j}, {i, j-1}, {i, j+1}};
            int matches=0;
            for (int[] item: neighbors){
                if (item[0]>=0 && item[1]>=0 && item[0]<7 && item[1]<5){
                    Num temp= board[item[0]][item[1]];
                    if (temp!= null){
                        if (a.getAmount()== temp.getAmount()){
                            matches++;
                            board[item[0]][item[1]]=null;
                            nextAvailable[item[1]]-=1;
                        }
                    }
                }
            }
            if (matches>0){
                board[i][j].multiply(matches);
                set.add(board[i][j].getAmount());
                orderBoard();
                minimizeBoard(j);
                i=0; j=0;
            }
            else{
                j++;
                if (j>4){
                    j=0; i++;
                }
            }
        }
    }

    private void orderBoard() {
        for (int i=0; i<5; i++){
            for (int j=0; j<7; j++){
                if (board[j][i]==null){
                    if (j+1<7){
                        board[j][i]= board[j+1][i];
                        board[j+1][i]=null;
                    }
                }
            }
        }
    }

    public void printBoard(){
        for (Num[] x: board){
            for (Num y: x){
                if (y!=null){
                    System.out.print(y.getAmount()+"\t");
                }
                else{System.out.print("NULL\t");}
            }
            System.out.println();
        }
    }

    public int largestTile(){
        return set.last();
    }

    public void delete(int check) {
        for (int i=0; i<5; i++){
            for (int j=0; j<7; j++){
                if (board[j][i]==null || board[j][i].getAmount()==check){
                    if (j+1<7){
                        board[j][i]= board[j+1][i];
                        board[j+1][i]=null;
                    }
                }
            }
        }
        minimizeBoard(0);
    }
    

}
