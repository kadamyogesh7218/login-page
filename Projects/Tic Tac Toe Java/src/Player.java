
public class Player {
    private String name;
    private char symbol;

    Player(String name,char symbol){
        this.name=name;
        this.symbol=symbol;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setSymbol(char symbol){
        this.symbol=symbol;
    }

    public char getSymbol(){
        return symbol;
    }


}
