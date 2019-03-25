package crewworks.thederpgamer.libraries;

import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import thederpgamer.libraries.Blocks;

public class Block {

  public static final String xmlFilePath = "";
  public static DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
  public static DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
  public static Document document = documentBuilder.newDocument();
  public static Element config;
  public static Element element;
  public static Element general;

  public static Block block = new Block();
  public static ArrayList<Block> customBlocks = new ArrayList<Block>();

  private static String blockID;
  private static int blockIconID;
  private static Element category;
  private static String displayName;
  private static ArrayList<Integer> textureIDs = new ArrayList<Integer>();
  private static ArrayList<Block> recipie = new ArrayList<Block>();
  private static int HP;
  private static int armor;
  private static int price;
  private static String description;
  private static int heatValue;
  private static int kineticValue;
  private static int emValue;
  private static double factoryBakeValue;

  public static createCategory(String categoryName) {
    Element category = document.createElement("" + categoryName);
    general.appendChild(category);
  }

  public static setBlockID(String id) {
    String blockID = id;
  }

  public static setBlockIconID(int id) {
    int blockIconID = id;
  }

  public static setCategory(Element cat) {
    Element category = cat;
  }

  public static setDisplayName(String name) {
    String displayName = name;
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
    int HP = hitPoints;
  }

  public static setArmor(int armorPoints) {
    int armor = armorPoints;
  }

  public static setPrice(int shopPrice) {
    int price = shopPrice;
  }

  public static setDescription(String desc) {
    String description = desc;
  }

  public static setBakeTime(double time) {
    double factoryBakeValue = time;
  }

  public static registerConfigs(Block block) {
    Element config = document.createElement("Config");
    document.appendChild(config);
    Element element = document.createElement("Element");
    config.appendChild(element);
    Element general = document.createElement("General");
    element.appendChild(general);
    Element category = block.category;
    category.appendChild();
    Element blockElement = document.createElement("Block");
    block.setAttribute("icon", "" + blockIconID);
    block.setAttribute("name", "" + displayName);
    block.setAttribute("textureId", "" + textureIDs[0] + "," + textureIDs[1] + "," + textureIDs[2] + "," + textureIDs[3] + "," + textureIDs[4] + "," + textureIDs[5] + ",");
    block.setAttribute("type", "" + blockID);
    category.appendChild(blockElement);

    //Recipie
    Element recipieElement = document.createElement("Consistence");
    block.appendChild(recipie);

    //Armor Value
    Element armorElement = document.createElement("ArmorValue");

    //Effect Armor
    Element effectArmorElement = document.createElement("EffectArmor");
    block.appendChild(effectArmor);

    //Heat Armor
    Element heatElement = document.createElement("Heat");
    effectArmorElement.appendChild(heatElement);
    Element heatStat = document.createTextNode("" + heatValue));
    heatElement.appendChild(heatStat);

    //Kinetic Armor
    Element kineticElement = document.createElement("Kinetic");
    effectArmorElement.appendChild(kineticElement);
    Element kineticStat = document.createTextNode("" + kineticValue));
    heatElement.appendChild(kineticStat);

    //Em Armor
    Element emElement = document.createElement("EM");
    effectArmorElement.appendChild(emElement);
    Element emStat = document.createTextNode("" + emValue));
    heatElement.appendChild(kineticStat);

    //Price
    Element priceElement = document.createElement("Price");
    block.appendChild(priceElement);

    //Description
    Element descriptionElement = document.createElement("Description");
    block.appendChild(descriptionElement);
    Element descText = document.createTextNode("" + description);
    descriptionElement.appendChild(descriptionText);

    //BlockResourceType
    //Ask Schema what this means

    //Number Produced in Factory

    //Basic Resources Factory
    //Ask Schema what this means

    //Factory Bake Time
    Element factoryTimeElement = document.createElement("FacoryBakeTime");
    block.appendChild(factoryTimeElement);
    Element factoryTimeText = document.createTextNode("" + factoryBakeValue);
    factoryTimeElement.appendChild(factoryTimeText);

    //Inventory Group
    //Ask Schema if it is possible to make new inventory groups through configs

    //Animated

    //StructureHPContribution
    //Probably has to do with integrity mechanic, ignore it for now because integrity is disabled by default
    //(Maybe add support in future?)

    //Transparency

    //In Shop

    //Orientation
    //Probably allows block to change oreintation

    //Block Computer Reference
    //Ask Schema what this means

    //Slab
    //0 = full block, 1 = 1/4 block?, 2 = 1/2 block?, 3 = 3/4 block?
    //Ask Schema if above is correct

    //Slab IDs
    //Probably referring to slab block icon ids
    //Double check with Schema to see if true

    //Slab Reference
    //Ask Schema what this means

    //GeneralChamber
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Chamber Capacity
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Chamber Root
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Chamber Parent
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Chamber Upgrades To
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Chamber Permission
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Chamber Prerequisites
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Chamber Mutually Exclusive
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Chamber Children
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Chamber Applies To
    //Has to do with chamber blocks, ignore for now
    //(Maybe add support in future?)

    //Reactor HP
    //Has to do with reactor blocks, ignore for now
    //(Maybe add support in future?)

    //Reactor General Icon Index
    //Has to do with reactor blocks, ignore for now
    //(Maybe add support in future?)

    //Enterable
    //Allows for the block to be entered by the player, for weapon computers and such

    //Mass
    //The block's mass

    //Volume
    //How much storage space the block takes up

    //Hitpoints
    //How much HP the block has, seperate from armor value

    //Placeable
    //If the player is allowed to physically place the block
    //For items and tools change this to false

    //In Recipie
    //If it's actually craftable or not

    //Individual Sides
    //Ask Schema what this means

    //Side Textures Point to Oreintation
    //Ask Schema what this means

    //Has Acivation Texture
    //If the block changes texture on activation, for logic blocks

    //Main Combination Controller
    //Has to do with masters and slaves, ask Schema how to set specific blocks as slaves to a master

    //Support Combination Controller
    //Has to do with masters and slaves, ask Schema how to set specific blocks as slaves to a master

    //Effect Combination Controller
    //Has to do with masters and slaves, ask Schema how to set specific blocks as slaves to a master

    //Physical
    //If the block can be passed through by other entities
    //(true = not passable)

    //Block Style
    //Ask Schema what this means

    //Light Source
    //If the block emits light

    //Light Source Color
    //The color of the block's light source

    //Door
    //If the block is a door

    //Sensor Input
    //If the block can output to a sensor
    //Ask Schema how this works

    //Resource Injection
    //Ask Schema what this means

    //Explosion Absorbtion
    //Ask Schema what this means

    //Extended Texture 4x4
    //Has to do with extended textures, ignore for now
    //(Maybe add suport in future?)

    //Only Drawn in Build Mode
    //For blocks that are only visible in build mode, like area blocks and rail launchers

    //LODS Shape from Far
    //For LOD blocks, changes the block to be a certain shape when out of LOD range
    //Ask Schema which values are which

    //Low HP Setting
    //Ask Schema what this means

    //System Block
    //If the block is a system block? Ask Schema what this means
    
    System.out.println("Successfuly registered " + customBlocks.size() + " blocks!");
  }
}
