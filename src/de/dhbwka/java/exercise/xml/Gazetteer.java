package de.dhbwka.java.exercise.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Gazetteer {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.parse("src/de/dhbwka/java/exercise/karlsruhe.xml");
        Element geocode = doc.getDocumentElement();
        Element result =  getNamedChildElement(geocode, "result");

        System.out.println("Adresse: " + result.getElementsByTagName("formatted_address").item(0));
        System.out.println("Long name: ");
        System.out.println("Location: ");
        System.out.println("Bounds: ");
    }

    // Liefert das erste Kind-Element von n mit Namen name
    public static Element getNamedChildElement(Node n, String name) {
        return getNamedChildElement(n, name, 0);
    }

    // Liefert das n-te Kind-Element von n mit Namen name, Zählung beginnt bei 0
    public static Element getNamedChildElement(Node n, String name, int count) {
        for (int i = 0; i < n.getChildNodes().getLength(); i++) {
            Node ithChild = n.getChildNodes().item(i);
            if (ithChild.getNodeType() == Node.ELEMENT_NODE &&
                    ithChild.getNodeName().equals(name)) {
                if (count == 0) {
                    return (Element) ithChild;
                }
                count--;
            }
        }
        return null;
    }
}
