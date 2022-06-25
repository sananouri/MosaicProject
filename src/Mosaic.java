import javafx.scene.shape.Line;

public class Mosaic {
    private final static int squareSize = 20;

    public static int getSquareSize() {
        return squareSize;
    }

    public static void drawMosaic(Field field) {
        if (field.getSize() != 2) {
            return;
        }
        int emptySquareX = field.getEmptySquareX(), emptySquareY = field.getEmptySquareY(),
                s = getSquareSize(), x = field.getStartX(), y = field.getStartY();
        if (emptySquareX == 1) {
            FxClass.addLine(new Line(x + s * 2, y, x + s * 2, y + s * 2));
            FxClass.addLine(new Line(x, y + s, x + s, y + s));
            if (emptySquareY == 1) {
                drawType1(x, y);
            } else {
                drawType3(x, y);
            }
        } else {
            FxClass.addLine(new Line(x, y, x, y + s * 2));
            FxClass.addLine(new Line(x + s, y + s, x + s * 2, y + s));
            if (emptySquareY == 1) {
                drawType2(x, y);
            } else {
                drawType4(x, y);
            }
        }
    }

    private static void drawType1(int x, int y) { // top left square removed from a 2 by 2 square
        int s = getSquareSize();
        FxClass.addLine(new Line(x, y + s, x, y + s * 2));
        FxClass.addLine(new Line(x + s, y, x + s, y + s));
        FxClass.addLine(new Line(x + s, y, x + s * 2, y));
        FxClass.addLine(new Line(x, y + s * 2, x + s * 2, y + s * 2));
    }

    private static void drawType2(int x, int y) { // top right square removed from a 2 by 2 square
        int s = getSquareSize();
        FxClass.addLine(new Line(x, y, x + s, y));
        FxClass.addLine(new Line(x, y + s * 2, x + s * 2, y + s * 2));
        FxClass.addLine(new Line(x + s * 2, y + s, x + s * 2, y + s * 2));
        FxClass.addLine(new Line(x + s, y, x + s, y + s));
    }

    private static void drawType3(int x, int y) { // bottom left square removed from a 2 by 2 square
        int s = getSquareSize();
        FxClass.addLine(new Line(x, y, x, y + s));
        FxClass.addLine(new Line(x, y, x + s * 2, y));
        FxClass.addLine(new Line(x + s, y + s * 2, x + s * 2, y + s * 2));
        FxClass.addLine(new Line(x + s, y + s, x + s, y + s * 2));
    }

    private static void drawType4(int x, int y) { // bottom right square removed from a 2 by 2 square
        int s = getSquareSize();
        FxClass.addLine(new Line(x, y, x + s * 2, y));
        FxClass.addLine(new Line(x + s * 2, y, x + s * 2, y + s));
        FxClass.addLine(new Line(x, y + s * 2, x + s, y + s * 2));
        FxClass.addLine(new Line(x + s, y + s, x + s, y + s * 2));
    }
}
