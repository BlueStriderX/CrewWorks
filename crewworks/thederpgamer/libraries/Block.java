package crewworks.thederpgamer.libraries;

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

  public static String customBlockConfigPath = ""; //figure out the releative directory of blockconfig
  public static DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
  public static DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
  public static Document doc = docBuilder.newDocument();
  public static Element config = doc.createElement("Config");
  public static Element element = doc.createElement("Element");
  public static Element general = doc.createElement("General");
  public static Element decoration = doc.createElement("Decoration");

  public static int iconID;
  public static String displayName;
  public static String blockID;
  public static String category;
  public static String[] textureids;
  public static String[] recipie;
  public static boolean model;
  public static boolean physical;
  public static boolean interactable;

  public static void createCategory(String categoryName) {
    Element newCategory = doc.createElement("" + categoryName);
    general.appendChild(newCategory);
  }

  public static void addBlock(int iconID, String displayName, String blockID, String category, String[] textureids) {
    Element block = doc.createElement('Block icon ="' + iconID + '" name="' + displayName + '" textureId="' + textureids[0] + ',' + textureids[1] + ',' + textureids[2] + ',' + textureids[3] + ',' + textureids[4] + ',' + textureids[5] + '" type="'
    + blockID + '"');
    Element cat = category;
    cat.appendChild(block);
  }

  public static void setRecipie(String[] recipie) {
    Element recipie = doc.createElement('Consistence');
    blockID.appendChild(recipie); //figure out how to search the xml file for said id
  }

  public static void setModel(boolean model) {

  }

  public static void setPhysical(boolean physical) {

  }

  public static void setInteractable(boolean interactable) {

  }

  public static void configInitialization() {
      element.appendChild(decoration);
      element.appendChild(general);
      config.appendChild(element);
      doc.appendChild(config);

      TransformerFactory transformerFactory = TransformerFactory.newInstance();
  		Transformer transformer = transformerFactory.newTransformer();
  		DOMSource source = new DOMSource(doc);
  		StreamResult result = new StreamResult(new File(customBlockConfigPath));
  }
}
