package example;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	name="helloservlet",
			urlPatterns= {
					"/greeting","/salute"
			},
			loadOnStartup=1
)

	public class HelloServlet extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
    private static final String DEFUALT_USER="GUEST"; 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("user");
		if(user==null)
			user=HelloServlet.DEFUALT_USER;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter printWriter=response.getWriter();
		printWriter.append("<!DOCTYPE html>\r\n")

		
		.append("<html>")
		.append("<head>")
		
		.append("<title> Hello User Application</title>")
		.append("</head>")
		.append("<body>")
		.append("Hello,  ").append(user).append("<br><br>")
		.append("<form action=\"greeting\" method=\"post\">\n")
		.append("Enter your name:").append("<input type=\"text\" name=\"user\"/><br/>")
		.append("<input type=\"submit\" value=\"Submit\" /><br>")
		.append("</form>")
		.append("</body>")
		.append("</html>");
		
		//response.getWriter().println("Hello World");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest httpServlet,HttpServletResponse httpServletResponse) throws ServletException,IOException
	{
		this.doGet(httpServlet, httpServletResponse);
	}
	
	public void init() throws ServletException
	{
		System.out.println(this.getServletConfig());
	}

	public void destroy()
	{
		System.out.println(this.getServletName());

	}
	

}
