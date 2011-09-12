// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, Item, EntityPlayer, InventoryPlayer, 
//            ItemStack, World, NBTTagCompound

public class AM_EntityBeacon extends EntityLiving
{

    public AM_EntityBeacon(World world)
    {
        super(world);
        setSize(0.3F, 1F);
		health=1;
		siren=0;
    }
	
	public AM_EntityBeacon(World world, double d, double d1, double d2,String s){
        this(world);
        setPosition(d, d1 + (double)yOffset, d2);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = d;
        prevPosY = d1;
        prevPosZ = d2;
		setBotOwner(s);
    }
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	public void onLivingUpdate(){
	}
	/*protected void entityInit()
    {
    }*/
	public String getEntityTexture()
    {
        switch(getSiren()){
			case 1:return "/automatons/beac1.png";
			case 2: return "/automatons/beac2.png";
			default: return "/automatons/beac.png";
			}
    }
	
	protected void entityInit(){
        super.entityInit();
        dataWatcher.addObject(17, ""); //owner
        dataWatcher.addObject(18, new Integer(siren)); //health
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
		if(getBotOwner() == null)
        {
            nbttagcompound.setString("Owner", "");
        } else
        {
            nbttagcompound.setString("Owner", getBotOwner());
			//System.out.println("owned");
        }
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
		String s = nbttagcompound.getString("Owner");
        if(s.length() > 0)
        {
            setBotOwner(s);
        }
    }
/*
    protected String getLivingSound()
    {
        return "mob.cow";
    }
*/
    protected String getHurtSound()
    {
        return "";
    }

    protected String getDeathSound()
    {
        return "";
    }

    protected float getSoundVolume()
    {
        return 0.4F;
    }
	
	protected void dropFewItems(){
	
	for(int j = 0; j < 20; j++)
                {
                    double d = rand.nextGaussian() * 0.02D;
                    double d1 = rand.nextGaussian() * 0.02D;
                    double d2 = rand.nextGaussian() * 0.02D;
                    worldObj.spawnParticle("explode", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
                }
			if(!worldObj.multiplayerWorld){	
        entityDropItem(new ItemStack(AutomatonLogger.beacon+256, 1,0), 0.0F);
		setEntityDead();
		}
    }
		
    /*protected int getDropItemId()
    {
        return 0;
    }*/

    public boolean interact(EntityPlayer entityplayer)
    {
	
		if(entityplayer.username.equalsIgnoreCase(getBotOwner())){
		
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if(itemstack != null && itemstack.itemID == Item.stick.shiftedIndex)
        {
			if(!worldObj.multiplayerWorld){
				setSiren(2);
			}
            
        }else{
			if(!worldObj.multiplayerWorld){
				if(getSiren()!=0){
					setSiren(0);
				}else{
					setSiren(1);
				}
			}
		}
		return true;
		}
		return false;
    }
	public String getBotOwner()
    {
        return dataWatcher.getWatchableObjectString(17);
    }
	public EntityLiving reallyGetBotOwner(){
		return (EntityLiving) worldObj.getPlayerEntityByName(getBotOwner());
	}

    public void setBotOwner(String s)
    {
        dataWatcher.updateObject(17, s);
    }
	
	public void setSiren(int b){
		siren=b;
		dataWatcher.updateObject(18, b);
		
	}
	public int getSiren(){
		return dataWatcher.getWatchableObjectInt(18);
	}
	protected int siren;
	//protected String texture;
}
