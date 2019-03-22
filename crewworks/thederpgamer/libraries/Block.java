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

public class Block {

  public static DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
  public static DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
  public static Document doc = docBuilder.newDocument();
  public static Element config = doc.createElement("Config");
  public static Element element = doc.createElement("Element");
  public static Element general = doc.createElement("General");
  public static Element decoration = doc.createElement("Decoration");

  public static void createCategory(String categoryName) {
    Element newCategory = doc.createElement("" + categoryName);
    general.appendChild(newCategory);
  }

  public static void setID(String id, String category) {
    Element block = doc.createElement(id);
    Element cat = category;
    cat.appendChild(block);
  }

  public static void setDisplayName(String name) {
  }

  public static void setModel(String string) {

  }

  public static void setPhysical(boolean bool) {

  }

  public static void setTexture(String string) {

  }

  public static void setInteractable(boolean bool) {

  }

  public static void setMasterBlock(Block block) {

  }

  public static void setSlaveBlock(Block block) {

  }

  public static void configInitialization() {
      element.appendChild(decoration);
      element.appendChild(general);
      config.appendChild(element);
      doc.appendChild(config);
  }
}
