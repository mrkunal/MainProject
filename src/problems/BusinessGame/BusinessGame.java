package problems.BusinessGame;

import java.util.ArrayList;
import java.util.Arrays;

public class BusinessGame {

    static Player bank=new Player("Bank ",0,5000.00);
    public static void main(String[] args) {

        String cells="J,H,T,H,E,T,H,T,H,J";
        String dices="2,2,1,4,4,2,4,4,2,2,2,1,4,4,2,2,2,1";
        int players=3;

        playGame(cells,dices,players);
    }


   static void playGame(String cells,String dices,int players){

        ArrayList<Cell> cellArrayList=createCells(cells);
        ArrayList<Player> playerArrayList=createPlayers(players);

        int length=cellArrayList.size();

        String[] diceMoves=dices.split(",");
        for(int i=0;i<length;i++)
        {
            for (Player player:playerArrayList
                 ) {

            player.setPosition(nextPosition(player.getPosition(), diceMoves[i++],length));
            checkMove(player,cellArrayList.get(player.getPosition()));

            }

        }

        playerArrayList.forEach(player -> System.out.println(player));

       System.out.println(bank);

    }

    static  ArrayList<Cell> createCells(String cells){

        ArrayList<Cell> cellArrayList=new ArrayList<>();

        for (String c:cells.split(",")) {

            Cell cell=null;
            switch (c){
                case "J": cell=new Cell(CellType.JAIL); break;
                case "H": cell=new Cell(CellType.HOTEL_SILVER); break;
                case "T": cell=new Cell(CellType.LOTTERY); break;
                case "E": cell=new Cell(CellType.EMPTY); break;

            }

            cellArrayList.add(cell);

        }
        return cellArrayList;
    }
    static ArrayList<Player> createPlayers(int player){
        ArrayList<Player> playerArrayList=new ArrayList<>();

        for(int i=1;i<=player;i++){

            playerArrayList.add(new Player("Player "+i,-1,1000));

        }
        return playerArrayList;
    }


    static  void checkMove(Player player,Cell cell){

        System.out.println("Before Player :"+player+" Cell :" + cell);
         switch (cell.getCellType())
         {

             case JAIL: bank.addAmount(player.deductAmount(150));break;
             case LOTTERY: player.addAmount(bank.deductAmount(200));break;
             case HOTEL_SILVER: computeHotel(cell,player); break;
             case HOTEL_GOLD: computeHotel(cell,player); break;
             case HOTEL_PLATINUM: computeHotel(cell,player); break;
             case EMPTY:break;
             default: new RuntimeException("Error occurred in Move");
         }

        System.out.println("After Player :"+player+" Cell :" + cell);

    }

    static  void computeHotel(Cell cell,Player player)
    {
        if(cell.getPlayer()!=null){

            if(cell.getPlayer()==player){

                switch (cell.getCellType()){
                    case HOTEL_SILVER: if(player.getAmount()>=100) {
                        bank.addAmount(player.deductAmount(100));
                        cell.setCellType(CellType.HOTEL_GOLD);
                        }break;
                    case HOTEL_GOLD:
                         if(player.getAmount()>=200) {
                             bank.addAmount(player.deductAmount(200));
                             cell.setCellType(CellType.HOTEL_PLATINUM);
                         }
                }

            }else {
                switch (cell.getCellType()){
                    case HOTEL_SILVER: cell.getPlayer().addAmount(player.deductAmount(50)); break;
                    case HOTEL_GOLD: cell.getPlayer().addAmount(player.deductAmount(150)); break;
                    case HOTEL_PLATINUM: cell.getPlayer().addAmount(player.deductAmount(300)); break;
                }
            }


        }else {
            if(player.getAmount()>=200){
                cell.setPlayer(player);
                bank.addAmount(player.deductAmount(200));
            }else
            {
                bank.addAmount(player.deductAmount(50));
            }

        }

    }

   static int nextPosition(int currentPosition,String diceInput,int length){

        Integer dice= Integer.parseInt(diceInput);

       return  (currentPosition+dice)<length? currentPosition+dice : (currentPosition +dice )%length;
    }








}
