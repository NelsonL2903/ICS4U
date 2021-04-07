package nelsoncca;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

public class NiftyGUI2 extends SimpleApplication implements ScreenController{

	private Nifty nifty;
	
	public static void main(String[] args){
        NiftyGUI2 app = new NiftyGUI2();
        app.setPauseOnLostFocus(false);
        app.start();
	}
        
	@Override
	public void simpleInitApp() {
		 
		Box b = new Box(1, 1, 1);
	        Geometry geom = new Geometry("Box", b);
	        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	        mat.setTexture("ColorMap", assetManager.loadTexture("Monkey.jpg"));
	        geom.setMaterial(mat);
	        rootNode.attachChild(geom);

	        NiftyJmeDisplay niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
	                assetManager,
	                inputManager,
	                audioRenderer,
	                guiViewPort);
	        nifty = niftyDisplay.getNifty();
	        nifty.fromXml("HelloJme2.xml", "start", this);

	        guiViewPort.addProcessor(niftyDisplay);

	        flyCam.setEnabled(false);
	        flyCam.setDragToRotate(true);
	        inputManager.setCursorVisible(true);		
	}

	public void textclickx() {
		System.out.println("Hello!");
	}
	
	@Override
	public void bind(Nifty nifty, Screen screen) {
		 System.out.println("bind( " + screen.getScreenId() + ")");		
	}

	@Override
	public void onStartScreen() {
		System.out.println("onStartScreen");		
	}

	@Override
	public void onEndScreen() {
		System.out.println("onEndScreen");		
	}
	
	public void quit(){
        nifty.gotoScreen("end");
    }

}
