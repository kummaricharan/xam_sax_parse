package handler;

import entity.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class EmployeeHandler extends DefaultHandler {
    private List<Employee> employees = null;
    private Employee emp = null;
    private StringBuilder data = null;
    public List<Employee> getEmployees(){
        return employees;
    }
    boolean bname = false;
    boolean bage = false;
    boolean bgender = false;
    boolean brole = false;


    @Override
    public void startDocument ()
            throws SAXException
    {
        System.out.println("startDocument");
    }
    @Override
    public void endDocument ()
            throws SAXException
    {
        System.out.println("endDocument");
    }
    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException
    {
//        if(attributes.getLength()>0){
//            System.out.print("<"+qName);
//            for(int i=0;i<attributes.getLength();i++){
//                System.out.print(" "+attributes.getQName(i));
//                System.out.println("="+attributes.getValue(i));
//            }
//            System.out.println(">");
//        }
//        else{
//            System.out.println("<"+qName+">");
//        }
        if(qName.equalsIgnoreCase("employee")){
            String id = attributes.getValue("id");
            emp = new Employee();
            emp.setId(Integer.parseInt(id));
            if(employees==null) {
                employees = new ArrayList<>();
            }
        }
        else if(qName.equalsIgnoreCase("name")){
            bname = true;
        }
        else if(qName.equalsIgnoreCase("age")){
            bage = true;
        }
        else if(qName.equalsIgnoreCase("gender")){
            bgender = true;
        }
        else if(qName.equalsIgnoreCase("role")){
            brole = true;
        }
        data = new StringBuilder();

    }
    @Override
    public void endElement (String uri, String localName, String qName)
            throws SAXException
    {
//        System.out.println("</"+qName+">");
        if(bage){
            emp.setAge(Integer.parseInt(data.toString()));
            bage = false;
        }
        else if(bname){
            emp.setName(data.toString());
            bname = false;
        }
        else if(brole){
            emp.setRole(data.toString());
            brole = false;
        } else if (bgender) {
            emp.setGender(data.toString());
            brole=false;
        }
        if(qName.equalsIgnoreCase("Employee")){
            employees.add(emp);
        }
    }

    @Override
    public void characters (char ch[], int start, int length)
            throws SAXException
    {
        System.out.print(new String(ch,start,length));
        data.append(new String(ch,start,length));
    }
}
