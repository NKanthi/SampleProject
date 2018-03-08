import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

 class Parser {
  private DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
  private XPathFactory xPathFactory = XPathFactory.newInstance();

  private DocumentBuilder builder;
  private Document doc;

  private XPath xPath;

   Parser(File XMLpath) {
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
