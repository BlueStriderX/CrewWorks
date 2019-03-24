package crewworks.thederpgamer.main;

import thederpgamer.libraries.Block;
import thederpgamer.blocks.Crew_Module;

public class BlockRegister extends Block {

  public static registerBlocks() {
    createCategory(Crew);

    customBlocks.add(Crew_Module.CREW_MODULE);
    registerConfigs(Crew_Module.CREW_MODULE);
  }
}
