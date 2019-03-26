package logic;

import controllers.WelcomeWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {

    /**
     * This is how all the frontend FXML files connects to the backend
     */
    private GameConfig gameConfig;
    private boolean playing = true;

    /**
     * Setter and Getter methods
     */
    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }


    /**
     * 1. Creates the appropriate objects and connects it to the driver
     * and also sets the this Driver to the appropriate objects created
     * 2. Loads the first FXML file to display
     *
     * @param primaryStage the stage the will display the scenes for the game
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
       // do {
            GameConfig theGameConfig = new GameConfig(this);
            setGameConfig(theGameConfig);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/welcomeWindow.fxml"));
            Parent root = loader.load();
            WelcomeWindowController controller = loader.getController();
            controller.setDriver(this);

            primaryStage.setTitle("Conquering U of C");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        //} while (playing);
       // primaryStage.close();
    }

    public void restart(Stage primaryStage) throws Exception {
        GameConfig theGameConfig = new GameConfig(this);
        setGameConfig(theGameConfig);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/welcomeWindow.fxml"));
        Parent root = loader.load();
        WelcomeWindowController controller = loader.getController();
        controller.setDriver(this);

        primaryStage.setTitle("Conquering U of C");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
}