package com.peoplehum.tag.service;

import com.peoplehum.tag.common.model.TagResponseObject;
import com.peoplehum.tag.v1.model.TagModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CustomerInfoService {

  TagResponseObject<TagModel> addTagForCustomer(TagModel tagModel);

  TagResponseObject<TagModel> deleteTagForCustomer(Long customerId, String tagName); // Test Done

  TagResponseObject<TagModel> editTagOfCustomer(TagModel tagModel, String tagName); //Test Done

  TagResponseObject<List<String>> getAllTagsOfCustomer(Long customerId); //Test Done

  TagResponseObject<TagModel> getTagOfCustomer(Long customerId, String tagName); //Test Done

  TagResponseObject<Page<TagModel>> getPaginatedListOfTags(Long customerId, Pageable pageable);

}
