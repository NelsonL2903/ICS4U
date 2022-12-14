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

	        NiftyJmeDisplay niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
	                assetManager,
	                inputManager,
	                audioRenderer,
	                guiViewPort);
	        nifty = niftyDisplay.getNifty();
	        nifty.fromXml("HelloJme3.xml", "start", this);

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
