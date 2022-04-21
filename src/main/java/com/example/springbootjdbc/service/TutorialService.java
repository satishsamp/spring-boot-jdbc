package com.example.springbootjdbc.service;

import java.util.List;
//changes added to serviceImpl
//second changes added to the serviceImpl
// this is change from intelliJ
// This change is through the eclipse
// this is change from intelliJ 2
// This  change is trhough the eclipse 2
import com.example.springbootjdbc.entity.Tutorial;
// This is reset test 1
// This is reset test 2
public interface TutorialService {
	public void save(Tutorial tutorial);

	public Tutorial findTutorialById(long id);

	public List<Tutorial> getAllTutorials(String title);

	public void updateTutorial(Tutorial _tutorial, Tutorial tutorial);

	public int deleteTutorialById(long id);

	public int deleteAllTutorials();

	public List<Tutorial> findByPublished();
}
