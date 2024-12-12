package oh;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

//GAME OBJECT OF TYPE A REQUIRES A KEY LISTENER
public class Type_A_GameObject extends GameObject implements KeyListener {


	public Type_A_GameObject(int x, int y) {
		super(x, y);
		defaultDirection = Direction.DOWN;
		setDirection(defaultDirection);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
		imageList.add(new ImageIcon("images/Type_A_Left.png"));
		imageList.add(new ImageIcon("images/Type_A_Right.png"));

		isControlled = false;

	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();

		// MOVE GAME OBJECT
		if (getDirection() == Direction.UP) {
			setY(getY() - getVelocity());
			if (getY() < 0) {
				setY(0);
				setDirection(Direction.DOWN);
			}
		} else if (getDirection() == Direction.DOWN) {
			setY(getY() + getVelocity());
			if (getY() + iconHeight > canvasHeight) {
				setY((int) (canvasHeight - iconHeight));
				setDirection(Direction.UP);
			}
		}

	}

	// SPECIFY THE IMAGE TO DISPLAY
	// USED FOR ANIMATION
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.UP:
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB) {
			setDirection(Direction.NONE);
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			setDirection(Direction.UP);
			isControlled = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setDirection(Direction.DOWN);
			isControlled = true;
		}
	}

}
