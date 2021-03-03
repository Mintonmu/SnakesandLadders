import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Board {
    private final HashMap<Integer, Integer> deltaHashMap;
    private final Square[][] panel;
    private int rows, cols;
    private LinkedList<Player> players;

    public Board(int rows, int cols, HashMap<Integer, Integer> hashMap) {
        this.rows = rows;
        this.cols = cols;
        this.deltaHashMap = hashMap;
        panel = new Square[rows][cols];
        for (int i = 0; i < panel.length; i++) {
            for (int j = 0; j < panel[0].length; j++) {
                panel[i][j] = new Square(getPosition(i, j));
            }
        }
        Iterator<Map.Entry<Integer, Integer>> it = deltaHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = it.next();
            int[] res = new int[2];
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            this.getRowCol(key, res);
            this.panel[res[0]][res[1]].setDelta(value);
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public boolean takeTurns() {
        for (Player player : players) {
            if (player.move()) {
                return true;
            }
        }
        System.out.println();
        return false;
    }

    public void putPlayer(Player player, int pos) {
        if (players == null) players = new LinkedList<>();
        player.setGameBoard(this);
        Square square = getSquare(pos);
        player.setCurrentSquare(square);
        players.add(player);
        square.addPlayer(player);
    }

    public int getPosition(int row, int col) {
        return ((row & 1) == 1) ?
                (row + 1) * this.cols - col - 1 : row * this.cols + col;
    }

    public void getRowCol(int position, int[] res) {
        res[0] = position / this.cols;
        res[1] = (res[0] & 1) == 1 ? this.cols - 1 - (position % 5) : res[0];

    }

    public Square getSquare(int row, int col) {
        return this.panel[row][col];
    }

    public Square getSquare(int pos) {
        int[] res = new int[2];
        this.getRowCol(pos, res);
        return this.getSquare(res[0], res[1]);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                builder.append(panel[i][j].toString());
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}