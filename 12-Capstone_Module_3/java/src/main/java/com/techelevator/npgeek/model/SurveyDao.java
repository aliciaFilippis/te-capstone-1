package com.techelevator.npgeek.model;

import java.util.List;

public interface SurveyDao {
	
	public void save(Survey post);

	Survey getSurveyById(int id);
}
