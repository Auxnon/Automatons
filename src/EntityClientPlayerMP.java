// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayerSP, MathHelper, World, Packet19EntityAction, 
//            NetClientHandler, AxisAlignedBB, Packet11PlayerPosition, Packet13PlayerLookMove, 
//            Packet12PlayerLook, Packet10Flying, Packet14BlockDig, Packet3Chat, 
//            Packet18Animation, Packet9Respawn, Packet101CloseWindow, Container, 
//            InventoryPlayer, StatBase, Session, DamageSource, 
//            EntityItem

public class EntityClientPlayerMP extends EntityPlayerSP
{

    public EntityClientPlayerMP(Minecraft minecraft, World world, Session session, NetClientHandler netclienthandler)
    {
        super(minecraft, world, session, 0);
        field_9380_bx = 0;
        field_21093_bH = false;
        field_9382_bF = false;
        field_35227_cs = false;
        wasSneaking = false;
        field_12242_bI = 0;
        sendQueue = netclienthandler;
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        return false;
    }

    public void heal(int i)
    {
    }

    public void onUpdate()
    {
        worldObj.getClass();
        if(!worldObj.blockExists(MathHelper.floor_double(posX), 128 / 2, MathHelper.floor_double(posZ)))
        {
            return;
        } else
        {
            super.onUpdate();
            onUpdate2();
            return;
        }
    }

    public void onUpdate2()
    {
        if(field_9380_bx++ == 20)
        {
            sendInventoryChanged();
            field_9380_bx = 0;
        }
        boolean flag = func_35117_Q();
        if(flag != wasSneaking)
        {
            if(flag)
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 4));
            } else
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 5));
            }
            wasSneaking = flag;
        }
        boolean flag1 = isSneaking();
        if(flag1 != field_35227_cs)
        {
            if(flag1)
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 1));
            } else
            {
                sendQueue.addToSendQueue(new Packet19EntityAction(this, 2));
            }
            field_35227_cs = flag1;
        }
        double d = posX - oldPosX;
        double d1 = boundingBox.minY - field_9378_bz;
        double d2 = posY - oldPosY;
        double d3 = posZ - oldPosZ;
        double d4 = rotationYaw - oldRotationYaw;
        double d5 = rotationPitch - oldRotationPitch;
        boolean flag2 = d1 != 0.0D || d2 != 0.0D || d != 0.0D || d3 != 0.0D;
        boolean flag3 = d4 != 0.0D || d5 != 0.0D;
        if(ridingEntity != null)
        {
            if(flag3)
            {
                sendQueue.addToSendQueue(new Packet11PlayerPosition(motionX, -999D, -999D, motionZ, onGround));
            } else
            {
                sendQueue.addToSendQueue(new Packet13PlayerLookMove(motionX, -999D, -999D, motionZ, rotationYaw, rotationPitch, onGround));
            }
            flag2 = false;
        } else
        if(flag2 && flag3)
        {
            sendQueue.addToSendQueue(new Packet13PlayerLookMove(posX, boundingBox.minY, posY, posZ, rotationYaw, rotationPitch, onGround));
            field_12242_bI = 0;
        } else
        if(flag2)
        {
            sendQueue.addToSendQueue(new Packet11PlayerPosition(posX, boundingBox.minY, posY, posZ, onGround));
            field_12242_bI = 0;
        } else
        if(flag3)
        {
            sendQueue.addToSendQueue(new Packet12PlayerLook(rotationYaw, rotationPitch, onGround));
            field_12242_bI = 0;
        } else
        {
            sendQueue.addToSendQueue(new Packet10Flying(onGround));
            if(field_9382_bF != onGround || field_12242_bI > 200)
            {
                field_12242_bI = 0;
            } else
            {
                field_12242_bI++;
            }
        }
        field_9382_bF = onGround;
        if(flag2)
        {
            oldPosX = posX;
            field_9378_bz = boundingBox.minY;
            oldPosY = posY;
            oldPosZ = posZ;
        }
        if(flag3)
        {
            oldRotationYaw = rotationYaw;
            oldRotationPitch = rotationPitch;
        }
    }

    public void dropCurrentItem()
    {
        sendQueue.addToSendQueue(new Packet14BlockDig(4, 0, 0, 0, 0));
    }

    private void sendInventoryChanged()
    {
    }

    protected void joinEntityItemWithWorld(EntityItem entityitem)
    {
    }

    public void sendChatMessage(String s)
    {
        sendQueue.addToSendQueue(new Packet3Chat(s));
    }

    public void swingItem()
    {
        super.swingItem();
        sendQueue.addToSendQueue(new Packet18Animation(this, 1));
    }

    public void respawnPlayer()
    {
        sendInventoryChanged();
        worldObj.getClass();
        sendQueue.addToSendQueue(new Packet9Respawn((byte)dimension, (byte)worldObj.difficultySetting, worldObj.getRandomSeed(), 128, 0));
    }

    protected void b(DamageSource damagesource, int i)
    {
        health -= i;
    }

    public void closeScreen()
    {
        sendQueue.addToSendQueue(new Packet101CloseWindow(craftingInventory.windowId));
        inventory.setItemStack(null);
        super.closeScreen();
    }

    public void setHealth(int i)
    {
        if(field_21093_bH)
        {
            super.setHealth(i);
        } else
        {
            health = i;
            field_21093_bH = true;
        }
    }

    public void addStat(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(statbase.isIndependent)
        {
            super.addStat(statbase, i);
        }
    }

    public void func_27027_b(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(!statbase.isIndependent)
        {
            super.addStat(statbase, i);
        }
    }

    public NetClientHandler sendQueue;
    private int field_9380_bx;
    private boolean field_21093_bH;
    private double oldPosX;
    private double field_9378_bz;
    private double oldPosY;
    private double oldPosZ;
    private float oldRotationYaw;
    private float oldRotationPitch;
    private boolean field_9382_bF;
    private boolean field_35227_cs;
    private boolean wasSneaking;
    private int field_12242_bI;
}
