import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameCode extends Application
{
	public int score;
	public String kScore;
	public long starttime;
	
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
        btn.setStyle("-fx-background-color: gold; -fx-font-weight: bold; -fx-stroke: white; -fx-padding:15; -fx-font-size:18;");
        Text text = new Text(706, 750, kScore);
        text.setFont(Font.font ("Arial", FontWeight.BOLD, 20));
               
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
        	int randomX = 0;
        	int randomY = 0;
            @Override
            public void handle(ActionEvent event) 
            {
            	randomX = 0 + (int)(Math.random() * 600);
            	randomY = 0 + (int)(Math.random() * 730);
            	btn.setLayoutX(randomX);
                btn.setLayoutY(randomY);
                score++;
                kScore = "Score: " + score;
                text.setText(kScore);
                text.setFill(Color.WHITE);
                starttime = System.nanoTime();
                //if (starttime > 1000000000)
                {
                	//btn.setDisable(true);
                }
            }
        });
        Pane root = new Pane();
        root.getChildren().add(btn);
        root.setStyle("-fx-background-color: transparent;");
        primaryStage.setScene(new Scene(root, 800, 800, Color.BLACK));
        root.getChildren().add(text);
        primaryStage.show();
    }

}
