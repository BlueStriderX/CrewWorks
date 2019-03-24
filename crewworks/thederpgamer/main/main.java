package crewworks.thederpgamer.main;

import thederpgamer.libraries.Block;
import thederpgamer.blocks.Crew_Module;
import thederpgamer.main.BlockRegister;

public class Main {

  public static file mod = modinfo.json;
  public static this.MODNAME = mod.MODNAME;
  public static this.MODVERSION = mod.MODVERSION;
  public static this.MODAUTHOR = mod.MODAUTHOR;
  public static this.MODDESCRIPTION = mod.MODDESCRIPTION;

  public static void onInitialize() {
    System.out.println("Loading CrewWorks...");
    BlockRegister.registerBlocks();
  }
}
