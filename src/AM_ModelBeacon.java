package net.minecraft.src;
//Exported java file
//Keep in mind that you still need to fill in some blanks
// - ZeuX

public class AM_ModelBeacon extends ModelBase
{
	public 	AM_ModelBeacon	()
	{
		top = new ModelRenderer(this,0, 0);
		top.addBox(-2.5F, -12F, -2.5F, 5, 12, 5, 0F);
		top.setRotationPoint(0F, 20F, 0F);
		
		top.rotateAngleX = 0F;
		top.rotateAngleY = 0F;
		top.rotateAngleZ = 0F;
		top.mirror = false;
		
		bottom = new ModelRenderer(this,12, 15);
		bottom.addBox(-6.5F, -4F, -6.5F, 13, 4, 13, 0F);
		bottom.setRotationPoint(0F, 24F, 0F);
		
		bottom.rotateAngleX = 0F;
		bottom.rotateAngleY = 0F;
		bottom.rotateAngleZ = 0F;
		bottom.mirror = false;
		
		
	}

	public void render(Entity entity,float f, float f1, float f2, float f3, float f4, float f5)
	{
		//super.render(f, f1, f2, f3, f4, f5);
		//setRotationAngles(f, f1, f2, f3, f4, f5);
		top.render(f5);
		bottom.render(f5);
		
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		//super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

	//fields
	public ModelRenderer top;
	public ModelRenderer bottom;
	
}
