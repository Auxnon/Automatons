package net.minecraft.src;
//Exported java file
//Keep in mind that you still need to fill in some blanks
// - ZeuX

public class AM_ModelGolem extends ModelBase
{
	public 	AM_ModelGolem	()
	{
		leg1 = new ModelRenderer(this,0, 0);
		leg1.addBox(0F, -1F, -1F, 6, 2, 2, 0F);
		leg1.setRotationPoint(8F, 23F, 7F);
		
		leg1.rotateAngleX = 0F;
		leg1.rotateAngleY = 0F;
		leg1.rotateAngleZ = 0F;
		leg1.mirror = false;
		
		leg2 = new ModelRenderer(this,0, 0);
		leg2.addBox(0F, -1F, -1F, 6, 2, 2, 0F);
		leg2.setRotationPoint(8F, 23F, -7F);
		
		leg2.rotateAngleX = 0F;
		leg2.rotateAngleY = 0F;
		leg2.rotateAngleZ = 0F;
		leg2.mirror = false;
		
		leg3 = new ModelRenderer(this,0, 0);
		leg3.addBox(-6F, -1F, -1F, 6, 2, 2, 0F);
		leg3.setRotationPoint(-8F, 23F, 7F);
		
		leg3.rotateAngleX = 0F;
		leg3.rotateAngleY = 0F;
		leg3.rotateAngleZ = 0F;
		leg3.mirror = false;
		
		leg4 = new ModelRenderer(this,0, 0);
		leg4.addBox(-6F, -1F, -1F, 6, 2, 2, 0F);
		leg4.setRotationPoint(-8F, 23F, -7F);
		
		leg4.rotateAngleX = 0F;
		leg4.rotateAngleY = 0F;
		leg4.rotateAngleZ = 0F;
		leg4.mirror = false;
		
		temper = new ModelRenderer(this,0, 0);
		temper.addBox(0F, 0F, 0F, 16, 16, 16, 0F);
		temper.setRotationPoint(-8F, 8F, -8F);
		
		temper.rotateAngleX = 0F;
		temper.rotateAngleY = 0F;
		temper.rotateAngleZ = 0F;
		temper.mirror = false;
		
		
	}

	public void render(Entity entity,float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity,f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		temper.render(f5);
		
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
	public ModelRenderer leg1;
	public ModelRenderer leg2;
	public ModelRenderer leg3;
	public ModelRenderer leg4;
	public ModelRenderer temper;
	
}
