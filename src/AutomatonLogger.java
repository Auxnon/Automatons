package net.minecraft.src;

import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;

public class AutomatonLogger {

	static File f;

	
		public static int tempBlock1=131;
	public static int tempBlock2=132;
	
		public static int tempItem1=130;

		
	public static int automaton=144;
	public static int itemOmni=145;
	public static int itemBally=146;
	public static int cheatStick=147;
	public static int automatonCore=149;
	public static int itemBeacon=150;
	public static int biter=151;
	public static int smack=152;
	//112
	//113
	public static int itemBot=153;
	public static int superCore=154;
	//116
	public static int blaster=155;
	public static int guard=156;
	public static int stuffs=157;
	public static int mortar=158;
	public static int pickTech=159;
	public static int itemFactotum=160;
	public static int regulator=161;
	public static int daymaker=162;
	public static int techifier=163;
	public static int naturizer=164;
	public static int misc=165;

	public static int tech=118;
	public static int crystal=119;
	public static int crink=120;
	public static int fakeCrystal=121;
	public static int glowy=122;
	public static int frass=123;
	public static int dapling=124;
	public static int duplex=125;
	public static int boing=126;
	public static int heal=127;
	public static int grower=128;
	public static int frass2=129;
	public static int hollow=130;
	public static int tv=110;
	public static int sky=111;
	public static int deployer=112;
	public static int techPlant=113;
	public static int importantBuildingThingy=114;
	public static int arbor=117;
	
	
	public static int worker=108;
	public static int guardTurret=80;
	public static int sentry=77;
	public static int watcher=79;
	public static int beacon=87;
	public static int slider=78;
	public static int chopper=81;
	public static int bobby=82;
	public static int golem1=85;
	public static int golem2=86;
	public static int omni=89;
	
	public static int factotum=101;
	public static int arborist=102;
	public static int hydra=103;
	public static int ziz=104;
	public static int sleeper=105;
	public static int seeker=106;
	public static int remnant=107;
	public static int beam=108;
	public static int deltaLaser=109;
	public static int knave=110;
	
	public static int tvRenderId=27;
	public static int crinkRenderId=28;
	
	public static int allTech=0;
	public static int frassWaterSpread=0;
	public static int frassDirtSpread=0;
	public static int maxDeployableEntities=300;
	
	
	public static boolean tvOut=false;
	
	

	public static int builderLevel=8;
	
	
	public  AutomatonLogger(){
	
		File foo = Minecraft.getAppDir("minecraft");
		f = new File(foo,"/AutomatonsConfig.properties");
		if(f.exists()){
			System.out.println("reading automaton config!");
			try{
				FileReader fs = new FileReader(f);

				BufferedReader in = new BufferedReader(fs);

				String s;
				Class c = AutomatonLogger.class;//Class.forName("AutomatonLogger");
				
				
				
				while((s=in.readLine())!=null){
					if(!s.startsWith("//")){
						int i=s.indexOf("=");
						int val;
						if(s.substring(i+1,s.length())=="#"){
							val=ModLoader.getUniqueEntityId();
						}else{
							val=Integer.parseInt(s.substring(i+1,s.length()));
						}
						//System.out.println(s.substring(0, i));
						try{
							Field f=c.getDeclaredField(s.substring(0, i));
							
							f.setInt(this, val);
							System.out.println("id for "+f.getName()+" set to "+val);
						}catch(Exception ex){

						}
					}
				}
				//out.write("Hello Java");
				//Close the output stream
				in.close();
			}catch(Exception c){

			}

		}else{
			System.out.println("no automaton config found! creating new one!");
			
		}
		writeIt();
		
		//System.out.println("automaton "+stuffs);
	}
	
