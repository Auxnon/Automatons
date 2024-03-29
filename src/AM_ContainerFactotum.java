// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, Slot, SlotFurnace, InventoryPlayer, 
//            ICrafting, TileEntityFurnace, ItemStack, EntityPlayer

public class AM_ContainerFactotum extends Container
{

    public AM_ContainerFactotum(InventoryPlayer inventoryplayer, AM_EntityFactotum tileentityfurnace)
    {
        cookTime = 0;
        burnTime = 0;
        itemBurnTime = 0;
        furnace = tileentityfurnace;
        //addSlot(new Slot(tileentityfurnace, 0, 56, 17));
        //addSlot(new Slot(tileentityfurnace, 1, 56, 53));
        //addSlot(new SlotFurnace(inventoryplayer.player, tileentityfurnace, 2, 116, 35));
		
		addSlot(new Slot(tileentityfurnace, 0, 8, 17));
		addSlot(new Slot(tileentityfurnace, 1, 26, 17));
		addSlot(new Slot(tileentityfurnace, 2, 44, 17));
		
		addSlot(new Slot(tileentityfurnace, 3, 8, 53));
		addSlot(new Slot(tileentityfurnace, 4, 26, 53));
		addSlot(new Slot(tileentityfurnace, 5, 44, 53));
		
		
		for(int x=0;x<3;x++){
		for(int y=0;y<5;y++){
		addSlot(new Slot(tileentityfurnace, 6+y+x*5, 80+y*18, 17+x*18));
		}
		}
		//addSlot(new Slot(tileentityfurnace, 0, 80, 17));

		
		
		
		
		
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                addSlot(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            addSlot(new Slot(inventoryplayer, j, 8 + j * 18, 142));
        }

    }
	
	/*
	public void onCraftGuiOpened(ICrafting icrafting)
    {
        super.onCraftGuiOpened(icrafting);
        icrafting.updateCraftingInventoryInfo(this, 0, furnace.furnaceCookTime);
        icrafting.updateCraftingInventoryInfo(this, 1, furnace.furnaceBurnTime);
        icrafting.updateCraftingInventoryInfo(this, 2, furnace.currentItemBurnTime);
    }*/

    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        for(int i = 0; i < crafters.size(); i++)
        {
            ICrafting icrafting = (ICrafting)crafters.get(i);
            if(cookTime != furnace.furnaceCookTime)
            {
                icrafting.updateCraftingInventoryInfo(this, 0, furnace.furnaceCookTime);
            }
            if(burnTime != furnace.furnaceBurnTime)
            {
                icrafting.updateCraftingInventoryInfo(this, 1, furnace.furnaceBurnTime);
            }
            if(itemBurnTime != furnace.currentItemBurnTime)
            {
                icrafting.updateCraftingInventoryInfo(this, 2, furnace.currentItemBurnTime);
            }
        }

        cookTime = furnace.furnaceCookTime;
        burnTime = furnace.furnaceBurnTime;
        itemBurnTime = furnace.currentItemBurnTime;
    }

    public void func_20112_a(int i, int j)
    {
        if(i == 0)
        {
            furnace.furnaceCookTime = j;
        }
        if(i == 1)
        {
            furnace.furnaceBurnTime = j;
        }
        if(i == 2)
        {
            furnace.currentItemBurnTime = j;
        }
    }

	
	public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return furnace.canInteractWith(entityplayer);
    }
	

    public ItemStack getStackInSlot(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(i);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(i == 2)
            {
                func_28125_a(itemstack1, 3, 39, true);
            } else
            if(i >= 3 && i < 30)
            {
                func_28125_a(itemstack1, 30, 39, false);
            } else
            if(i >= 30 && i < 39)
            {
                func_28125_a(itemstack1, 3, 30, false);
            } else
            {
                func_28125_a(itemstack1, 3, 39, false);
            }
            if(itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            } else
            {
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(itemstack1);
            } else
            {
                return null;
            }
        }
        return itemstack;
    }

    private AM_EntityFactotum furnace;
    private int cookTime;
    private int burnTime;
    private int itemBurnTime;
}
