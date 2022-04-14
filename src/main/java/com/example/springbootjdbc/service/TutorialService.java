package com.example.springbootjdbc.service;

import java.util.List;
//changes added to serviceImpl
//second changes added to the serviceImpl


import com.example.springbootjdbc.entity.Tutorial;

public interface TutorialService {
	public void save(Tutorial tutorial);

	public Tutorial findTutorialById(long id);

	public List<Tutorial> getAllTutorials(String title);

	public void updateTutorial(Tutorial _tutorial, Tutorial tutorial);

	public int deleteTutorialById(long id);

	public int deleteAllTutorials();

	public List<Tutorial> findByPublished();
}
