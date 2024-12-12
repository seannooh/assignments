package oh;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;


//GAME OBJECT OF TYPE C REQUIRES A KEY LISTENER
public class Type_C_GameObject extends GameObject implements KeyListener {

  public Type_C_GameObject(int x, int y) {
    super(x, y);
    defaultDirection = Direction.RIGHT;
    setDirection(defaultDirection);
    
    imageList = new LinkedList<Icon>();
    imageList.add(new ImageIcon("images/Type_C_Right.png"));
    
    isControlled = false;
    
  }

  public void move(Canvas c) {
    Icon icon = getCurrentImage();

    int  iconHeight   = icon.getIconHeight();
    int  iconWidth    = icon.getIconWidth();
    int  canvasHeight = (int)c.getSize().getHeight();
    int  canvasWidth  = (int)c.getSize().getWidth();

    //MOVE GAME OBJECT
    switch (getDirection()) {
      case Direction.LEFT:
        setX(getX() - getVelocity());
        if (getX() <= 0) {
          setX(0);
          setDirection(Direction.RIGHT);
        }
        break;
      case Direction.RIGHT:
        setX(getX() + getVelocity());
        if (getX() + iconWidth >= canvasWidth) {
          setX((int)canvasWidth - iconWidth);
          setDirection(Direction.LEFT);
        }
        break;
	default:
		break;
    }

  }

  //SPECIFY THE IMAGE TO DISPLAY
  //   USED FOR ANIMATION
  public void setImage() {
	    switch (getDirection()) {
	      case Direction.NONE:
	        break;
	      case Direction.UP:
	        break;
	      case Direction.DOWN:
	        break;
	      case Direction.RIGHT:
	        currentImage = 0;
	        break;
	      case Direction.LEFT:
	        currentImage = 0;
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
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      setDirection(Direction.DOWN);
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      setDirection(Direction.RIGHT);
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      setDirection(Direction.LEFT);
    }
  }

}
