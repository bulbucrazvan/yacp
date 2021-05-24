package chess.gamelogic;

public class Position {
    private int positionX, positionY;
    private String position;

    public Position(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        setPositionString();
    }

    public Position(String position){
        this.position = position;
        setPositionCoordinates();
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getPosition() {
        return position;
    }

    private void setPositionString() {
        char letter = (char)(positionY + 65);
        char number = (char)(56 - positionX);
        StringBuilder builder = new StringBuilder();
        builder.append(letter);
        builder.append(number);
        position = builder.toString();
    }

    private void setPositionCoordinates() {
        positionY = position.charAt(0) - 65;
        positionX = 56 - position.charAt(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionX == position.positionX && positionY == position.positionY;
    }
}
