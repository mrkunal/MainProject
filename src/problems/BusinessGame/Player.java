package problems.BusinessGame;

import java.util.Objects;

public class Player {

   private String name;
   private int position;
   private double amount;

    public Player(String name, int position, double amount) {
        this.name = name;
        this.position = position;
        this.amount = amount;
    }

    public double deductAmount(double amount)
    {
        if(this.amount<amount) {
            System.out.println(this);
            throw new RuntimeException("Player :" + this.name + " Not sufficient Balance and lost the game");
        }
        this.amount-=amount;
        return amount;
    }
    public double addAmount(double amount){
        this.amount+=amount;
        return amount;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", amount=" + amount +
                '}';
    }
}
