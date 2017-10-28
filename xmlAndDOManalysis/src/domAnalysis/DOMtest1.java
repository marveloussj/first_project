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

public class DOMtest1 {
@Test
public void test1() throws Exception {
	File f=new File("C:/Users/Administrator/Desktop/work/xmlAndDOManalysis/resource/contact.xml");
	Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
	Element root = document.getDocumentElement();
	Element linkmanel = document.createElement("linkman");
	Element nameel = document.createElement("name");
	Element emailel = document.createElement("email");
	Element ganderel = document.createElement("gander");
	nameel.setTextContent("´ó¸ç");
	emailel.setTextContent("sj@163.com");
	ganderel.setTextContent("ÄÐ");
	linkmanel.appendChild(emailel);
	linkmanel.appendChild(nameel);
	linkmanel.appendChild(ganderel);
	
	root.appendChild(linkmanel);
	TransformerFactory factory= TransformerFactory.newInstance();
	Transformer trans=factory.newTransformer();
	Source xmlSource = new DOMSource(document);
	Result outputTarget =new StreamResult(f);
	trans.transform(xmlSource, outputTarget);
}
}
