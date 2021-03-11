package nelsoncca;


import java.util.concurrent.TimeUnit;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;
import com.jme3.scene.shape.Line;
import com.jme3.scene.shape.Sphere;
import com.jme3.ui.*;

public class CCAProject extends SimpleApplication implements ActionListener{
	//TODO reload
	//TODO reload sounds
	//TODO timer
	//TODO scoreboard
	//TODO gun noise
	//TODO set random positions
	//TODO reset option
	//TODO set colour changes for targets
	//TODO add controls to hud
	
	
	Geometry barrel;
	Geometry handle;
	Node playerNode = new Node("Player Node");
	Node camNode = new Node("Cam Node");
	float x;
	float y;
	float z;
	Line line;
	Line line2;
	Boolean left = false;
	Boolean lshift = false;
	Boolean croucht = false;
	private Node shootables;
	int secondones = 0;
	int secondtens = 0;
	int minuteones = 0;
	int minutetens = 0;
	int milisecondones = 0;
	int milisecondtens = 0;
	BitmapText timer;
	
	public static void main(final String[] args) {
		final CCAProject app = new CCAProject();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		
		shootables = new Node("Shootables");
	    rootNode.attachChild(shootables);
	    shootables.attachChild(Targetbox("target1", -20f, 0f, -35f));
	    shootables.attachChild(Targetbox("target2", 15f, -2f, -25f));
	    shootables.attachChild(Targetbox("target3", 0f, 1f, -55f));
	    shootables.attachChild(Targetbox("target4", 5f, 10f, -45f));
		
		initKeys();
		
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
		pic2.setWidth(50);
		pic2.setHeight(50);
		pic2.setPosition(935, 515);
		guiNode.attachChild(pic2);
		
		timer = new BitmapText(guiFont, false);
		timer.setSize(50);
		timer.setColor(ColorRGBA.White);
		timer.setText("" + minutetens + minuteones + ":" + secondtens + secondones
				+ ":" + milisecondtens + milisecondones);
		timer.setLocalTranslation(300, timer.getLineHeight(), 0);
		guiNode.attachChild(timer);
		
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
		
		Box f = new Box(new Vector3f(0,-3,-10), 10f, 1f, 0.5f);
		Geometry counter = new Geometry("Box", f);
	    Material mat6 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat6.setTexture("ColorMap", assetManager.loadTexture("counter.jpg"));
		mat6.setColor("Color", ColorRGBA.White);
		counter.setMaterial(mat6);
		rootNode.attachChild(counter);
		
	/*	Box g = new Box(new Vector3f(0,-3,-75), 100f, 100f, 0.5f);
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
		*/
	
		cam.setLocation(new Vector3f(0,0,5));
		getCamera().lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
		cam.lookAtDirection(new Vector3f(0,0,-10), new Vector3f(0,0,0));
        
	}
	
	private void initKeys() {
		inputManager.addMapping("Shoot", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
		inputManager.addMapping("Crouch", new KeyTrigger(KeyInput.KEY_LSHIFT));
		inputManager.addListener(this, "Shoot");
		inputManager.addListener(this, "Crouch");
	}

	@Override
	public void onAction(String binding, boolean isPressed, float tpf) {
		if (binding.equals("Shoot")) {
			left = isPressed;
		} else if (binding.equals("Crouch")) {
			lshift = isPressed;
		}
	}
	
	protected Geometry Targetbox(String Target, float x, float y, float z) {
	    Box box = new Box(1, 1, 0.025f);
	    Geometry cube = new Geometry("Target", box);
	    cube.setLocalTranslation(x, y, z);
	    Material mat1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat1.setTexture("ColorMap", assetManager.loadTexture("target.png"));
	    mat1.setColor("Color", ColorRGBA.White);
	    cube.setMaterial(mat1);
	    return cube;
	  }
	
	public void simpleUpdate(float tpf) {
		
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
		
		if (left) {
			 Sphere sphere = new Sphere(5, 5, 0.2f);
			    Geometry shot = new Geometry("shoot", sphere);
			    Material shotmat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
			    shotmat.setColor("Color", ColorRGBA.Black);
			    shot.setMaterial(shotmat);
			    
			CollisionResults results = new CollisionResults();
			Ray ray = new Ray(cam.getLocation(), cam.getDirection());
			shootables.collideWith(ray, results);
			for (int i = 0; i < results.size(); i++) {
			String hit = results.getCollision(i).getGeometry().getName();
			}
			if (results.size() > 0) {
				 CollisionResult closest = results.getClosestCollision();
				 shot.setLocalTranslation(closest.getContactPoint());
		          rootNode.attachChild(shot);
		        } else {
		          rootNode.detachChild(shot);
		}
		
	}
		
		if (lshift) {
			if (croucht == true) {
				croucht = false;
			} else {
				croucht = true;
			}
		}
		if (croucht == true) {
			cam.setLocation(new Vector3f(cam.getLocation().getX(), -2f, cam.getLocation().getZ()));
			flyCam.setMoveSpeed(5);
		} else {
			cam.setLocation(new Vector3f(cam.getLocation().getX(), 0f, cam.getLocation().getZ()));
			flyCam.setMoveSpeed(15);
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		milisecondones = milisecondones + 1;
		if (milisecondones == 10) {
			milisecondones = milisecondones - 10;
			milisecondtens = milisecondtens + 1;
			if (milisecondtens == 10) {
				milisecondtens = milisecondtens - 10;
				secondones = secondones + 1;
				if (secondones == 10) {
					secondones = secondones - 10;
					secondtens = secondtens + 1;
					if (secondtens == 6) {
						secondtens = secondtens - 6;
						minuteones = minuteones + 1;
						if (minuteones == 10) {
							minuteones = minuteones - 10;
							minutetens = minutetens + 1;
						}}}}}
		
		timer.setText("" + minutetens + minuteones + ":" + secondtens + secondones
				+ ":" + milisecondtens + milisecondones);
		
}
}
