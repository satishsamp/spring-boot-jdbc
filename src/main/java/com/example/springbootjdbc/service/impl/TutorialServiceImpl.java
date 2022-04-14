package com.example.springbootjdbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootjdbc.dao.TutorialRepository;
import com.example.springbootjdbc.entity.Tutorial;
import com.example.springbootjdbc.service.TutorialService;
// changes added to serviceImpl
// second changes added to the serviceImpl

@Service
public class TutorialServiceImpl implements TutorialService {
	@Autowired
	TutorialRepository tutorialRepository;

	public void save(Tutorial tutorial) {
		tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
	}

	public Tutorial findTutorialById(long id) {
		Tutorial tutorial = tutorialRepository.findById(id);
		return tutorial;
	}

	public List<Tutorial> getAllTutorials(String title) {
		List<Tutorial> tutorials = new ArrayList<Tutorial>();
		if (title == null)
			tutorialRepository.findAll().forEach(tutorials::add);
		else
			tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
		return tutorials;
	}

	public void updateTutorial(Tutorial _tutorial, Tutorial tutorial) {
		if (_tutorial != null) {
			_tutorial.setId(_tutorial.getId());
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());

			tutorialRepository.update(_tutorial);
		}
	}

	public int deleteTutorialById(long id) {
		int result = tutorialRepository.deleteById(id);
		return result;
	}

	public int deleteAllTutorials() {
		return tutorialRepository.deleteAll();
	}

	public List<Tutorial> findByPublished() {
		return tutorialRepository.findByPublished(true);
	}
}
