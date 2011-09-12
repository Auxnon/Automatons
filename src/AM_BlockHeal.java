// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, World

public class AM_BlockHeal extends Block
{

    protected AM_BlockHeal(int i)
    {
        super(i, Material.grassMaterial);
        blockIndexInTexture = 130;
        setTickOnLoad(true);
		//slipperiness = 1.50F;
    }

	static int D;
	static void loadSprites(){
	
		D=ModLoader.addOverride("/terrain.png", "/automatons/thing.png");
		
		//blockIndexInTexture=D;
	}
	
	/*public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBoxFromPool(i, j, k, i + 1, (float)(j + 1) - f, k + 1);
    }*/
	
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
	/*if(entity.motionX!=0 &&entity.motionZ!=0){
		float r=(float)Math.sqrt(entity.motionX*entity.motionX+entity.motionZ*entity.motionZ);
        entity.motionX = 0.2F*entity.motionX/r;
        entity.motionZ = 0.2F*entity.motionZ/r;
		}*/
		//entity.motionX=-MathHelper.sin(entity.rotationYaw*0.0175F)*0.2F;
		//entity.motionZ=MathHelper.cos(entity.rotationYaw*0.0175F)*0.2F;
		//entity.fallDistance=-10;
		//entity.motionY=0.75F;
		//entity.motionZ*=1.2F;
		//entity.motionX*=1.2F;
		
		
		if( entity instanceof EntityLiving){
		
		int l=world.getBlockMetadata(i,j,k);
		if(l>0){
		world.spawnParticle("heart", i+0.5F, j+0.5F, k+0.5F, 0, 0.4F, 0);
		((EntityLiving)entity).heal(l);
		
		world.setBlockAndMetadataWithNotify(i,j,k,blockID,0);
		}
		}
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }
	
    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return D; //top
        }
        
        return 0; //side
    }
	
	public void setBlockBoundsForItemRender()
    {
        float f = 0.5F;
        float f1 = 0.125F;
        float f2 = 0.5F;
        setBlockBounds(0.5F - f, 0.5F - f1, 0.5F - f2, 0.5F + f, 0.5F + f1, 0.5F + f2);
    }
	
	public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        //float f = 0.125F;
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F , 0.0625F, 1.0F );
        
    }
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }

	
	int ferp[]={

	0x1C0306,
	0x2B050A,
	0x400B12,
	0x521119,
	0x611620,
	0x752731,
	0x8F3843,
	0xA84753,
	0xB35662,
	0xC96D79,
	0xDE909B,
	0xE0A4AC,
	0xF0B4BC,
	0xFAACC0,
	0xFFC9D7};
    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        //iblockaccess.getWorldChunkManager().func_4069_a(i, k, 1, 1);
        //double d = iblockaccess.getWorldChunkManager().temperature[0];
        //double d1 = iblockaccess.getWorldChunkManager().humidity[0];
		
		
        return ferp[iblockaccess.getBlockMetadata(i,j,k)];//ColorizerGrass.getGrassColor(d, d1);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
	
	int l=world.getBlockMetadata(i,j,k);
	if(l<14){
	world.setBlockAndMetadataWithNotify(i,j,k,blockID,l+1);
	}
       /* if(world.multiplayerWorld)
        {
            return;
        }
        if(world.getBlockLightValue(i, j + 1, k) < 4 && Block.lightOpacity[world.getBlockId(i, j + 1, k)] > 2)
        {
            if(random.nextInt(4) != 0)
            {
                return;
            }
            world.setBlockWithNotify(i, j, k, Block.dirt.blockID);
        } else
        if(world.getBlockLightValue(i, j + 1, k) >= 9)
        {
            int l = (i + random.nextInt(3)) - 1;
            int i1 = (j + random.nextInt(5)) - 3;
            int j1 = (k + random.nextInt(3)) - 1;
            int k1 = world.getBlockId(l, i1 + 1, j1);
            if(world.getBlockId(l, i1, j1) == Block.dirt.blockID && world.getBlockLightValue(l, i1 + 1, j1) >= 4 && Block.lightOpacity[k1] <= 2)
            {
                world.setBlockWithNotify(l, i1, j1, Block.grass.blockID);
            }
        }*/
    }

    /*public int idDropped(int i, Random random)
    {
        return Block.dirt.idDropped(0, random);
    }*/
}
