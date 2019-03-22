package crewworks.thederpgamer.main;

import thederpgamer.main.main;
//import block api

public class crewBlocks extends Block {

  public static void main() {
    Block CREWMODULE = new Block();
    CREWMODULE.setDisplayName("Crew Module");
    CREWMODULE.setModel(false);
    CREWMODULE.setPhysical(true); //nonphysical blocks can only be seen in build mode and can be passed through by entities
    CREWMODULE.setTexture("resources/textures/blocks/crewModule.png");
    CREWMODULE.setInteractable(true);
    CREWMODULE.setType(master);
    CREWMODULE.setSlaveBlock(CREWAREA , PATHBLOCK);

    Block CREWAREA = new Block();
    CREWAREA.setDisplayName("Crew Area");
    CREWAREA.setModel(false);
    CREWAREA.setPhysical(false); //nonphysical blocks can only be seen in build mode and can be passed through by entities
    CREWAREA.setTexture("resources/textures/blocks/crewArea.png");
    CREWAREA.setInteractable(false);
    CREWAREA.setType(slave);
    CREWAREA.setMasterBlock(CREWMODULE);

    Block PATHBLOCK = new Block();
    PATHBLOCK.setDisplayName("Path Block");
    PATHBLOCK.setModel(false);
    PATHBLOCK.setPhysical(false); //nonphysical blocks can only be seen in build mode and can be passed through by entities
    PATHBLOCK.setTexture("resources/textures/blocks/pathBlock.png");
    PATHBLOCK.setInteractable(false);
    PATHBLOCK.setType(slave);
    PATHBLOCK.setMasterBlock(CREWMODULE);
  }
}
