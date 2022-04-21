package com.example.springbootjdbc.service;

import java.util.List;
//changes added to serviceImpl
//second changes added to the serviceImpl
// This change is through the eclipse
// This  change is trhough the eclipse 2


//  Ths is new changes committed through eclipse in teh master
// Ths is new changes committed through eclipse in teh master

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
