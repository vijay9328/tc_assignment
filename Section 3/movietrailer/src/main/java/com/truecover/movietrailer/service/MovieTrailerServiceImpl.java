package com.truecover.movietrailer.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.truecover.movietrailer.model.MovieDetails;

public class MovieTrailerServiceImpl implements MovieTrailerService{
	
	private static final String CLIENT_SECRETS= "client_secret.json";
    private static final Collection<String> SCOPES =
        Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");

    private static final String APPLICATION_NAME = "API code samples";
    private static final JacksonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	@Override
	public MovieDetails getMovieDetails() throws GeneralSecurityException, IOException {
		MovieDetails output=new MovieDetails();
		YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.Search.List request = youtubeService.search()
            .list("Avengers");
        SearchListResponse response = request.execute();
        System.out.println("respnse : "+response);
        output.setResponse(response);
		return output;
	}
	
	public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = authorize(httpTransport);
        return new YouTube.Builder(httpTransport, JSON_FACTORY, credential)
            .setApplicationName(APPLICATION_NAME)
            .build();
    }
	
	   

	    /**
	     * Create an authorized Credential object.
	     *
	     * @return an authorized Credential object.
	     * @throws IOException
	     */
	    public static Credential authorize(final NetHttpTransport httpTransport) throws IOException {
	        // Load client secrets.
	        InputStream in = MovieTrailerServiceImpl.class.getResourceAsStream(CLIENT_SECRETS);
	        GoogleClientSecrets clientSecrets =
	          GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
	        // Build flow and trigger user authorization request.
	        GoogleAuthorizationCodeFlow flow =
	            new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
	            .build();
	        Credential credential = null;
			try {
				credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return credential;
	    }
	
}
