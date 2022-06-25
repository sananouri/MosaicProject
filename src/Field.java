public class Field {
    private int fieldSize;
    private int startX;
    private int startY;
    private int emptySquareX;
    private int emptySquareY;
    private static Field field;

    private Field(int fieldSize, int startX, int startY, int emptySquareX, int emptySquareY) {
        this.fieldSize = fieldSize;
        this.startX = startX;
        this.startY = startY;
        this.emptySquareX = emptySquareX;
        this.emptySquareY = emptySquareY;
    }

    public static Field getField() {
        return field;
    }

    public int getSize() {
        return fieldSize;
    }

    public int getEmptySquareX() {
        return emptySquareX;
    }

    public int getEmptySquareY() {
        return emptySquareY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public static void fillField(int size, int emptySquareX, int emptySquareY, String[] args) {
        field = new Field(size, 100, 100, emptySquareX, emptySquareY);
        fill(field);
        FxClass.launchApplication(args);
    }

    public static void fill(Field field) {
        int newSize = field.getSize() / 2, startX = field.getStartX(), startY = field.getStartY(),
                emptySquareX = field.getEmptySquareX(), emptySquareY = field.getEmptySquareY(),
                s = Mosaic.getSquareSize();
        if (field.getSize() == 1) {
            return;
        }
        if (field.getSize() == 2) {
            Mosaic.drawMosaic(field);
            return;
        }
        if (emptySquareX > newSize) {
            fill(new Field(newSize, startX, startY, newSize, newSize));
            fill(new Field(newSize, startX, startY + newSize * s, newSize, 1));
            if (emptySquareY > newSize) {
                fill(new Field(newSize, startX + newSize * s, startY, 1, newSize));
                fill(new Field(newSize, startX + newSize * s, startY + newSize * s,
                        emptySquareX - newSize, emptySquareY - newSize));
            } else {
                fill(new Field(newSize, startX + newSize * s, startY + newSize * s, 1, 1));
                fill(new Field(newSize, startX + newSize * s, startY, emptySquareX - newSize, emptySquareY));
            }
        } else {
            fill(new Field(newSize, startX + newSize * s, startY, 1, newSize));
            fill(new Field(newSize, startX + newSize * s, startY + newSize * s, 1, 1));
            if (emptySquareY > newSize) {
                fill(new Field(newSize, startX, startY, newSize, newSize));
                fill(new Field(newSize, startX, startY + newSize * s, emptySquareX, emptySquareY - newSize));
            } else {
                fill(new Field(newSize, startX, startY + newSize * s, newSize, 1));
                fill(new Field(newSize, startX, startY, emptySquareX, emptySquareY));
            }
        }
    }
}
