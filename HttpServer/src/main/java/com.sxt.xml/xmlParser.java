package com.sxt.xml;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.*;

public class xmlParser {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        WebHandler handler = new WebHandler();
        parser.parse(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml")),handler);
        System.out.println(handler.getEntitys());
        System.out.println(handler.getMappings());
    }
}

class WebHandler extends DefaultHandler {
    private List<Entity> entitys  = new ArrayList<Entity>();
    private List<Mapping> mappings = new ArrayList<Mapping>();
    private String tag;
    private Entity entity ;
    private Mapping mapping ;
    private boolean isServlet;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tag = qName;
        if (qName.equals("servlet")) {
            isServlet = true;
            entity = new Entity();
        } else if(qName.equals("servlet-mapping")) {
            isServlet = false;
            mapping = new Mapping();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println(qName + "---> end");
        if(qName.equals("servlet")) {
            entitys.add(entity);
        }else if(qName.equals("servlet-mapping")) {
            mappings.add(mapping);
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch,start,length).trim();
        if (contents.length() > 0 && tag != null) {
            if (isServlet) {
                if (tag.equals("servlet-name")) {
                    entity.setName(contents);
                } else if (tag.equals("servlet-class")) {
                    entity.setClz(contents);
                }
            } else {
                if(tag.equals("servlet-name")) {
                    mapping.setName(contents);
                }else if(tag.equals("url-pattern")) {
                    mapping.addPattern(contents);
                }
            }
        }

    }

    public List<Entity> getEntitys() {
        return entitys;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

}
