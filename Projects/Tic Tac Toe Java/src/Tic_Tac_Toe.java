import java.util.Scanner;

public class Tic_Tac_Toe {
    private Player player1,player2;
    private Board board;

    public void startGame(){
        Scanner sc=new Scanner(System.in);

        //players input
        player1=takePlayerInput(1);
        player2=takePlayerInput(2);
        while(player1.getSymbol()==player2.getSymbol()){
            System.out.println("this symbol is already taken : ");
            String tsymbol=sc.next();
            char symbol=tsymbol.charAt(0);
            player2.setSymbol(symbol);
        }

        //create board
        board =new Board(player1.getSymbol(), player2.getSymbol());

        //conduct a game
        int status=board.INCOMPLETE;
        boolean player1Turn=true;

        while(status==board.INCOMPLETE || status==board.INVALID){
            if(player1Turn){
                System.out.println("player 1 : "+player1.getName()+"'s turn");
                System.out.println("Enter row number :");
                int row=sc.nextInt();
                System.out.println("Enter column number :");
                int col=sc.nextInt();
                status=board.move(player1.getSymbol(),row,col);
//                if(status==board.PLAYER1_WINS || status==board.PLAYER2_WINS || status==board.DRAW){
//                    break;
//                }
                if(status!=board.INVALID){
                    player1Turn=false;
                    board.print();
                }
                else{
                    System.out.println("Invalid Move !! Try Again !!");
                }
            }
            else{
                System.out.println("player 2 : "+player2.getName()+"'s turn");
                System.out.println("Enter row number :");
                int row=sc.nextInt();
                System.out.println("Enter column number :");
                int col=sc.nextInt();
                status=board.move(player2.getSymbol(),row,col);
//                if(status==board.PLAYER1_WINS || status==board.PLAYER2_WINS || status==board.DRAW){
//                    break;
//                }
                if(status!=board.INVALID){
                    player1Turn=true;
                    board.print();
                }
                else{
                    System.out.println("Invalid Move !! Try Again !!");
                }
            }
        }

        if(status==board.PLAYER1_WINS){
            System.out.println("Player 1 : "+player1.getName()+" Wins !!");
        }
        else if(status==board.PLAYER2_WINS){
            System.out.println("Player 2 : "+player2.getName()+" Wins !!");
        }
        else{
            System.out.println("DRAW !! ");
        }

    }

    public Player takePlayerInput(int num){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter player "+num+" name :");
        String name=sc.nextLine();

        System.out.println("enter player "+num+" symbol :");
        String tsymbol=sc.next();
        char symbol=tsymbol.charAt(0);

        Player p=new Player(name,symbol);

        return p;
    }


}
