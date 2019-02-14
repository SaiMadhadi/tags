package com.peoplehum.tag.service.impl;

import com.peoplehum.tag.common.model.TagResponseObject;
import com.peoplehum.tag.common.model.TagStatusCode;
import com.peoplehum.tag.repository.TagRepository;
import com.peoplehum.tag.service.TagsInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service("com.peoplehum.tag.service.impl.TagsInfoServiceImpl")
@Slf4j
public class TagsInfoServiceImpl implements TagsInfoService {

  @Autowired
  @Qualifier("com.peoplehum.tag.repository.TagRepository")
  private TagRepository tagRepository;

  @Override
  public TagResponseObject<List<String>> searchForTagStartingWith(String tagName,
      String tagCategory, String caseSensitive) {

    List<String> tagList;
    if (caseSensitive.equalsIgnoreCase("true")) {
      tagList = tagRepository
          .findTagNameByTagNameStartingWithAndTagCategoryCaseSensitive(tagName, tagCategory);
    } else {
      tagList = tagRepository.findTagNameByTagNameStartingWithAndTagCategory(tagName, tagCategory);
    }
    TagResponseObject<List<String>> tagResponseObject =
        new TagResponseObject<>(TagStatusCode.SUCCESS);
    if (CollectionUtils.isNotEmpty(tagList)) {
      tagResponseObject.setResponseObject(tagList);
    } else {
      tagResponseObject.setResponseObject(Collections.EMPTY_LIST);
    }
    return tagResponseObject;

  }

  //  public TagResponseObject<List<String>> searchForTagStartingWithAndCaseSensitive(String
  //  tagName,String tagCategory) {
  //
  //    List<String> tagList =
  //        tagRepository.findTagNameByTagNameStartingWithAndTagCategoryCaseSensitive(tagName,
  //        tagCategory);
  //    TagResponseObject<List<String>> tagResponseObject = new TagResponseObject<>(TagStatusCode
  //    .SUCCESS);
  //    if(CollectionUtils.isNotEmpty(tagList)){
  //      tagResponseObject.setResponseObject(tagList);
  //    } else {
  //      tagResponseObject.setResponseObject(Collections.EMPTY_LIST);
  //    }
  //    return tagResponseObject;
  //
  //  }

  @Override
  public TagResponseObject<List<String>> getAllTags() {

    TagResponseObject<List<String>> tagResponseObject =
        new TagResponseObject<>(TagStatusCode.SUCCESS);

    List<String> tagList = tagRepository.findAllTags();
    if (CollectionUtils.isNotEmpty(tagList)) {
      tagResponseObject.setResponseObject(tagList);
    } else {
      tagResponseObject.setResponseObject(Collections.EMPTY_LIST);
    }

    return tagResponseObject;
  }
}
