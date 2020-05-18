import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameContainer extends Application {
    Maze game = new Maze(30);
    GridPane grid = new GridPane();
    Tile[][] mazeGrid = game.getMazeGrid();

    class ClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent e) {
            GuiTile clickedTile = (GuiTile) e.getSource();
            clickedTile.setColor();
            clickedTile.setNum();
        }
    }

    public class GuiTile extends Button {
        int row;
        int col;
        EventHandler<MouseEvent> click = new ClickHandler();

        GuiTile(int pRow, int pCol, int size) {

            super("0");
            row = pRow;
            col = pCol;
            setPrefSize(size, size);
            setStyle("-fx-background-color: #f0f0f0; ");
            setOnMousePressed(click);
        }

        public void setColor() {
            if (mazeGrid[row][col].isBomb()) {
                setStyle("-fx-background-color: #000; ");
            } else {
                setStyle("-fx-background-color: #fff; ");
            }
        }

        public void setNum() {
            String numBombs = Integer.toString(mazeGrid[row][col].numBombs);
            setText(numBombs);
        }

    }

    @Override
    public void start(Stage primaryStage) {
        final int width = 800;
        final int height = 600;
        final int tileSize = 10;

        grid.setGridLinesVisible(false);
        for (int row = 0; row < mazeGrid.length; row++) {
            for (int col = 0; col < mazeGrid[row].length; col++) {
                grid.add(new GuiTile(row, col, tileSize), col, row);
            }
        }

        grid.setLayoutX(10);
        grid.setLayoutY(10);

        Pane kulisser = new Pane();
        kulisser.setMinSize(width, height);
        kulisser.getChildren().add(grid);

        Scene scene = new Scene(kulisser);

        primaryStage.setTitle("Maze");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}