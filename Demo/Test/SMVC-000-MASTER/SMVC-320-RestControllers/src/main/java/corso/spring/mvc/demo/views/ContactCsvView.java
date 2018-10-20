package corso.spring.mvc.demo.views;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import corso.spring.mvc.crm.services.beans.Contact;
import corso.spring.mvc.demo.rest.beans.Employee;
import corso.spring.mvc.demo.rest.beans.ExportWrapper;

public class ContactCsvView extends AbstractView {

	private String fileName;
	 
	private static final String CONTENT_TYPE="text/csv";
	
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
	
    @PostConstruct
    public void init(){
    	setContentType(CONTENT_TYPE);
    }
    
    
    @Override
	protected void prepareResponse(HttpServletRequest request,
            HttpServletResponse response) {
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                fileName);
        response.setContentType(CONTENT_TYPE);
        response.setHeader(headerKey, headerValue);
    }
    
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				 CsvPreference.STANDARD_PREFERENCE); 
	      buildCsvDocument(csvWriter, model);
	      csvWriter.close();		
	}

	private void buildCsvDocument(ICsvBeanWriter csvWriter,
			Map<String, Object> model) throws IOException {

		  csvWriter.writeHeader(FileFormatConsts.HEADER_NAMES);
		  List<Contact> contacList=(List<Contact>)model.get(FileFormatConsts.EXPORT_DATA);
		  for (Contact selected : contacList){			
			  csvWriter.write(selected, FileFormatConsts.HEADER_NAMES, FileFormatConsts.CSV_CELL_PROCESSORS);  
		  }
		
		
	}
	
	

}