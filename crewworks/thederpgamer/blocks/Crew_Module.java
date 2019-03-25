package crewworks.thederpgamer.blocks;

import thederpgamer.libraries.Block;

public class Crew_Module {

  public static void main() {
    Block CREW_MODULE = new Block();
    this.setBlockID("CREW_MODULE");
    this.setBlockIconID("");
    this.setCategory(general);
    this.setDisplayName("Crew Module");
    this.setTextrueIDs();
    this.setRecipie();
    this.setHitpoints();
    this.setArmor();
    this.setPrice();
    this.setDescription();
    this.setBakeTime(5.0);
    this.setNumberProduced(4);
    this.setMaster();
    this.setSlaves(CREW_AREA, CREW_PATH);
  }
}
