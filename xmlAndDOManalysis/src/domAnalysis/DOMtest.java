package domAnalysis;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMtest {
	private File f=new File("C:/Users/Administrator/Desktop/work/xmlAndDOManalysis/resource/contact.xml");
@Test
public void test1() throws Exception {

	Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);


	Element root = document.getDocumentElement();

	Element linkmanel = (Element) root.getElementsByTagName("linkman").item(0);

	Element emailel = (Element) linkmanel.getElementsByTagName("email").item(0);

	emailel.setTextContent("sj7777777@163.com");


	TransformerFactory factory= TransformerFactory.newInstance();
	Transformer trans=factory.newTransformer();
	Source xmlSource= new DOMSource(document);
	Result outputTarget =new StreamResult(f);
	trans.transform(xmlSource, outputTarget);
	
}
}
