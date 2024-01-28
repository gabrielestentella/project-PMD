package gabrielestentella;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import gabrielestentella.controllers.Controller;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {;

        scene = new Scene(loadView("Login"), 1280, 720);
        navigate(null, "Login");
        stage.setScene(scene);
        stage.setTitle("Gestione tirocini");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.show();
    }

    public static Parent loadView(String view) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("views/" + view + ".fxml"));
        return loader.load();
    }

    public static Parent loadView(Controller sender, String view) throws IOException {
        return loadView(sender, view, null);
    }

    public static Parent loadView(Controller sender, String view, Object [] parameters) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("views/" + view + ".fxml"));
        Parent parent = loader.load();
        Controller controller = loader.getController();
        controller.onNavigateFrom(sender, parameters);
        controller.init();
        return parent;
    }

    public static void navigate(Controller sender, String view, Object [] parameters) throws IOException {
        Parent parent = loadView(sender, view, parameters);
        scene.setRoot(parent);
    }

    public static void navigate(Controller sender, String view) throws IOException {
        navigate(sender, view, null);
    }

    public static void main(String[] args) { launch(); }
}