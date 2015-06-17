package copy.slack.integration01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SlashCommands
 */
public class SlashCommands extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static String token = "2bhTyY4WemvE8DfyMJH44oYl";

    /**
     * Default constructor. 
     */
    public SlashCommands() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String urlparameters = request.getQueryString();
		if(urlparameters != null)
		{
			String[] queryArray = urlparameters.split("&");
			boolean verified = false;
			for(String str : queryArray)
			{
				String[] recqueryArray = str.split("=");
				if(recqueryArray[0].equals("token"))
				{
					if(recqueryArray[1].equals(token))
					{
						verified = true;
					}
				}
				
			}
			if(!verified)
			{
				response.sendError(500, "Incorrect Token or some Tweak in Between, So Request cannot be completed");
			}
			response.setStatus(200, "Correct Request Received from the Slack Team");
			response.addHeader("Copy", "Account");
			response.getWriter().write("Responding from Copy-Slack, the request is correct!");
		}
		else
		{
			response.getWriter().write("Query Parameter is missing..Not a Valid Rquest");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		if(request.getContentType().equals("application/x-www-form-urlencoded"))
		{
			
		}
		
		if(request.getContentType().equals("text/plain;charset=UTF-8"))
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String line = null;
		    while((line = in.readLine()) != null) {
		    	
		    }
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
