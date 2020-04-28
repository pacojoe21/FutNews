package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeTeamResource;
import aiss.model.youtube.YoutubeSearch;

/**
 * Servlet implementation class TeamController
 */
public class TeamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(TeamController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		//Search for videos in Youtube
		log.log(Level.FINE, "Searching for videos in Youtube whose title contain " + query
				);
		YoutubeTeamResource videos = new YoutubeTeamResource();
		YoutubeSearch youtubeResults = videos.getVideo(query);
		
		if(youtubeResults !=null) {
		
		rd = request.getRequestDispatcher("/success.jsp");
		request.setAttribute("items", youtubeResults.getItems());
	}else {
		log.log(Level.SEVERE, ". YouTube object: " + youtubeResults);
		rd = request.getRequestDispatcher("/error.jsp");
	}
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
