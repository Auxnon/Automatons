package net.minecraft.src;
//Exported java file
//Keep in mind that you still need to fill in some blanks
// - ZeuX

public class AM_ModelSlider extends ModelBase
{
	public 	AM_ModelSlider	()
	{
		body = new ModelRenderer(this,1, 1);
		body.addBox(-10F, -5F, -10F, 20, 5, 19, 0F);
		body.setRotationPoint(0F, 24F, 0F);
		
		body.rotateAngleX = 0F;
		body.rotateAngleY = 3.141593F;
		body.rotateAngleZ = 0F;//3.141593F
		body.mirror = false;
		
		leg1 = new ModelRenderer(this,0, 0);
		leg1.addBox(0F, -1F, -1F, 6, 2, 2, 0F);
		leg1.setRotationPoint(9F, 22F, 7F);
		
		leg1.rotateAngleX = 0F;
		leg1.rotateAngleY = 0F;
		leg1.rotateAngleZ = 0F;
		leg1.mirror = false;
		
		mouth = new ModelRenderer(this,0, 26);
		mouth.addBox(-5F, 0F, -3F, 10, 3, 3, 0F);
		mouth.setRotationPoint(0F, 20F, -10.1F);
		
		mouth.rotateAngleX = 0F;
		mouth.rotateAngleY = 0F;
		mouth.rotateAngleZ = 0F;
		mouth.mirror = false;
		
		part = new ModelRenderer(this,19, 19);
		part.addBox(-10F, -1F, 0F, 20, 5, 1, 0F);
		part.setRotationPoint(0F, 20F, -10F);
		
		part.rotateAngleX = 0F;
		part.rotateAngleY = 0F;
		part.rotateAngleZ = 0F;
		part.mirror = false;
		
		leg2 = new ModelRenderer(this,0, 0);
		leg2.addBox(-6F, -1F, -1F, 6, 2, 2, 0F);
		leg2.setRotationPoint(-9F, 22F, 7F);
		
		leg2.rotateAngleX = 0F;
		leg2.rotateAngleY = 0F;
		leg2.rotateAngleZ = 0F;
		leg2.mirror = false;
		
		leg3 = new ModelRenderer(this,0, 0);
		leg3.addBox(-6F, -1F, -1F, 6, 2, 2, 0F);
		leg3.setRotationPoint(-9F, 22F, -7F);
		
		leg3.rotateAngleX = 0F;
		leg3.rotateAngleY = 0F;
		leg3.rotateAngleZ = 0F;
		leg3.mirror = false;
		
		leg4 = new ModelRenderer(this,0, 0);
		leg4.addBox(0F, -1F, -1F, 6, 2, 2, 0F);
		leg4.setRotationPoint(9F, 22F, -7F);
		
		leg4.rotateAngleX = 0F;
		leg4.rotateAngleY = 0F;
		leg4.rotateAngleZ = 0F;
		leg4.mirror = false;
		
		
	}

	public void render(Entity entity,float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity,f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		body.render(f5);
		leg1.render(f5);
		mouth.render(f5);
		part.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
		
		leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        leg1.rotateAngleY = leg1.rotateAngleX;
        leg2.rotateAngleY =leg2.rotateAngleX;
		
		
		leg3.rotateAngleX=leg1.rotateAngleX;
		leg3.rotateAngleY=leg1.rotateAngleY;
		leg4.rotateAngleX=leg2.rotateAngleX;
		leg4.rotateAngleY=leg2.rotateAngleY;
	}

	//fields
	public ModelRenderer body;
	public ModelRenderer leg1;
	public ModelRenderer mouth;
	public ModelRenderer part;
	public ModelRenderer leg2;
	public ModelRenderer leg3;
	public ModelRenderer leg4;
	
}
