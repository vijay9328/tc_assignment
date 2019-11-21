package com.truecover.movietrailer.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.truecover.movietrailer.model.MovieDetails;

public interface MovieTrailerService {

	public MovieDetails getMovieDetails() throws GeneralSecurityException, IOException;

}
