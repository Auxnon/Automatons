// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemFood, EntityPlayer, World, DamageSource, 
//            NBTTagCompound

public class FoodStats
{

    public FoodStats()
    {
        foodTickTimer = 0;
        foodLevel = 20;
        field_35773_e = 20;
        foodSaturationLevel = 5F;
    }

    public void func_35771_a(int i, float f)
    {
        foodLevel = Math.min(i + foodLevel, 20);
        foodSaturationLevel = Math.min(foodSaturationLevel + (float)i * f * 2.0F, foodLevel);
    }

    public void func_35761_a(ItemFood itemfood)
    {
        func_35771_a(itemfood.getHealAmount(), itemfood.func_35426_m());
    }

    public void func_35768_a(EntityPlayer entityplayer)
    {
        int i = entityplayer.worldObj.difficultySetting;
        field_35773_e = foodLevel;
        if(foodExhaustionLevel > 4F)
        {
            foodExhaustionLevel -= 4F;
            if(foodSaturationLevel > 0.0F)
            {
                foodSaturationLevel = Math.max(foodSaturationLevel - 1.0F, 0.0F);
            } else
            if(i > 0)
            {
                foodLevel = Math.max(foodLevel - 1, 0);
            }
        }
        if(foodLevel >= 18 && entityplayer.shouldHeal())
        {
            foodTickTimer++;
            if(foodTickTimer >= 80)
            {
                entityplayer.heal(1);
                foodTickTimer = 0;
            }
        } else
        if(foodLevel <= 0)
        {
            foodTickTimer++;
            if(foodTickTimer >= 80)
            {
                if(entityplayer.health > 10 || i >= 3 || entityplayer.health > 1 && i >= 2)
                {
                    entityplayer.attackEntityFrom(DamageSource.starve, 1);
                }
                foodTickTimer = 0;
            }
        } else
        {
            foodTickTimer = 0;
        }
    }

    public void readStatsFromNBT(NBTTagCompound nbttagcompound)
    {
        if(nbttagcompound.hasKey("foodLevel"))
        {
            foodLevel = nbttagcompound.getInteger("foodLevel");
            foodTickTimer = nbttagcompound.getInteger("foodTickTimer");
            foodSaturationLevel = nbttagcompound.getFloat("foodSaturationLevel");
            foodExhaustionLevel = nbttagcompound.getFloat("foodExhaustionLevel");
        }
    }

    public void writeStatsToNBT(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setInteger("foodLevel", foodLevel);
        nbttagcompound.setInteger("foodTickTimer", foodTickTimer);
        nbttagcompound.setFloat("foodSaturationLevel", foodSaturationLevel);
        nbttagcompound.setFloat("foodExhaustionLevel", foodExhaustionLevel);
    }

    public int getFoodLevel()
    {
        return foodLevel;
    }

    public int func_35769_b()
    {
        return field_35773_e;
    }

    public boolean func_35770_c()
    {
        return foodLevel < 20;
    }

    public void func_35762_a(float f)
    {
        foodExhaustionLevel = Math.min(foodExhaustionLevel + f, 40F);
    }

    public float getFoodSaturationLevel()
    {
        return foodSaturationLevel;
    }

    public void setFoodLevel(int i)
    {
        foodLevel = i;
    }

    public void setFoodSaturationLevel(float f)
    {
        foodSaturationLevel = f;
    }

    private int foodLevel;
    private float foodSaturationLevel;
    private float foodExhaustionLevel;
    private int foodTickTimer;
    private int field_35773_e;
}
