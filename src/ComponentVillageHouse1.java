// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentVillageHouse1 extends ComponentVillage
{

    public ComponentVillageHouse1(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35096_a = -1;
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static ComponentVillageHouse1 func_35095_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, 0, 0, 0, 9, 9, 6, l);
        if(!func_35074_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageHouse1(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(field_35096_a < 0)
        {
            field_35096_a = func_35075_b(world, structureboundingbox);
            if(field_35096_a < 0)
            {
                return true;
            }
            field_35024_g.func_35745_a(0, ((field_35096_a - field_35024_g.field_35750_e) + 9) - 1, 0);
        }
        func_35011_a(world, structureboundingbox, 1, 1, 1, 7, 5, 4, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 0, 0, 8, 0, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 5, 0, 8, 5, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 6, 1, 8, 6, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 7, 2, 8, 7, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        int i = func_35009_c(Block.stairCompactPlanks.blockID, 3);
        int j = func_35009_c(Block.stairCompactPlanks.blockID, 2);
        for(int k = -1; k <= 2; k++)
        {
            for(int i1 = 0; i1 <= 8; i1++)
            {
                func_35018_a(world, Block.stairCompactPlanks.blockID, i, i1, 6 + k, k, structureboundingbox);
                func_35018_a(world, Block.stairCompactPlanks.blockID, j, i1, 6 + k, 5 - k, structureboundingbox);
            }

        }

        func_35011_a(world, structureboundingbox, 0, 1, 0, 0, 1, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 1, 5, 8, 1, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 8, 1, 0, 8, 1, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 2, 1, 0, 7, 1, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 2, 0, 0, 4, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 2, 5, 0, 4, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 8, 2, 5, 8, 4, 5, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 8, 2, 0, 8, 4, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 2, 1, 0, 4, 4, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 2, 5, 7, 4, 5, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 8, 2, 1, 8, 4, 4, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 2, 0, 7, 4, 0, Block.planks.blockID, Block.planks.blockID, false);
        func_35018_a(world, Block.thinGlass.blockID, 0, 4, 2, 0, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 5, 2, 0, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 6, 2, 0, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 4, 3, 0, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 5, 3, 0, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 6, 3, 0, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 2, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 2, 3, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 3, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 3, 3, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 8, 2, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 8, 2, 3, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 8, 3, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 8, 3, 3, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 2, 2, 5, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 3, 2, 5, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 5, 2, 5, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 6, 2, 5, structureboundingbox);
        func_35011_a(world, structureboundingbox, 1, 4, 1, 7, 4, 1, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 4, 4, 7, 4, 4, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 3, 4, 7, 3, 4, Block.bookShelf.blockID, Block.bookShelf.blockID, false);
        func_35018_a(world, Block.planks.blockID, 0, 7, 1, 4, structureboundingbox);
        func_35018_a(world, Block.stairCompactPlanks.blockID, func_35009_c(Block.stairCompactPlanks.blockID, 0), 7, 1, 3, structureboundingbox);
        int l = func_35009_c(Block.stairCompactPlanks.blockID, 3);
        func_35018_a(world, Block.stairCompactPlanks.blockID, l, 6, 1, 4, structureboundingbox);
        func_35018_a(world, Block.stairCompactPlanks.blockID, l, 5, 1, 4, structureboundingbox);
        func_35018_a(world, Block.stairCompactPlanks.blockID, l, 4, 1, 4, structureboundingbox);
        func_35018_a(world, Block.stairCompactPlanks.blockID, l, 3, 1, 4, structureboundingbox);
        func_35018_a(world, Block.fence.blockID, 0, 6, 1, 3, structureboundingbox);
        func_35018_a(world, Block.pressurePlatePlanks.blockID, 0, 6, 2, 3, structureboundingbox);
        func_35018_a(world, Block.fence.blockID, 0, 4, 1, 3, structureboundingbox);
        func_35018_a(world, Block.pressurePlatePlanks.blockID, 0, 4, 2, 3, structureboundingbox);
        func_35018_a(world, Block.workbench.blockID, 0, 7, 1, 1, structureboundingbox);
        func_35018_a(world, 0, 0, 1, 1, 0, structureboundingbox);
        func_35018_a(world, 0, 0, 1, 2, 0, structureboundingbox);
        func_35002_a(world, structureboundingbox, random, 1, 1, 0, func_35009_c(Block.doorWood.blockID, 1));
        if(func_35007_a(world, 1, 0, -1, structureboundingbox) == 0 && func_35007_a(world, 1, -1, -1, structureboundingbox) != 0)
        {
            func_35018_a(world, Block.stairCompactCobblestone.blockID, func_35009_c(Block.stairCompactCobblestone.blockID, 3), 1, 0, -1, structureboundingbox);
        }
        for(int j1 = 0; j1 < 6; j1++)
        {
            for(int k1 = 0; k1 < 9; k1++)
            {
                func_35016_b(world, k1, 9, j1, structureboundingbox);
                func_35005_b(world, Block.cobblestone.blockID, 0, k1, -1, j1, structureboundingbox);
            }

        }

        return true;
    }

    private int field_35096_a;
}
