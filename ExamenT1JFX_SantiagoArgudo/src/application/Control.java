package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Control {

	@FXML
	private Pane pane1;

	@FXML
	private Pane pane2;

	@FXML
	private Pane pane3;

	@FXML
	private Pane pane4;

	@FXML
	AnchorPane rootHome;

	public void initialize() {

		backgroundAnimation();

	}


	@FXML
	public void abrirHomepage() {

		closeApp();

		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Urano.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage sendStage = new Stage();
            Scene scene = new Scene(page);
            sendStage.setScene(scene);
            sendStage.show();

            initialize();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	private void backgroundAnimation() {

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5), pane4);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		fadeTransition.setOnFinished(event -> {
			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), pane3);
			fadeTransition1.setFromValue(1);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {
				FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane2);
				fadeTransition2.setFromValue(1);
				fadeTransition2.setToValue(0);
				fadeTransition2.play();

				fadeTransition2.setOnFinished(event2 -> {
					FadeTransition fadeTransition0 = new FadeTransition(Duration.seconds(3), pane2);
					fadeTransition0.setFromValue(0);
					fadeTransition0.setToValue(1);
					fadeTransition0.play();

					fadeTransition0.setOnFinished(event3 -> {
						FadeTransition fadeTransition3 = new FadeTransition(Duration.seconds(3), pane3);
						fadeTransition3.setFromValue(0);
						fadeTransition3.setToValue(1);
						fadeTransition3.play();

						fadeTransition3.setOnFinished(event4 -> {
							FadeTransition fadeTransition4 = new FadeTransition(Duration.seconds(3), pane4);
							fadeTransition4.setFromValue(0);
							fadeTransition4.setToValue(1);
							fadeTransition4.play();

							fadeTransition4.setOnFinished(event5 -> {

								backgroundAnimation();
							});

						});

					});

				});
			});

		});

	}

	@FXML
	public void closeApp() {
		Stage thisStage = (Stage) rootHome.getScene().getWindow();
		thisStage.close();

	}
}