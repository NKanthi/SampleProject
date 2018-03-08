import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
  DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
  XPathFactory xPathFactory = XPathFactory.newInstance();

  DocumentBuilder builder;
  Document doc;

  XPath xPath;

  public Parser(File XMLpath) {
    try {
      builder = docBuilderFactory.newDocumentBuilder();
      xPath = xPathFactory.newXPath();

      doc = builder.parse(XMLpath);
    } catch (ParserConfigurationException | SAXException | IOException e) {
      e.printStackTrace();
    }
  }

  public List<String> getPhoneSpecsListByModel(String phoneModel) {
    List<String> phoneSpecs = new ArrayList<>();
    try {
      XPathExpression expr = xPath.compile(Constants.FIND_PHONE_BY_MODEL.replaceAll("phoneModel", phoneModel));
      NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

      for(int i = 0; i < nl.getLength(); i++) {
        phoneSpecs.add(nl.item(i).getNodeValue());
      }
    } catch (XPathExpressionException e) {
      e.printStackTrace();
    }

    return phoneSpecs;
  }

}
