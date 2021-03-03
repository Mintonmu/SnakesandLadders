import java.util.ArrayList;

public class Square {
    private int position;
    private ArrayList<Player> players;
    private int delta;

    public Square(int position) {
        this.position = position;
    }

    public static void main(String[] args) {
        Square s = new Square(5);
        s.setDelta(3);
        System.out.println(s.toString());
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public void addPlayer(Player p) {

        if (players == null) players = new ArrayList<>();
        players.add(p);
    }

    public boolean removePlayer(Player p) {
        players.remove(p);
        return true;
    }

    public String getPlayers() {
        StringBuilder builder = new StringBuilder();

        if (players == null) return String.format("%2s", " ");

        for (Player player : players) {
            builder.append(player.getName());
        }

        return String.format("%2s", builder.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getPlayers()).append(String.format("%3d", this.getPosition())).append('(')
                .append(String.format("%2d", this.getDelta())).append(")  ");
        return builder.toString();
    }
}
