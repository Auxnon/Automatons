// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentVillageWoodHut extends ComponentVillage
{

    public ComponentVillageWoodHut(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35094_a = -1;
        field_35025_h = j;
        field_35024_g = structureboundingbox;
        field_35092_b = random.nextBoolean();
        field_35093_c = random.nextInt(3);
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static ComponentVillageWoodHut func_35091_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, 0, 0, 0, 4, 6, 5, l);
        if(!func_35074_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageWoodHut(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(field_35094_a < 0)
        {
            field_35094_a = func_35075_b(world, structureboundingbox);
            if(field_35094_a < 0)
            {
                return true;
            }
            field_35024_g.func_35745_a(0, ((field_35094_a - field_35024_g.field_35750_e) + 6) - 1, 0);
        }
        func_35011_a(world, structureboundingbox, 1, 1, 1, 3, 5, 4, 0, 0, false);
        func_35011_a(world, structureboundingbox, 0, 0, 0, 3, 0, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 0, 1, 2, 0, 3, Block.dirt.blockID, Block.dirt.blockID, false);
        if(field_35092_b)
        {
            func_35011_a(world, structureboundingbox, 1, 4, 1, 2, 4, 3, Block.wood.blockID, Block.wood.blockID, false);
        } else
        {
            func_35011_a(world, structureboundingbox, 1, 5, 1, 2, 5, 3, Block.wood.blockID, Block.wood.blockID, false);
        }
        func_35018_a(world, Block.wood.blockID, 0, 1, 4, 0, structureboundingbox);
        func_35018_a(world, Block.wood.blockID, 0, 2, 4, 0, structureboundingbox);
        func_35018_a(world, Block.wood.blockID, 0, 1, 4, 4, structureboundingbox);
        func_35018_a(world, Block.wood.blockID, 0, 2, 4, 4, structureboundingbox);
        func_35018_a(world, Block.wood.blockID, 0, 0, 4, 1, structureboundingbox);
        func_35018_a(world, Block.wood.blockID, 0, 0, 4, 2, structureboundingbox);
        func_35018_a(world, Block.wood.blockID, 0, 0, 4, 3, structureboundingbox);
        func_35018_a(world, Block.wood.blockID, 0, 3, 4, 1, structureboundingbox);
        func_35018_a(world, Block.wood.blockID, 0, 3, 4, 2, structureboundingbox);
        func_35018_a(world, Block.wood.blockID, 0, 3, 4, 3, structureboundingbox);
        func_35011_a(world, structureboundingbox, 0, 1, 0, 0, 3, 0, Block.wood.blockID, Block.wood.blockID, false);
        func_35011_a(world, structureboundingbox, 3, 1, 0, 3, 3, 0, Block.wood.blockID, Block.wood.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 1, 4, 0, 3, 4, Block.wood.blockID, Block.wood.blockID, false);
        func_35011_a(world, structureboundingbox, 3, 1, 4, 3, 3, 4, Block.wood.blockID, Block.wood.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 1, 1, 0, 3, 3, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 3, 1, 1, 3, 3, 3, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 1, 0, 2, 3, 0, Block.planks.blockID, Block.planks.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 1, 4, 2, 3, 4, Block.planks.blockID, Block.planks.blockID, false);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 2, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 3, 2, 2, structureboundingbox);
        if(field_35093_c > 0)
        {
            func_35018_a(world, Block.fence.blockID, 0, field_35093_c, 1, 3, structureboundingbox);
            func_35018_a(world, Block.pressurePlatePlanks.blockID, 0, field_35093_c, 2, 3, structureboundingbox);
        }
        func_35018_a(world, 0, 0, 1, 1, 0, structureboundingbox);
        func_35018_a(world, 0, 0, 1, 2, 0, structureboundingbox);
        func_35002_a(world, structureboundingbox, random, 1, 1, 0, func_35009_c(Block.doorWood.blockID, 1));
        if(func_35007_a(world, 1, 0, -1, structureboundingbox) == 0 && func_35007_a(world, 1, -1, -1, structureboundingbox) != 0)
        {
            func_35018_a(world, Block.stairCompactCobblestone.blockID, func_35009_c(Block.stairCompactCobblestone.blockID, 3), 1, 0, -1, structureboundingbox);
        }
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                func_35016_b(world, j, 6, i, structureboundingbox);
                func_35005_b(world, Block.cobblestone.blockID, 0, j, -1, i, structureboundingbox);
            }

        }

        return true;
    }

    private int field_35094_a;
    private final boolean field_35092_b;
    private final int field_35093_c;
}
