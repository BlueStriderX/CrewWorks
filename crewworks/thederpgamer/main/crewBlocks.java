package crewworks.thederpgamer.main;

import thederpgamer.main.Main;
import thederpgamer.libraries.Block;

public class CrewBlocks {

  public static void main() {
    Block.createCategory("Crew", "General");

    Block CREW_MODULE = new Block();
    CREW_MODULE.setID("CREW_MODULE", "General.Crew");
    CREW_MODULE.setDisplayName("Crew Module");
    CREW_MODULE.setModel(null);
    CREW_MODULE.setPhysical(true); //nonphysical blocks can only be seen in build mode and can be passed through by entities
    CREW_MODULE.setTexture("resources/textures/blocks/crewModule.png");
    CREW_MODULE.setInteractable(true);
    CREW_MODULE.setSlaveBlock(CREW_AREA , PATH_BLOCK);

    Block CREW_AREA = new Block();
    CREW_AREA.setID("CREW_AREA", "General.Crew");
    CREW_AREA.setDisplayName("Crew Area");
    CREW_AREA.setModel(null);
    CREW_AREA.setPhysical(false); //nonphysical blocks can only be seen in build mode and can be passed through by entities
    CREW_AREA.setTexture("resources/textures/blocks/crewArea.png");
    CREW_AREA.setInteractable(false);
    CREW_AREA.setMasterBlock(CREW_MODULE);

    Block PATH_BLOCK = new Block();
    PATH_BLOCK.setID("PATH_BLOCK", "General.Crew")
    PATH_BLOCK.setDisplayName("Path Block");
    PATH_BLOCK.setModel(null;
    PATH_BLOCK.setPhysical(false); //nonphysical blocks can only be seen in build mode and can be passed through by entities
    PATH_BLOCK.setTexture("resources/textures/blocks/pathBlock.png");
    PATH_BLOCK.setInteractable(false);
    PATH_BLOCK.setMasterBlock(CREW_MODULE);
  }
}
