// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase

public class AM_BiomeGenTech extends BiomeGenBase
{

    public AM_BiomeGenTech()
    {
		 fillerBlock = (byte)Block.blockClay.blockID;
		 topBlock = (byte)AutomatonLogger.frass;
		 
		//if(AutomatonLogger.allTech!=1){
		spawnableMonsterList.clear();
        spawnableCreatureList.clear();
		//}
		
		
        //spawnableWaterCreatureList.clear();
		
        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.AM_EntityChopper.class, 2));
		spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.AM_EntityBobby.class, 2));
		spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.AM_EntityGolem.class, 8));
		spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.AM_EntityWatcher.class, 8));
		spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.AM_EntitySlider.class, 50));
		//spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntityChopper.class, 14));
    }
	public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
	
		if(random.nextInt(3) == 0)
        {
            return new AM_WorldGenBigFakeTree();
        }
		
		if(random.nextInt(6) == 0)
        {
            return new AM_WorldGenDerk();
        }
		
		
		if(random.nextInt(5) == 0)
        {
            return new AM_WorldGenTower();
        }
		
		if(random.nextInt(5) == 0)
        {
            return new AM_WorldGenCrypt();
        }
		
		
       
        return new AM_WorldGenBigFakeTree();

		
	}
}
