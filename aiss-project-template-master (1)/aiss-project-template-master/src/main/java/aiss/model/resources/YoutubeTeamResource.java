package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.youtube.YoutubeSearch;



public class YoutubeTeamResource {
	

	private static final String YOUTUBE_API_KEY = "AIzaSyCS1ILJqVfTVqTBvCkWBXolBw3UmF-RaDI";
	private static final Logger log = Logger.getLogger(YoutubeTeamResource.class.getName());
	
	
public YoutubeSearch getVideo(String query) throws UnsupportedEncodingException {
		

		
		
		String uri = 
				  "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=5&q="+ URLEncoder.encode(query,"UTF-8") + "&key=" + YOUTUBE_API_KEY;
			

		log.log(Level.FINE, "Youtube URI: " + uri);
		
		ClientResource cr = new ClientResource(uri);
	    YoutubeSearch videoSearch = cr.get(YoutubeSearch.class);
	    
	    return videoSearch;
	}

}
