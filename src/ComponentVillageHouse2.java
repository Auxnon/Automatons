// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentVillageHouse2 extends ComponentVillage
{

    public ComponentVillageHouse2(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35086_a = -1;
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static ComponentVillageHouse2 func_35085_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, 0, 0, 0, 10, 6, 7, l);
        if(!func_35074_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageHouse2(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(field_35086_a < 0)
        {
            field_35086_a = func_35075_b(world, structureboundingbox);
            if(field_35086_a < 0)
            {
                return true;
            }
            field_35024_g.func_35745_a(0, ((field_35086_a - field_35024_g.field_35750_e) + 6) - 1, 0);
        }
        func_35011_a(world, structureboundingbox, 0, 1, 0, 9, 4, 6, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 0, 0, 9, 0, 6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 4, 0, 9, 4, 6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 5, 0, 9, 5, 6, Block.stairSingle.blockID, Block.stairSingle.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 5, 1, 8, 5, 5, 0, 0, false);
        func_35011_a(world, structureboundingbox, 1, 1, 0, 2, 3, 0, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 1, 0, 0, 4, 0, Block.wood.blockID, Block.wood.blockID, false);
        func_35011_a(world, structureboundingbox, 3, 1, 0, 3, 4, 0, Block.wood.blockID, Block.wood.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 1, 6, 0, 4, 6, Block.wood.blockID, Block.wood.blockID, false);
        func_35018_a(world, Block.planks.blockID, 0, 3, 3, 1, structureboundingbox);
        func_35011_a(world, structureboundingbox, 3, 1, 2, 3, 3, 2, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 4, 1, 3, 5, 3, 3, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 1, 1, 0, 3, 5, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 1, 6, 5, 3, 6, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 5, 1, 0, 5, 3, 0, Block.fence.blockID, Block.fence.blockID, false);
        func_35011_a(world, structureboundingbox, 9, 1, 0, 9, 3, 0, Block.fence.blockID, Block.fence.blockID, false);
        func_35011_a(world, structureboundingbox, 6, 1, 4, 9, 4, 6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35018_a(world, Block.lavaMoving.blockID, 0, 7, 1, 5, structureboundingbox);
        func_35018_a(world, Block.lavaMoving.blockID, 0, 8, 1, 5, structureboundingbox);
        func_35018_a(world, Block.fenceIron.blockID, 0, 9, 2, 5, structureboundingbox);
        func_35018_a(world, Block.fenceIron.blockID, 0, 9, 2, 4, structureboundingbox);
        func_35011_a(world, structureboundingbox, 7, 2, 4, 8, 2, 5, 0, 0, false);
        func_35018_a(world, Block.cobblestone.blockID, 0, 6, 1, 3, structureboundingbox);
        func_35018_a(world, Block.stoneOvenIdle.blockID, 0, 6, 2, 3, structureboundingbox);
        func_35018_a(world, Block.stoneOvenIdle.blockID, 0, 6, 3, 3, structureboundingbox);
        func_35018_a(world, Block.stairDouble.blockID, 0, 8, 1, 1, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 2, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 2, 4, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 2, 2, 6, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 4, 2, 6, structureboundingbox);
        func_35018_a(world, Block.fence.blockID, 0, 2, 1, 4, structureboundingbox);
        func_35018_a(world, Block.pressurePlatePlanks.blockID, 0, 2, 2, 4, structureboundingbox);
        func_35018_a(world, Block.planks.blockID, 0, 1, 1, 5, structureboundingbox);
        func_35018_a(world, Block.stairCompactPlanks.blockID, func_35009_c(Block.stairCompactPlanks.blockID, 3), 2, 1, 5, structureboundingbox);
        func_35018_a(world, Block.stairCompactPlanks.blockID, func_35009_c(Block.stairCompactPlanks.blockID, 1), 1, 1, 4, structureboundingbox);
        for(int i = 6; i <= 8; i++)
        {
            if(func_35007_a(world, i, 0, -1, structureboundingbox) == 0 && func_35007_a(world, i, -1, -1, structureboundingbox) != 0)
            {
                func_35018_a(world, Block.stairCompactCobblestone.blockID, func_35009_c(Block.stairCompactCobblestone.blockID, 3), i, 0, -1, structureboundingbox);
            }
        }

        for(int j = 0; j < 7; j++)
        {
            for(int k = 0; k < 10; k++)
            {
                func_35016_b(world, k, 6, j, structureboundingbox);
                func_35005_b(world, Block.cobblestone.blockID, 0, k, -1, j, structureboundingbox);
            }

        }

        return true;
    }

    private int field_35086_a;
}
