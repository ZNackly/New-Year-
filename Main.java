import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    private static final int WIDTH = 800; 
    private static final int HEIGHT = 600; 

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);

        
        Image backgroundImage = new Image("background.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(WIDTH);
        backgroundImageView.setFitHeight(HEIGHT);
        root.getChildren().add(backgroundImageView);

        
        for (int i = 0; i < 30; i++) {
            Circle circle = createCircle();
            root.getChildren().add(circle);

            Timeline timeline = createTimeline(circle);
            timeline.play();
        }

        
        for (int i = 0; i < 100; i++) {
            Circle snowflake = createSnowflake();
            root.getChildren().add(snowflake);

            Timeline timeline = createSnowfallTimeline(snowflake);
            timeline.play();
        }

        
        Text greetingText = new Text("С Новым Годом!");
        greetingText.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        greetingText.setFill(Color.WHITE);
        greetingText.setX(WIDTH / 2 - greetingText.getLayoutBounds().getWidth() / 2);
        greetingText.setY(HEIGHT / 2 - greetingText.getLayoutBounds().getHeight() / 2);

        root.getChildren().add(greetingText);

        primaryStage.show();
    }

    private Circle createCircle() {
        Circle circle = new Circle(5, Color.web("white", 0.8));
        circle.setBlendMode(BlendMode.ADD);
        circle.setOpacity(0.5);

        double startX = Math.random() * WIDTH;
        double startY = Math.random() * HEIGHT;

        circle.setCenterX(startX);
        circle.setCenterY(startY);

        return circle;
    }

    private Timeline createTimeline(Circle circle) {
        KeyValue keyValueX1 = new KeyValue(circle.centerXProperty(), circle.getCenterX());
        KeyValue keyValueY1 = new KeyValue(circle.centerYProperty(), circle.getCenterY());

        double endX1 = Math.random() * WIDTH;
        double endY1 = Math.random() * HEIGHT;

        KeyValue keyValueX2 = new KeyValue(circle.centerXProperty(), endX1);
        KeyValue keyValueY2 = new KeyValue(circle.centerYProperty(), endY1);

        KeyFrame keyFrameStart = new KeyFrame(Duration.ZERO, keyValueX1, keyValueY1);
        KeyFrame keyFrameEnd = new KeyFrame(Duration.seconds(3), keyValueX2, keyValueY2);
        }
    }
