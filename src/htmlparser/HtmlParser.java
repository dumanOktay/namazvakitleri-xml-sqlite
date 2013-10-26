/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlparser;

import Entities.GenelBilgiler;
import Entities.Vakit;
import Veritabani.Veritabani;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.InputStream;
import java.net.URL;


/**
 *
 * @author oktay
 */
public class HtmlParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Veritabani.baglantiAc("HtmlParserPU");
       try {
 
	//File fXmlFile = new File("/home/oktay/Downloads/16741.xml");
        URL url = new URL("http://www.namazvakti.com/XML2013/16/16741.xml");
        InputStream stream = url.openStream();

	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(stream);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        
        NodeList bilgi=doc.getElementsByTagName("cityinfo");
        
        Node n=bilgi.item(0);
        
        GenelBilgiler  gb= new GenelBilgiler();;
        
        
        
        if(n.getNodeType()==Node.ELEMENT_NODE){
            Element e=(Element)n;
            System.out.println("şehirr"+e.getAttribute("cityNameTR"));
           
            gb.setCityNameTR(e.getAttribute("cityNameTR"));
            
            Veritabani.persist(gb);
        }
 
	NodeList nList = doc.getElementsByTagName("prayertimes");
 
	System.out.println("----------------------------");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
                        Element eElement = (Element) nNode;
                        
                       System.out.println(""+eElement.getTextContent());
                       
                       String icerik = eElement.getTextContent();
                       
                       Vakit vakit= new Vakit();
                       vakit.setIcerik(icerik);
                       
                       vakit.setGenelBilgiler(gb);
                       
                       Veritabani.persist(vakit);
 
			System.out.println("Staff id : " + eElement.getAttribute("dayofyear"));
			/*System.out.println("First Name : " + eElement.getElementsByTagName("prayertimes").item(0).getTextContent());
			/*System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());*/
 
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
 
    
}
