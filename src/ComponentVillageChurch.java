// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentVillageChurch extends ComponentVillage
{

    public ComponentVillageChurch(int i, Random random, StructureBoundingBox structureboundingbox, int j)
    {
        super(i);
        field_35098_a = -1;
        field_35025_h = j;
        field_35024_g = structureboundingbox;
    }

    public void func_35004_a(StructureComponent structurecomponent, List list, Random random)
    {
    }

    public static ComponentVillageChurch func_35097_a(List list, Random random, int i, int j, int k, int l, int i1)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_35747_a(i, j, k, 0, 0, 0, 5, 12, 9, l);
        if(!func_35074_a(structureboundingbox) || StructureComponent.func_35020_a(list, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageChurch(i1, random, structureboundingbox, l);
        }
    }

    public boolean func_35023_a(World world, Random random, StructureBoundingBox structureboundingbox)
    {
        if(field_35098_a < 0)
        {
            field_35098_a = func_35075_b(world, structureboundingbox);
            if(field_35098_a < 0)
            {
                return true;
            }
            field_35024_g.func_35745_a(0, ((field_35098_a - field_35024_g.field_35750_e) + 12) - 1, 0);
        }
        func_35011_a(world, structureboundingbox, 1, 1, 1, 3, 3, 7, 0, 0, false);
        func_35011_a(world, structureboundingbox, 1, 5, 1, 3, 9, 3, 0, 0, false);
        func_35011_a(world, structureboundingbox, 1, 0, 0, 3, 0, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 1, 0, 3, 10, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 1, 1, 0, 10, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 4, 1, 1, 4, 10, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 0, 4, 0, 4, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 4, 0, 4, 4, 4, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 1, 8, 3, 4, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 5, 4, 3, 10, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 1, 5, 5, 3, 5, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 9, 0, 4, 9, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35011_a(world, structureboundingbox, 0, 4, 0, 4, 4, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        func_35018_a(world, Block.cobblestone.blockID, 0, 0, 11, 2, structureboundingbox);
        func_35018_a(world, Block.cobblestone.blockID, 0, 4, 11, 2, structureboundingbox);
        func_35018_a(world, Block.cobblestone.blockID, 0, 2, 11, 0, structureboundingbox);
        func_35018_a(world, Block.cobblestone.blockID, 0, 2, 11, 4, structureboundingbox);
        func_35018_a(world, Block.cobblestone.blockID, 0, 1, 1, 6, structureboundingbox);
        func_35018_a(world, Block.cobblestone.blockID, 0, 1, 1, 7, structureboundingbox);
        func_35018_a(world, Block.cobblestone.blockID, 0, 2, 1, 7, structureboundingbox);
        func_35018_a(world, Block.cobblestone.blockID, 0, 3, 1, 6, structureboundingbox);
        func_35018_a(world, Block.cobblestone.blockID, 0, 3, 1, 7, structureboundingbox);
        func_35018_a(world, Block.stairCompactCobblestone.blockID, func_35009_c(Block.stairCompactCobblestone.blockID, 3), 1, 1, 5, structureboundingbox);
        func_35018_a(world, Block.stairCompactCobblestone.blockID, func_35009_c(Block.stairCompactCobblestone.blockID, 3), 2, 1, 6, structureboundingbox);
        func_35018_a(world, Block.stairCompactCobblestone.blockID, func_35009_c(Block.stairCompactCobblestone.blockID, 3), 3, 1, 5, structureboundingbox);
        func_35018_a(world, Block.stairCompactCobblestone.blockID, func_35009_c(Block.stairCompactCobblestone.blockID, 1), 1, 2, 7, structureboundingbox);
        func_35018_a(world, Block.stairCompactCobblestone.blockID, func_35009_c(Block.stairCompactCobblestone.blockID, 0), 3, 2, 7, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 2, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 3, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 4, 2, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 4, 3, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 6, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 7, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 4, 6, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 4, 7, 2, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 2, 6, 0, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 2, 7, 0, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 2, 6, 4, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 2, 7, 4, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 0, 3, 6, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 4, 3, 6, structureboundingbox);
        func_35018_a(world, Block.thinGlass.blockID, 0, 2, 3, 8, structureboundingbox);
        func_35018_a(world, Block.torchWood.blockID, 0, 2, 4, 7, structureboundingbox);
        func_35018_a(world, Block.torchWood.blockID, 0, 1, 4, 6, structureboundingbox);
        func_35018_a(world, Block.torchWood.blockID, 0, 3, 4, 6, structureboundingbox);
        func_35018_a(world, Block.torchWood.blockID, 0, 2, 4, 5, structureboundingbox);
        int i = func_35009_c(Block.ladder.blockID, 4);
        for(int j = 1; j <= 9; j++)
        {
            func_35018_a(world, Block.ladder.blockID, i, 3, j, 3, structureboundingbox);
        }

        func_35018_a(world, 0, 0, 2, 1, 0, structureboundingbox);
        func_35018_a(world, 0, 0, 2, 2, 0, structureboundingbox);
        func_35002_a(world, structureboundingbox, random, 2, 1, 0, func_35009_c(Block.doorWood.blockID, 1));
        if(func_35007_a(world, 2, 0, -1, structureboundingbox) == 0 && func_35007_a(world, 2, -1, -1, structureboundingbox) != 0)
        {
            func_35018_a(world, Block.stairCompactCobblestone.blockID, func_35009_c(Block.stairCompactCobblestone.blockID, 3), 2, 0, -1, structureboundingbox);
        }
        for(int k = 0; k < 9; k++)
        {
            for(int l = 0; l < 5; l++)
            {
                func_35016_b(world, l, 12, k, structureboundingbox);
                func_35005_b(world, Block.cobblestone.blockID, 0, l, -1, k, structureboundingbox);
            }

        }

        return true;
    }

    private int field_35098_a;
}
