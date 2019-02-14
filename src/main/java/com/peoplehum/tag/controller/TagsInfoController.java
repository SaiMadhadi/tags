package com.peoplehum.tag.controller;

import com.peoplehum.tag.common.model.TagResponseObject;
import com.peoplehum.tag.service.TagsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TagsInfoController {

  @Autowired
  @Qualifier("com.peoplehum.tag.service.impl.TagsInfoServiceImpl")
  private TagsInfoService tagsInfoService;

  @GetMapping("tag")
  public ResponseEntity<TagResponseObject<List<String>>> getAll() {

    TagResponseObject<List<String>> tagResponseObject = tagsInfoService.getAllTags();
    return new ResponseEntity<>(tagResponseObject, HttpStatus.OK);
  }

  //  @GetMapping("tag/{tagName}/")
  //  public ResponseEntity<TagResponseObject<List<String>>> searchTagStartingWithIgnoreCase(
  //      @PathVariable("tagName") String tagName, @RequestParam("tagCategory") String
  //      tagCategory, @RequestParam("caseSensitive") String caseSensitive ) {
  //    TagResponseObject<List<String>> tagResponseObject = tagsInfoService
  //    .searchForTagStartingWithAndIgnoreCase(tagName,tagCategory);
  //    return new ResponseEntity<>(tagResponseObject, tagResponseObject.getStatusCode());
  //  }

  @GetMapping("tag/{tagName}")
  public ResponseEntity<TagResponseObject<List<String>>> searchTagStartingWith(
      @PathVariable("tagName") String tagName, @RequestParam("tagCategory") String tagCategory,
      @RequestParam("caseSensitive") String caseSensitive) {

    TagResponseObject<List<String>> tagResponseObject =
        tagsInfoService.searchForTagStartingWith(tagName, tagCategory, caseSensitive);
    return new ResponseEntity<>(tagResponseObject, tagResponseObject.getStatusCode());
  }

}
