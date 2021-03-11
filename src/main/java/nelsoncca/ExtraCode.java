package nelsoncca;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Line;

public class ExtraCode {

	public static void main(String[] args) {
		line2 = new Line(new Vector3f(0,0,0), new Vector3f(0.25f,0.25f,0.25f));
		line2.setLineWidth(20);
        Geometry bg = new Geometry("Bullet", line2);
        Material bmat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        bmat2.setTexture("ColorMap", assetManager.loadTexture("foam.jpg"));
        bmat2.setColor("Color", ColorRGBA.Blue);
        bg.setMaterial(bmat2);
        rootNode.attachChild(bg);
        
        float xd = cam.getDirection().getX(); //+ cam.getLocation().getX();
        float yd = cam.getDirection().getY(); //+ cam.getLocation().getY();
        float zd = cam.getDirection().getZ(); //+ cam.getLocation().getZ();
        float xl = cam.getLocation().getX();
        float yl = cam.getLocation().getY();
        float zl = cam.getLocation().getZ();
        
        float xf = xd * (1.25f);
        float yf = yd * (1.25f);
        float zf = zd * (1.25f);
        
        line2.updatePoints(new Vector3f(xl, yl, zl), new Vector3f(xf, yf, zf));
        System.out.println(cam.getLocation());
        System.out.println(cam.getDirection());
        System.out.println(xf);
        System.out.println(yf);
        System.out.println(zf);
        
        for (int i = 0; i < 10001; ++i) {
        	float xsu = line2.getStart().getX() - 0.01f;
    		float ysu = line2.getStart().getY() - 0.01f;
    		float zsu = line2.getStart().getZ() - 0.01f;
    		
    		float xeu = line2.getEnd().getX() - 0.01f;
    		float yeu = line2.getEnd().getY() - 0.01f;
    		float zeu = line2.getEnd().getZ() - 0.01f;
    		
    		Vector3f startup = new Vector3f(xsu, ysu, zsu);
    		Vector3f endup = new Vector3f(xeu, yeu, zeu);
    		
    		line.updatePoints(cam.getLocation(), cam.getDirection());
    		line2.updatePoints(startup, endup);
        }
	}


}
