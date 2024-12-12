package oh;

import java.util.ArrayList;

public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		ArrayList<GameObject> objects = new ArrayList<>();
		
		//TASK 2:  ADD A USER GAME OBJECT OF TYPE D
		Type_D_GameObject user = new Type_D_GameObject(200, 200);
		user.setVelocity(10);
		canvas.addGameObject(user);
		objects.add(user);
		
		
		// ADD TYPE_A_GAMEOBJECT
		Type_A_GameObject a = new Type_A_GameObject(100, 100);
		a.setVelocity(10);
		canvas.addGameObject(a);
		objects.add(a);
		
		// ADD TYPE_B_GAMEOBJECT
		Type_B_GameObject b = new Type_B_GameObject(50, 50);
		b.setVelocity(10);
		canvas.addGameObject(b);
		objects.add(b);
		
		// ADD TYPE_C_GAMEOBJECT
		Type_C_GameObject c = new Type_C_GameObject(250, 250);
		c.setVelocity(10);
		canvas.addGameObject(c);
		objects.add(c);
		
		GameObjectAdapter adapter = new GameObjectAdapter(objects);
		canvas.addKeyListener(adapter);
	}
}

