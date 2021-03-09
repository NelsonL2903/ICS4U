package nelsoncca;


import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;
import com.jme3.scene.shape.Line;
import com.jme3.ui.*;

public class CCAProject extends SimpleApplication {
	
	Geometry barrel;
	Geometry handle;
	Node playerNode = new Node("Player Node");
	Node camNode = new Node("Cam Node");
	float x;
	float y;
	float z;
	Line line;
	Line line2;
	
	public static void main(final String[] args) {
		final CCAProject app = new CCAProject();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		
		flyCam.setMoveSpeed(15);
		setDisplayStatView(false);
		setDisplayFps(false);
		
		Picture pic = new Picture("HUD Picture");
		pic.setImage(assetManager, "nerfgun (1).png", true);
		pic.setWidth(settings.getWidth()/2);
		pic.setHeight(settings.getHeight()/2);
		pic.setPosition(1250, 100);
		guiNode.attachChild(pic);
		
		Picture pic2 = new Picture("HUD Picture");
		pic2.setImage(assetManager, "crosshair.png", true);
		pic2.setWidth(75);
		pic2.setHeight(75);
		pic2.setPosition(915, 500);
		guiNode.attachChild(pic2);
		
		Box a = new Box(new Vector3f(0,-5,0), 10, 0.5f, 10);
		Geometry floor = new Geometry("Box", a);
	    Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat.setTexture("ColorMap", assetManager.loadTexture("hardwood-floor.jpg"));
		mat.setColor("Color", ColorRGBA.White);
		floor.setMaterial(mat);
		rootNode.attachChild(floor);
		
		Box b = new Box(new Vector3f(10,5,0), 0.5f, 10f, 10f);
		Geometry wall = new Geometry("Box", b);
	    Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat2.setTexture("ColorMap", assetManager.loadTexture("kitchenwall.jpg"));
		mat2.setColor("Color", ColorRGBA.White);
		wall.setMaterial(mat2);
		rootNode.attachChild(wall);
	
		Box c = new Box(new Vector3f(-10,5,0), 0.5f, 10f, 10f);
		Geometry wall2 = new Geometry("Box", c);
	    Material mat3 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat3.setTexture("ColorMap", assetManager.loadTexture("wall2.jpg"));
		mat3.setColor("Color", ColorRGBA.White);
		wall2.setMaterial(mat3);
		rootNode.attachChild(wall2);
		
		Box d = new Box(new Vector3f(0,5,10), 10f, 10f, 0.5f);
		Geometry wall3 = new Geometry("Box", d);
	    Material mat4 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat4.setTexture("ColorMap", assetManager.loadTexture("wall3.jpg"));
		mat4.setColor("Color", ColorRGBA.White);
		wall3.setMaterial(mat4);
		rootNode.attachChild(wall3);
		
		Box e = new Box(new Vector3f(0,15,0), 10f, 0.5f, 10f);
		Geometry roof = new Geometry("Box", e);
	    Material mat5 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat5.setTexture("ColorMap", assetManager.loadTexture("chandelier.jpg"));
		mat5.setColor("Color", ColorRGBA.White);
		roof.setMaterial(mat5);
		rootNode.attachChild(roof);
		
		Box f = new Box(new Vector3f(0,-3,-10), 10f, 2f, 0.5f);
		Geometry counter = new Geometry("Box", f);
	    Material mat6 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat6.setTexture("ColorMap", assetManager.loadTexture("counter.jpg"));
		mat6.setColor("Color", ColorRGBA.White);
		counter.setMaterial(mat6);
		rootNode.attachChild(counter);
		
		Box g = new Box(new Vector3f(0,-3,-75), 100f, 100f, 0.5f);
		Geometry background = new Geometry("Box", g);
	    Material mat7 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat7.setTexture("ColorMap", assetManager.loadTexture("scenery.jpg"));
		mat7.setColor("Color", ColorRGBA.White);
		background.setMaterial(mat7);
		rootNode.attachChild(background);
		
		Box h = new Box(new Vector3f(0, 100, 0), 100f, 0.5f, 100f);
		Geometry sky = new Geometry("Box", h);
	    Material mat8 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat8.setTexture("ColorMap", assetManager.loadTexture("sky.jpeg"));
		mat8.setColor("Color", ColorRGBA.White);
		sky.setMaterial(mat8);
		rootNode.attachChild(sky);
		
		Box i = new Box(new Vector3f(75, -3, 0), 0.5f, 100f, 100f);
		Geometry background2 = new Geometry("Box", i);
	    Material mat9 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat9.setTexture("ColorMap", assetManager.loadTexture("scenery.jpg"));
		mat9.setColor("Color", ColorRGBA.White);
		background2.setMaterial(mat9);
		rootNode.attachChild(background2);
		
		Box j = new Box(new Vector3f(-75, -3, 0), 0.5f, 100f, 100f);
		Geometry background3 = new Geometry("Box", j);
	    Material mat10 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat10.setTexture("ColorMap", assetManager.loadTexture("scenery.jpg"));
		mat10.setColor("Color", ColorRGBA.White);
		background3.setMaterial(mat10);
		rootNode.attachChild(background3);
	
		cam.setLocation(new Vector3f(0,0,5));
		getCamera().lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
		cam.lookAtDirection(new Vector3f(0,0,-10), new Vector3f(0,0,0));
		
		line = new Line(new Vector3f(cam.getLocation()), new Vector3f(cam.getDirection()));
		line.setLineWidth(200);
        Geometry geometry = new Geometry("Bullet", line);
        Material bmat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        bmat.setColor("Color", ColorRGBA.Blue);
        geometry.setMaterial(bmat);
        rootNode.attachChild(geometry);
        
        line2 = new Line(new Vector3f(cam.getLocation()), new Vector3f(cam.getDirection().getX()/160f, cam.getDirection().getY()/160f, cam.getDirection().getZ()/160f));
		line2.setLineWidth(2000);
        Geometry bg = new Geometry("Bullet", line2);
        Material bmat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        bmat2.setColor("Color", ColorRGBA.Blue);
        bg.setMaterial(bmat2);
        rootNode.attachChild(bg);
        
	}
	
	

	public void simpleUpdate(float tpf) {
		cam.setLocation(new Vector3f(cam.getLocation().getX(), 0f, cam.getLocation().getZ()));
		
		if (cam.getLocation().getX() > 8) {
			cam.setLocation(new Vector3f(7.9f, cam.getLocation().getY(), cam.getLocation().getZ()));
		}
		
		if (cam.getLocation().getX() < -8) {
			cam.setLocation(new Vector3f(-7.9f, cam.getLocation().getY(), cam.getLocation().getZ()));
		}
		
		if (cam.getLocation().getZ() < -8) {
			cam.setLocation(new Vector3f(cam.getLocation().getX(), cam.getLocation().getY(), -7.9f));
		}
		
		if (cam.getLocation().getZ() > 8) {
			cam.setLocation(new Vector3f(cam.getLocation().getX(), cam.getLocation().getY(), 7.9f));
		}
		
		line.updatePoints(cam.getLocation(), cam.getDirection());
		
		
		
	}

}
