package corso.spring.mvc.demo.views;

import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class FileFormatConsts {

	public static final String EXPORT_CSV="export/csvView"; //match con rest-views-context
	public static final String EXPORT_EXCEL="export/excelView"; 
	public static final String EXPORT_DATA="exported";
	
	public static final String[] HEADER_NAMES={
		"id","name","telephone","active"	
	};
	
	public static final int EXCL_HEADER_ROW_NUMBER = 3;
	public static final int EXCL_ROW_START_CELL_POSITION = 2;
	
	public static final  CellProcessor[] CSV_CELL_PROCESSORS = new CellProcessor[] {           
        new ParseLong(), //id
		new NotNull(), // name
        new NotNull(), // telephone   
        new NotNull()  //active
	};
}
