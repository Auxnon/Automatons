// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


public enum EnumMobType
{
    everything,
    mobs,
    players;
/*
    public static EnumMobType[] values()
    {
        return (EnumMobType[])allMobTypes.clone();
    }

    public static EnumMobType valueOf(String s)
    {
        return (EnumMobType)Enum.valueOf(net.minecraft.src.EnumMobType.class, s);
    }

    private EnumMobType(String s, int i)
    {
        super(s, i);
    }

    public static final EnumMobType everything;
    public static final EnumMobType mobs;
    public static final EnumMobType players;
    private static final EnumMobType allMobTypes[]; /* synthetic field */
/*
    static 
    {
        everything = new EnumMobType("everything", 0);
        mobs = new EnumMobType("mobs", 1);
        players = new EnumMobType("players", 2);
        allMobTypes = (new EnumMobType[] {
            everything, mobs, players
        });
    }
*/
}
