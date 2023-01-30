public class InputProcessor {
    public int getRow(String line){
        int row = Integer.parseInt(line.split(",")[0].trim());
        return row;
    }

    public int getColumn(String line){
        int column = Integer.parseInt(line.split(",")[1].trim());
        return column;
    }
}
