package crewworks.thederpgamer.libraries;

import java.util.ArrayList;
import thederpgamer.libraries.Blocks;

public class Block {

  public static Block block = new Block();
  public static ArrayList<Block> customBlocks = new ArrayList<Block>();

  private static String blockID;
  private static Sting category;
  private static String displayName;
  private static ArrayList<Integer> textureIDs = new ArrayList<Integer>();
  private static ArrayList<Block> recipie = new ArrayList<Block>();
  private static int HP;
  private static int armor;
  private static int price;
  private static String description;

  public static setBlockID(String id) {
    blockID = id;
  }

  public static setCategory(String cat) {
    category = cat;
  }

  public static setDisplayName(String name) {
    displayName = name;
  }

  public static setTextrueIDs(ArrayList<Integer> ids) {
    if(ids.size == 6) {
      for(x = 0, x <= ids.size(), x++) {
        textureIDs.add(x);
      }
    }
  }

  public static setRecipie(ArrayList<Block> recipie) {
    for(x = 0, x <= recipie.size(), x++) {
      textureIDs.add(x);
    }
  }

  public static setHitpoints(int hitPoints) {
    HP = hitPoints;
  }

  public static setArmor(int armorPoints) {
    armor = armorPoints;
  }

  public static setPrice(int shopPrice) {
    price = shopPrice;
  }

  public static setDescription(String desc) {
    description = desc;
  }

  public static registerConfigs(Block block) {
    

    System.out.println("Successfuly registered " + customBlocks.size() + " blocks!");
  }
}
