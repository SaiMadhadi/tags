package com.peoplehum.tag.service;

import com.peoplehum.tag.common.model.TagResponseObject;

import java.util.List;


public interface TagsInfoService {

  // TagResponseObject<List<String>> searchForTagStartingWithAndCaseSensitive(String tagName,
  // String tagCategory);
  TagResponseObject<List<String>> searchForTagStartingWith(String tagName, String tagCategory,
      String caseSensitive);

  TagResponseObject<List<String>> getAllTags();

}
