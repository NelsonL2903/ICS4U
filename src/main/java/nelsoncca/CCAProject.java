package nelsoncca;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

public class CCAProject extends SimpleApplication {
	
	int x = 0;
	int y = 3;
	int z = 0;
	Geometry barrel;
	Geometry handle;
	Node playerNode = new Node("Player Node");
	
	public static void main(final String[] args) {
		final CCAProject app = new CCAProject();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		
		Box a = new Box(new Vector3f(0,0,0), 5, 1, 5);
		Geometry floor = new Geometry("Box", a);
	    Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setColor("Color", ColorRGBA.White);
		floor.setMaterial(mat);
		rootNode.attachChild(floor);
	
		this.cam.setLocation(rootNode.localToWorld(new Vector3f(x+6, y+20, z-20), null));
		getCamera().lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
		
		Box b = new Box(new Vector3f(0,3,0), 1, 2, 1);
		handle = new Geometry("Box", b);
		Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat2.setColor("Color", ColorRGBA.Gray);
		handle.setMaterial(mat2);
		playerNode.attachChild(handle);
		
		Box c = new Box(new Vector3f(0,5,2), 1, 1, 4);
		barrel = new Geometry("Box", c);
		Material mat3 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat3.setColor("Color", ColorRGBA.LightGray);
		barrel.setMaterial(mat3);
		
		rootNode.attachChild(playerNode);
		playerNode.attachChild(barrel);
		
		playerNode.setLocalTranslation(0,5,0);
		
	}
	
	public void simpleUpdate(float tpf) {
		
		
	
	}

}
