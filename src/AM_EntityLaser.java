// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Entity, AxisAlignedBB, MathHelper, EntityLiving, 
//            World, Vec3D, MovingObjectPosition, NBTTagCompound

public class AM_EntityLaser extends Entity
{

    public AM_EntityLaser(World world)
    {
        super(world);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inGround = false;
        shake = 0;
        ticksFlying = 0;
        setSize(0.2F, 0.2F);
    }

    protected void entityInit()
    {
    }

    public boolean isInRangeToRenderDist(double d)
    {
        double d1 = AutomatonUniversal.anotherAxisFunc(boundingBox);
        d1 *= 64D;
        return d < d1 * d1;
    }

    public AM_EntityLaser(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(world);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inGround = false;
        shake = 0;
        ticksFlying = 0;
        setSize(0.2F, 0.2F);
        setLocationAndAngles(d, d1, d2, rotationYaw, rotationPitch);
        setPosition(d, d1, d2);
        double d6 = MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
        accelerationX = (d3 / d6) * 0.10000000000000001D;
        accelerationY = (d4 / d6) * 0.10000000000000001D;
        accelerationZ = (d5 / d6) * 0.10000000000000001D;
    }

    public AM_EntityLaser(World world, EntityLiving entityliving, double d, double d1, double d2,double accuracy)
    {
        super(world);
        xTile = -1;
        yTile = -1;
        zTile = -1;
        inTile = 0;
        inGround = false;
        shake = 0;
        ticksFlying = 0;
        shootingEntity = entityliving;
        setSize(0.2F, 0.2F);
        setLocationAndAngles(entityliving.posX, entityliving.posY, entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
        setPosition(posX, posY, posZ);
        yOffset = 0.0F;
        motionX = motionY = motionZ = 0.0D;
		//double accuracy=0.2D;
        d += rand.nextGaussian() * accuracy;
        d1 += rand.nextGaussian() * accuracy;
        d2 += rand.nextGaussian() * accuracy;
        double d3 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
        accelerationX = (d / d3) * 0.50000000000000001D;
        accelerationY = (d1 / d3) * 0.50000000000000001D;
        accelerationZ = (d2 / d3) * 0.50000000000000001D;
    }

    public void onUpdate()
    {
        super.onUpdate();
        //fire = 10;
        if(shake > 0)
        {
            shake--;
        }
        if(inGround)
        {
            int i = worldObj.getBlockId(xTile, yTile, zTile);
            if(i != inTile)
            {
                inGround = false;
                motionX *= rand.nextFloat() * 0.2F;
                motionY *= rand.nextFloat() * 0.2F;
                motionZ *= rand.nextFloat() * 0.2F;
                ticksAlive = 0;
                ticksFlying = 0;
            } else
            {
                ticksAlive++;
                if(ticksAlive == 1200)
                {
                    setEntityDead();
                }
                return;
            }
        } else
        {
            ticksFlying++;
        }
        Vec3D vec3d = Vec3D.createVector(posX, posY, posZ);
        Vec3D vec3d1 = Vec3D.createVector(posX + motionX, posY + motionY, posZ + motionZ);
        MovingObjectPosition movingobjectposition = worldObj.rayTraceBlocks(vec3d, vec3d1);
        vec3d = Vec3D.createVector(posX, posY, posZ);
        vec3d1 = Vec3D.createVector(posX + motionX, posY + motionY, posZ + motionZ);
        if(movingobjectposition != null)
        {
            vec3d1 = Vec3D.createVector(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
        }
        Entity entity = null;
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));
        double d = 0.0D;
        for(int j = 0; j < list.size(); j++)
        {
            Entity entity1 = (Entity)list.get(j);
            if(!entity1.canBeCollidedWith() || entity1 == shootingEntity && ticksFlying < 25)
            {
                continue;
            }
            float f2 = 0.3F;
            AxisAlignedBB axisalignedbb = entity1.boundingBox.expand(f2, f2, f2);
            MovingObjectPosition movingobjectposition1 = AutomatonUniversal.axisFunc(axisalignedbb,vec3d,vec3d1);
            if(movingobjectposition1 == null)
            {
                continue;
            }
            double d1 = vec3d.distanceTo(movingobjectposition1.hitVec);
            if(d1 < d || d == 0.0D)
            {
                entity = entity1;
                d = d1;
            }
        }

        if(entity != null)
        {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if(movingobjectposition != null)
        {
            if(!AutomatonUniversal.otherWorld(worldObj))
            {
                if(movingobjectposition.entityHit != null)
                {
                    //if(!movingobjectposition.entityHit.attackEntityFrom(shootingEntity, 2));
                }
                //worldObj.newExplosion(null, posX, posY, posZ, 1.0F, true);
            }
			for(int j = 0; j < 5; j++)
                {
                    double dh = rand.nextGaussian() * 0.1D;
                    double dh1 = rand.nextGaussian() * 0.1D;
                    double dh2 = rand.nextGaussian() * 0.1D;
                    worldObj.spawnParticle("largesmoke", (posX + (double)(rand.nextFloat() * 2.0F))-1F, posY + (double)(rand.nextFloat() * 2.0F)-1F, (posZ + (double)(rand.nextFloat() *  2.0F))-1F, dh, dh1, dh2);
                }
				
            setEntityDead();
        }
        posX += motionX;
        posY += motionY;
        posZ += motionZ;
        float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
        rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / 3.1415927410125732D);
        for(rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / 3.1415927410125732D); rotationPitch - prevRotationPitch < -180F; prevRotationPitch -= 360F) { }
        for(; rotationPitch - prevRotationPitch >= 180F; prevRotationPitch += 360F) { }
        for(; rotationYaw - prevRotationYaw < -180F; prevRotationYaw -= 360F) { }
        for(; rotationYaw - prevRotationYaw >= 180F; prevRotationYaw += 360F) { }
        rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F;
        rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F;
        float f1 = 0.95F;
        if(isInWater())
        {
            for(int k = 0; k < 4; k++)
            {
                float f3 = 0.25F;
                worldObj.spawnParticle("bubble", posX - motionX * (double)f3, posY - motionY * (double)f3, posZ - motionZ * (double)f3, motionX, motionY, motionZ);
            }

            f1 = 0.8F;
        }
        motionX += accelerationX;
        motionY += accelerationY;
        motionZ += accelerationZ;
        motionX *= f1;
        motionY *= f1;
        motionZ *= f1;
        worldObj.spawnParticle("reddust", posX, posY + 0.5D, posZ, 0.0D, 0.0D, 0.0D);
        setPosition(posX, posY, posZ);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setShort("xTile", (short)xTile);
        nbttagcompound.setShort("yTile", (short)yTile);
        nbttagcompound.setShort("zTile", (short)zTile);
        nbttagcompound.setByte("inTile", (byte)inTile);
        nbttagcompound.setByte("shake", (byte)shake);
        nbttagcompound.setByte("inGround", (byte)(inGround ? 1 : 0));
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        xTile = nbttagcompound.getShort("xTile");
        yTile = nbttagcompound.getShort("yTile");
        zTile = nbttagcompound.getShort("zTile");
        inTile = nbttagcompound.getByte("inTile") & 0xff;
        shake = nbttagcompound.getByte("shake") & 0xff;
        inGround = nbttagcompound.getByte("inGround") == 1;
    }

    public boolean canBeCollidedWith()
    {
        return true;
    }

    public float getCollisionBorderSize()
    {
        return 1.0F;
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        setBeenAttacked();
        if(entity != null)
        {
            Vec3D vec3d = entity.getLookVec();
            if(vec3d != null)
            {
                motionX = vec3d.xCoord;
                motionY = vec3d.yCoord;
                motionZ = vec3d.zCoord;
                accelerationX = motionX * 0.10000000000000001D;
                accelerationY = motionY * 0.10000000000000001D;
                accelerationZ = motionZ * 0.10000000000000001D;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public float getShadowSize()
    {
        return 0.0F;
    }

    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private boolean inGround;
    public int shake;
    public EntityLiving shootingEntity;
    private int ticksAlive;
    private int ticksFlying;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
}
