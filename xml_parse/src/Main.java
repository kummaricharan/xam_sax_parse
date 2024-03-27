import entity.Employee;
import handler.EmployeeHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        EmployeeHandler employeeHandler = new EmployeeHandler();
        saxParser.parse("employee.xml",employeeHandler);
        List<Employee> employees = employeeHandler.getEmployees();
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }
}