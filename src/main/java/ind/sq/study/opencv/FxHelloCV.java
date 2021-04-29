package ind.sq.study.opencv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.opencv.core.Core;

public class FxHelloCV extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            var loader = new FXMLLoader(getClass().getClassLoader().getResource("FXHelloCV.fxml"));

            var rootElement = (BorderPane) loader.load();

            var scene = new Scene(rootElement, 800, 600);

            scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());
            primaryStage.setTitle("OPENCV");
            primaryStage.setScene(scene);
            primaryStage.show();


            FxHelloCVController controller = loader.getController();
            primaryStage.setOnCloseRequest((event) -> {
                controller.setClosed();

            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        launch(args);
    }
}