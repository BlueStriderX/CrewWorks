package crewworks.thederpgamer.main;

import thederpgamer.main.Main;
import thederpgamer.libraries.Block;
import thederpgamer.libraries.Blocks;

public class CrewBlocks extends Block {

  public static void main() {
    Block.createCategory("Crew", "General");

    Block CREW_MODULE = new Block();
    CREW_MODULE.addBlock("CREW_MODULE", "General.Crew");
    CREW_MODULE.setDisplayName("Crew Module");
    CREW_MODULE.setModel(false);
    CREW_MODULE.setPhysical(true); //nonphysical blocks can only be seen in build mode and can be passed through by entities
    CREW_MODULE.setInteractable(true);
    CREW_MODULE.setSlaveBlock(CREW_AREA , PATH_BLOCK);

    Block CREW_AREA = new Block();
    CREW_AREA.addBlock("CREW_AREA", "General.Crew");
    CREW_AREA.setDisplayName("Crew Area");
    CREW_AREA.setModel(false);
    CREW_AREA.setPhysical(false); //nonphysical blocks can only be seen in build mode and can be passed through by entities
    CREW_AREA.setInteractable(false);
    CREW_AREA.setMasterBlock(CREW_MODULE);

    Block PATH_BLOCK = new Block();
    PATH_BLOCK.addBlock("PATH_BLOCK", "General.Crew")
    PATH_BLOCK.setDisplayName("Path Block");
    PATH_BLOCK.setModel(false);
    PATH_BLOCK.setPhysical(false); //nonphysical blocks can only be seen in build mode and can be passed through by entities
    PATH_BLOCK.setInteractable(false);
    PATH_BLOCK.setMasterBlock(CREW_MODULE);
  }
}
