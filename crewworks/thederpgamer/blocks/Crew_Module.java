package crewworks.thederpgamer.blocks;

import thederpgamer.libraries.Block;

public class Crew_Module extends Block {
  
  public static void main() {
    Block CREW_MODULE = new Block();
    this.setBlockID("CREW_MODULE");
    this.setCategory("General");
    this.setDisplayName("Crew Module");
    this.setTextrueIDs();
    this.setRecipie();
    this.setHitpoints();
    this.setArmor();
    this.setPrice();
  }
}
