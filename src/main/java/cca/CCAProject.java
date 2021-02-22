package cca;

public class CCAProject extends SimpleGame{

	public static void main(String[] args) {

		waterEffectRenderPass = new WaterRenderPass(cam, 4, false, true);
		waterQuad = new Quad("waterQuad", 1, 1);
		waterEffectRenderPass.setWaterEffectOnSpatial(waterQuad);
		
	}

}
