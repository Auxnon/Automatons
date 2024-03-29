
package net.minecraft.src;
import java.util.Random;

public class AM_WorldGenPool extends WorldGenerator
{

    public AM_WorldGenPool()
    {
    }
	
	int xyz1[][][]={{
	{43,43,43,43,43},
	{43,43,43,43,43},
	{43,43,43,43,43},
	{43,43,43,43,43},
	{43,43,43,43,43}},
	{
	{43,43,43,43,43},
	{43,9,9,9,43},
	{43,9,43,9,43},
	{43,9,9,9,43},
	{43,43,43,43,43}},
	{
	{0,44,44,44,0},
	{44,0,0,0,44},
	{44,0,1,0,44},
	{44,0,0,0,44},
	{0,44,44,44,0}},
	{
	{0,0,0,0,0},
	{0,0,0,0,0},
	{0,0,8,0,0},
	{0,0,0,0,0},
	{0,0,0,0,0}}};
	
	
	int S=AutomatonLogger.deployer;
	int t=AutomatonLogger.tech;
	int xyz2[][][]={{
	{4,4,4,48,4},
	{48,4,4,48,4},
	{4,48,4,4,4},
	{4,4,4,4,48},
	{4,4,4,4,4}},
	{
	{t,t,t,t,t},
	{t,4,4,48,t},
	{t,4,76,4,t},
	{t,4,48,4,t},
	{t,t,t,t,t}},
	{
	{0,0,0,0,0},
	{0,70,70,70,0},
	{0,70,S,70,0},
	{0,70,70,70,0},
	{0,0,0,0,0}}
	};

    public boolean generate(World world, Random random, int i, int j, int k)
    {
	int xyz[][][];
	boolean bb=false;
	if(random.nextInt(3)==0){
	xyz=xyz1;
	}else{
	xyz=xyz2;
	bb=true;
	}
	
	int tall=xyz.length;
	int wid=xyz[0].length;
	int len=xyz[0][0].length;
	int w2=wid/2;
	int l2=len/2;
	int h2=tall/2;
		for(int x=0;x<wid;x++){
		for(int y=0;y<tall;y++){
		for(int z=0;z<len;z++){
		 world.setBlock(i+x-w2,j+y-h2,k+z-l2,xyz[y][x][z]);
		 //if(xyz[y][x][z]==AutomatonLogger.deployer){
		 //System.out.println((i+x-w2)+","+(j+y-h2)+","+(k+z-l2));
		 //}
		}
		}
		}
		if(bb){
		world.setBlockMetadata(i,j+1,k,1);
		//System.out.println((i)+","+(j+1)+","+(k));
		}

        return true;
    }

}
