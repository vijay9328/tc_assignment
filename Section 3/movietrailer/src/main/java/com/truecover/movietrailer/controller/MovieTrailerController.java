package com.truecover.movietrailer.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.truecover.movietrailer.model.MovieDetails;
import com.truecover.movietrailer.service.MovieTrailerService;

@Controller
public class MovieTrailerController {

	@Autowired
	MovieTrailerService movieTrailerService;
	
	public MovieDetails getMovieDetails() throws GeneralSecurityException, IOException {
		return movieTrailerService.getMovieDetails();
		
	}
}
