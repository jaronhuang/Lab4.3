import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameCode extends Application
{

	public static void main(String[] args) 
	{
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) 
	{
        primaryStage.setTitle("Wack-a-Button");
        Button btn = new Button();
        btn.setText("Click Me!");
        btn.setLayoutX(350);
        btn.setLayoutY(350);
        btn.setStyle("-fx-background-color: dodgerblue; -fx-padding:25; -fx-font-size:18;");
               
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
        	int score = 0;
        	int randomX = 0;
        	int randomY = 0;
            @Override
            public void handle(ActionEvent event) 
            {
            	randomX = 0 + (int)(Math.random() * 705);
            	randomY = 0 + (int)(Math.random() * 750);
            	btn.setLayoutX(randomX);
                btn.setLayoutY(randomY);
                score++;
                System.out.println("Your Score: " + score);
            }
        });
        
        Pane root = new Pane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }

}
