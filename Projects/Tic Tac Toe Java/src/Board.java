
public class Board {
    private char [][] board;
    private int boardSize=3;
    private char p1symbol,p2symbol;
    private int count; //total no of moves till now

    public final static int PLAYER1_WINS=1;
    public final static int PLAYER2_WINS=2;
    public final static int DRAW=3;
    public final static int INCOMPLETE=4;
    public final static int INVALID=5;


    Board(char p1symbol,char p2symbol){
        board=new char[boardSize][boardSize];
        int n=boardSize;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]=' ';
            }
        }

        this.p1symbol=p1symbol;
        this.p2symbol=p2symbol;
    }

    public int move(char symbol,int row,int col){
        if(row<0 || row>=boardSize || col<0 || col>=boardSize || board[row][col]!=' '){
            return INVALID;
        }
        board[row][col]=symbol;
        count++;

        //check current row
        if(board[row][0]==board[row][1] && board[row][1]==board[row][2]){
            if(symbol==p1symbol){
                return PLAYER1_WINS;
            }
            return PLAYER2_WINS;
        }

        //check current column;
        if(board[0][col]==board[1][col] && board[1][col]==board[2][col]){
            if(symbol==p1symbol){
                return PLAYER1_WINS;
            }
            return PLAYER2_WINS;
        }

        //check first diagonal
        if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2]){
            if(symbol==p1symbol){
                return PLAYER1_WINS;
            }
            return PLAYER2_WINS;
        }

        //check second diagonal
        if(board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]){
            if(symbol==p1symbol){
                return PLAYER1_WINS;
            }
            return PLAYER2_WINS;
        }
        if(count==boardSize*boardSize){
            return DRAW;
        }
        return INCOMPLETE;
    }

    public void print(){
        System.out.println("-----------------");
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                System.out.print("| "+board[i][j]+" |");
            }
            System.out.println();
            System.out.println("-----------------");
        }

    }
}
