import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FxClass extends Application {
    private static ArrayList<Line> lines = new ArrayList<>();

    public static void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group pane = new Group();
        Scene scene = new Scene(pane, 900, 900);
        stage.setScene(scene);
        stage.show();
        Field field = Field.getField();
        int squareSize = Mosaic.getSquareSize(), size = field.getSize();
        int x = field.getStartX() + squareSize * (field.getEmptySquareX() - 1);
        int y = field.getStartY() + squareSize * (field.getEmptySquareY() - 1);
        String neededMosaics = String.valueOf((size * size - 1) / 3);
        Label label = new Label(neededMosaics + " mosaics needed.");
        label.setLayoutX(50);
        label.setLayoutY(50);
        Rectangle emptySquare = new Rectangle(x, y, squareSize, squareSize);
        emptySquare.setFill(Color.AQUA);
        emptySquare.setStroke(Color.BLACK);
        pane.getChildren().addAll(label);
        pane.getChildren().addAll(emptySquare);
        pane.getChildren().addAll(lines);
    }

    public static void launchApplication(String[] args) {
        launch(args);
    }
}
