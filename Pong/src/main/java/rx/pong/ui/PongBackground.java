package rx.pong.ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PongBackground extends Canvas {

	public PongBackground(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		GraphicsContext context = this.getGraphicsContext2D();
		context.setFill(Color.BLACK);
		context.fillRect(0, 0, screenWidth, screenHeight);
	}
}
