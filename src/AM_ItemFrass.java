// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block

public class AM_ItemFrass extends ItemBlock
{

    public AM_ItemFrass(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    public int getIconFromDamage(int i)
    {
        return AutomatonUniversal.blockFrass(i);
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }
}
