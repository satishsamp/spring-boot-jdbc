package com.example.springbootjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootjdbc.entity.Tutorial;
import com.example.springbootjdbc.service.TutorialService;


//This is main RestController class.
@RestController
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	TutorialService tutorialService;

	// done
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
		// try {
		List<Tutorial> tutorials = tutorialService.getAllTutorials(title);
		if (tutorials.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tutorials, HttpStatus.OK);
		// } catch (Exception e) {
		// return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		// }
	}

	// done
	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
		// Tutorial tutorial = tutorialRepository.findById(id);
		Tutorial tutorial = tutorialService.findTutorialById(id);
		if (tutorial != null) {
			return new ResponseEntity<>(tutorial, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// done
	@PostMapping("/tutorials")
	public ResponseEntity<String> createTutorial(@RequestBody Tutorial tutorial) {
		// try {
		tutorialService.save(tutorial);
		return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
		// } catch (Exception e) {
		// return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		// }
	}

	// done
	@PutMapping("/tutorials/{id}")
	public ResponseEntity<String> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {

		Tutorial _tutorial = tutorialService.findTutorialById(id);
		if (_tutorial != null) {
			tutorialService.updateTutorial(_tutorial, tutorial);
			return new ResponseEntity<>("Tutorial was updated successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.NOT_FOUND);
		}
	}

	// done
	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id) {
		// try {
		int result = tutorialService.deleteTutorialById(id);
		if (result == 0) {
			return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.OK);
		}
		return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
		// } catch (Exception e) {
		// return new ResponseEntity<>("Cannot delete tutorial.",
		// HttpStatus.INTERNAL_SERVER_ERROR);
		// }
	}

	// done
	@DeleteMapping("/tutorials")
	public ResponseEntity<String> deleteAllTutorials() {
		// try {
		int numRows = tutorialService.deleteAllTutorials();
		return new ResponseEntity<>("Deleted " + numRows + " Tutorial(s) successfully.", HttpStatus.OK);
		// } catch (Exception e) {
		// return new ResponseEntity<>("Cannot delete tutorials.",
		// HttpStatus.INTERNAL_SERVER_ERROR);
		// }
	}

	// done
	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorial>> findByPublished() {
		// try {
		List<Tutorial> tutorials = tutorialService.findByPublished();

		if (tutorials.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		int c = 100 / 0;
		return new ResponseEntity<>(tutorials, HttpStatus.OK);
	}
}