	public void writeIt(){
			try{
				FileWriter fs = new FileWriter(f);

				BufferedWriter out = new BufferedWriter(fs);
				out.write("//Rise of the Automatons config file! :D hooray!\n");
				out.write("//\n//\n//SET ALL NEW TERRAIN AND BIOMES TO GENERATE AS TECH( 0=off, 1=on):\n");
				out.write("allTech="+allTech+"\n");
				out.write("//ALLOW FRASS TO SPREAD ONTO WATER THAT'S NOT IN THE TECH BIOME(DANGEROUS)\n");
				out.write("frassWaterSpread="+frassWaterSpread+"\n");
				out.write("//ALLOW FRASS TO SPREAD ONTO DIRT/GRASS THAT'S NOT IN THE TECH BIOME(EVEN MOAR DANGEROUS)\n");
				out.write("frassDirtSpread="+frassDirtSpread+"\n");
				out.write("//How many entities can be in the world before the deployer stops putting out mobs?:\n");
				out.write("maxDeployableEntities="+maxDeployableEntities+"\n");
				
				out.write("//\n");
				
				out.write("//\n//\n//ITEMS:\n");
				out.write("automaton="+automaton+"\n");
				out.write("itemOmni="+itemOmni+"\n");
				out.write("itemBally="+itemBally+"\n");
				out.write("cheatStick="+cheatStick+"\n");
				out.write("automatonCore="+automatonCore+"\n");
				out.write("itemBeacon="+beacon+"\n");
				out.write("biter="+biter+"\n");
				out.write("smack="+smack+"\n");
				out.write("itemBot="+itemBot+"\n");
				out.write("superCore="+superCore+"\n");
				out.write("blaster="+blaster+"\n");
				out.write("guard="+guard+"\n");
				out.write("//stuffs is a crazy multi item thing, about 11 items so far\n");
				out.write("stuffs="+stuffs+"\n");
				out.write("mortar="+mortar+"\n");
				out.write("pickTech="+pickTech+"\n");
				out.write("itemFactotum="+itemFactotum+"\n");
				out.write("regulator="+regulator+"\n");
				out.write("daymaker="+daymaker+"\n");
				out.write("techifier="+techifier+"\n");
				out.write("naturizer="+naturizer+"\n");
				out.write("misc="+misc+"\n");

				out.write("//\n//\n//BLOCKS:\n");

				out.write("tech="+tech+"\n");
				out.write("crystal="+crystal+"\n");
				out.write("crink="+crink+"\n");
				out.write("fakeCrystal="+fakeCrystal+"\n");
				out.write("glowy="+glowy+"\n");
				out.write("frass="+frass+"\n");
				out.write("dapling="+dapling+"\n");
				out.write("duplex="+duplex+"\n");
				out.write("boing="+boing+"\n");
				out.write("heal="+heal+"\n");
				out.write("grower="+grower+"\n");
				out.write("frass2="+frass2+"\n");
				out.write("hollow="+hollow+"\n");
				out.write("tv="+tv+"\n");
				out.write("sky="+sky+"\n");
				out.write("deployer="+deployer+"\n");
				out.write("techPlant="+techPlant+"\n");
				out.write("importantBuildingThingy="+importantBuildingThingy+"\n");
				out.write("arbor="+arbor+"\n");
				
				
				
				out.write("//\n//\n//RENDER ID'S (these are VERY unlikely you'll need to change)\n");
				out.write("tvRenderId="+tvRenderId+"\n");
				out.write("crinkRenderId="+crinkRenderId+"\n");

				
				out.write("//\n//\n//Entities (if you're SURE there's a conflict, set to #, \n//as in ' Guard=# ', modloader will find an empty id!:\n");
				out.write("worker="+worker+"\n");
				out.write("guardTurret="+guardTurret+"\n");
				out.write("sentry="+sentry+"\n");
				out.write("watcher="+watcher+"\n");
				out.write("//Yes, the beacon is an entity, get over it");
				out.write("beacon="+beacon+"\n");
				out.write("slider="+slider+"\n");
				out.write("chopper="+chopper+"\n");
				out.write("bobby="+bobby+"\n");
				out.write("golem1="+golem1+"\n");
				out.write("golem2="+golem2+"\n");
				out.write("omni="+omni+"\n");
				out.write("factotum="+factotum+"\n");
				out.write("hydra="+hydra+"\n");
				out.write("arborist="+arborist+"\n");
				out.write("ziz="+ziz+"\n");
				out.write("seeker="+seeker+"\n");
				out.write("remnant="+remnant+"\n");
				out.write("beam="+beam+"\n");
				out.write("deltaLaser="+deltaLaser+"\n");
				out.write("knave="+knave+"\n");
				
				
				
				out.close();





			}catch(Exception c){

			}
		}

}
