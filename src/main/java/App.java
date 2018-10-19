import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRSaver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws FileNotFoundException, JRException {
        System.out.println("====== Start ======");

        String staticPath = "/data/Tax/Report/";

        String projectPath = "/Users/chalernchai.jin/acm-tmn-tax/TaxEJB/src/main/resources/report/";

        List<String> stringList = new ArrayList<String>();
        stringList.add("TAX_T102_List_Detail");

        InputStream inputStream = null;
        for (String strReport : stringList) {
            File file = new File(projectPath + strReport + ".jrxml");
            inputStream = new FileInputStream(file);
            JasperReport jasperReport = JasperCompileManager
                    .compileReport(inputStream);

            JRSaver.saveObject(jasperReport, projectPath + strReport + ".jasper");

            System.out.println("====== Compile " + strReport + " Success. ======");
        }

        System.out.println("====== Finish ======");
    }
}
