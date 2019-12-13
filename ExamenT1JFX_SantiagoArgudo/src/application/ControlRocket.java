package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControlRocket {

	@FXML
	private AnchorPane root, rootHome;
	@FXML
	private ImageView imgLogin;

	public void initialize() {

		fadePhoto();

	}

	@FXML
	public void closeApp() {
		Stage thisStage = (Stage) rootHome.getScene().getWindow();
		thisStage.close();
	}

	@FXML
	public void closeStage() {
		Stage thisStage = (Stage) root.getScene().getWindow();
		thisStage.close();
	}


	@FXML
	public void openStage() {

		closeStage();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Urano.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
			Scene scene = new Scene(pane, 600, 500);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void fadePhoto() {
		FadeTransition tf = new FadeTransition(Duration.seconds(5), imgLogin);
		tf.setFromValue(0);
		tf.setToValue(1);
		tf.play();
	}


}
