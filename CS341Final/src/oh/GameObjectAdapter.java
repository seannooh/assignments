package oh;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameObjectAdapter implements KeyListener {
	
	private ArrayList<GameObject> objects;
	private int index;
	
	public GameObjectAdapter(ArrayList<GameObject> objects) {
		this.objects = objects;
		index = 0;
		// SET THE FIRST OBJECT TO BE USER CONTROLLED
		objects.get(0).isControlled = true;
	}

	@Override 
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			objects.get(index).isControlled = false;
			objects.get(index).setDirection(objects.get(index).defaultDirection);
			index++;
			if (index >= objects.size()) {
				index = 0;
			}
			objects.get(index).isControlled = true;
			GameObject nextObject = objects.get(index);
			((KeyListener)nextObject).keyPressed(e);
		}
		else {
			GameObject currentObject = objects.get(index);
			if (currentObject.isControlled) {
				((KeyListener)currentObject).keyPressed(e);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() != KeyEvent.VK_TAB) {
			GameObject nextObject = objects.get(index);
			if (nextObject.isControlled) {
				((KeyListener)nextObject).keyPressed(e);
				nextObject.setDirection(Direction.NONE);
			}
		}
		
	}
	
}
