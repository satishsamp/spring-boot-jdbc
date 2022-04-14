package com.example.springbootjdbc.dao;

import java.util.List;

import com.example.springbootjdbc.entity.Tutorial;


//comment on the TutorialRepository added.
// comment 1 - satish
public interface TutorialRepository {
  int save(Tutorial book);

  int update(Tutorial book);

  Tutorial findById(Long id);

  int deleteById(Long id);

  List<Tutorial> findAll();

  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContaining(String title);

  int deleteAll();
}