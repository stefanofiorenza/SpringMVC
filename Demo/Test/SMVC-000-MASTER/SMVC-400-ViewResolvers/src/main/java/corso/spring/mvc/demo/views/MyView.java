package corso.spring.mvc.demo.views;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

public class MyView implements View{

	
	@Override
	public String getContentType() {		
		return AbstractView.DEFAULT_CONTENT_TYPE;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Response from Custom View</h1>");
		out.println("<h1>Data In Model:</h1>");
		out.println(model.get("msg"));
		out.println("</body>");
		out.println("</html>");
	}

}
