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

    Element recipieElement = document.createElement("Consistence");
    block.appendChild(recipie);

    Element armorElement = document.createElement("ArmorValue");

    Element effectArmorElement = document.createElement("EffectArmor");
    block.appendChild(effectArmor);

    Element heatElement = document.createElement("Heat");
    effectArmorElement.appendChild(heatElement);
    Element heatStat = document.createTextNode("" + heatValue));
    heatElement.appendChild(heatStat);

    Element kineticElement = document.createElement("Kinetic");
    effectArmorElement.appendChild(kineticElement);
    Element kineticStat = document.createTextNode("" + kineticValue));
    heatElement.appendChild(kineticStat);

    Element emElement = document.createElement("EM");
    effectArmorElement.appendChild(emElement);
    Element emStat = document.createTextNode("" + emValue));
    heatElement.appendChild(kineticStat);

    Element priceElement = document.createElement("Price");
    block.appendChild(priceElement);

    Element descriptionElement = document.createElement("Description");
    block.appendChild(descriptionElement);
    Element descText = documen.createTextNode("" + description);
    descriptionElement.appendChild(descriptionText);

    System.out.println("Successfuly registered " + customBlocks.size() + " blocks!");
  }
}
