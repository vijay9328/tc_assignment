package com.truecover.movietrailer.client;
import java.io.IOException;
import java.security.GeneralSecurityException;

import com.truecover.movietrailer.controller.MovieTrailerController;

public class client {

	public static void main(String[] args) throws GeneralSecurityException, IOException {
		MovieTrailerController movieTrailerController = new MovieTrailerController();
		movieTrailerController.getMovieDetails();

	}

}
