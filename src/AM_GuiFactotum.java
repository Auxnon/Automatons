// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerFurnace, FontRenderer, RenderEngine, 
//            TileEntityFurnace, InventoryPlayer

public class AM_GuiFactotum extends GuiContainer
{

    public AM_GuiFactotum(InventoryPlayer inventoryplayer, AM_EntityFactotum tileentityfurnace)
    {
        super(new AM_ContainerFactotum(inventoryplayer, tileentityfurnace));
        furnaceInventory = tileentityfurnace;
    }

    protected void drawGuiContainerForegroundLayer()
    {
        //fontRenderer.drawString("Factotum", 60, 6, 0x000000);
		fontRenderer.drawString("Furnace", 12, 6, 0xD14600);
		fontRenderer.drawString("Chest", 110, 6, 0x8C7632);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f)
    {
        int i = mc.renderEngine.getTexture("/automatons/Factotumg.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
        if(furnaceInventory.isBurningStuff())
        {
            int l = furnaceInventory.getBurnTimeRemainingScaled(12);
			//System.out.println(l);
            drawTexturedModalRect(j + 26, (k + 36 + 12) - l, 176, 12 - l, 14, l + 2);//26 56
        }
        int i1 = furnaceInventory.getCookProgressScaled(24);
        drawTexturedModalRect(j + 55, k + 34, 176, 14, i1 + 1, 16);//55 79
    }

    private AM_EntityFactotum furnaceInventory;
}
