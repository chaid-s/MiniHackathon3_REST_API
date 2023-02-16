package com.perscholas.RestApi_Group4.repository.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {
	private String title, year, rated, released, runtime, genre, director, writer, actors, plot, language, country, awards, poster, ratings;
}
