package SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
 * @author Bashar Habash
 */
public class RenderPanel extends JPanel
{

	public static int curcolor = 0;

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(new Color(curcolor));
		g.fillRect(0, 0, 800, 700);
		curcolor ++;
		
		g.setColor(Color.WHITE);
		Snake snake = Snake.snake;
		for (Point point : snake.snakeParts)
		{
			g.fillOval(point.x * Snake.SCALE, point.y * Snake.SCALE,
					Snake.SCALE, Snake.SCALE);
		}
		g.fillOval(snake.head.x * Snake.SCALE, snake.head.y * Snake.SCALE,
				Snake.SCALE, Snake.SCALE);
		
		g.setColor(Color.RED);
		g.fillRect(snake.cherry.x * Snake.SCALE, snake.cherry.y * Snake.SCALE, Snake.SCALE, Snake.SCALE);
		
		String string = "Score: " + snake.score + ", Length: " + snake.tailLength + ", Time: " + snake.time / 20;
		g.setColor(Color.white);
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);
		
		string = "Game Over!";
		if (snake.over)
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f),
					(int) snake.dim.getHeight() / 4);
		
		string = "Paused!";
		if (snake.paused && !snake.over)
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f),
					(int) snake.dim.getHeight() / 4);
		
	}
}