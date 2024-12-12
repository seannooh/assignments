package tester;

import java.util.ArrayList;

import oh.GameObject;
import oh.GameObjectAdapter;
import oh.Type_A_GameObject;
import oh.Type_B_GameObject;
import oh.Type_C_GameObject;
import oh.Type_D_GameObject;

public class Tester {

	public static void main(String[] args) {
		// TEST CREATION OF EACH OBJECT
		Type_A_GameObject a = new Type_A_GameObject(100, 100);
		Type_B_GameObject b = new Type_B_GameObject(50, 50);
		Type_C_GameObject c = new Type_C_GameObject(250, 250);
		Type_D_GameObject d = new Type_D_GameObject(200, 200);
		
		// TEST CREATING ADAPTER
		ArrayList<GameObject> objects = new ArrayList<>();
		objects.add(a);
		objects.add(b);
		objects.add(c);
		objects.add(d);

		GameObjectAdapter adapter = new GameObjectAdapter(objects);
		System.out.println(objects);

	}

}
