package com.peoplehum.tag.controller;

import com.peoplehum.tag.common.model.TagResponseObject;
import com.peoplehum.tag.service.CustomerInfoService;
import com.peoplehum.tag.v1.model.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerInfoController {

  @Autowired
  @Qualifier("com.peoplehum.tag.service.impl.CustomerInfoServiceImpl")
  private CustomerInfoService customerInfoService;

  //Get All Tags of a Customer
  @GetMapping("customer/{customerId}/tag")
  public ResponseEntity<TagResponseObject<List<String>>> getAllTags(
      @PathVariable("customerId") Long customerId) {
    TagResponseObject<List<String>> tagResponseObject =
        customerInfoService.getAllTagsOfCustomer(customerId);
    return new ResponseEntity<>(tagResponseObject, tagResponseObject.getStatusCode());
  }

  //Get Tag of a Customer
  @GetMapping("customer/{customerId}/tag/{tagName}")
  public ResponseEntity<TagResponseObject<TagModel>> getTagForCustomer(
      @PathVariable("customerId") Long customerId, @PathVariable("tagName") String tagName) {
    TagResponseObject<TagModel> tagResponseObject =
        customerInfoService.getTagOfCustomer(customerId, tagName);
    return new ResponseEntity<>(tagResponseObject, tagResponseObject.getStatusCode());
  }

  //Add Tag to a Customer
  @PostMapping("customer/{customerId}/tag")
  public ResponseEntity<TagResponseObject<TagModel>> addTagForCustomer(
      @PathVariable("customerId") Long customerId, @RequestBody TagModel tagModel) {
    TagResponseObject<TagModel> tagResponseObject = customerInfoService.addTagForCustomer(tagModel);
    return new ResponseEntity<>(tagResponseObject, tagResponseObject.getStatusCode());
  }

  //Edit Tag of a Customer
  @PutMapping("customer/{customerId}/tag/{tagName}")
  public ResponseEntity<TagResponseObject<TagModel>> editTag(
      @PathVariable("customerId") Long customerId, @PathVariable("tagName") String tagName,
      @RequestBody TagModel tagModel) {
    TagResponseObject<TagModel> tagResponseObject =
        customerInfoService.editTagOfCustomer(tagModel, tagName);
    return new ResponseEntity<>(tagResponseObject, tagResponseObject.getStatusCode());
  }

  //Delete Tag of a Customer
  @DeleteMapping("customer/{customerId}/tag/{tagName}")
  public ResponseEntity<TagResponseObject<TagModel>> deleteTag(
      @PathVariable("customerId") Long customerId, @PathVariable("tagName") String tagName) {

    TagResponseObject<TagModel> tagResponseObject =
        customerInfoService.deleteTagForCustomer(customerId, tagName);

    return new ResponseEntity<>(tagResponseObject, tagResponseObject.getStatusCode());
  }

  // Get all tags of a customer in paginated form
  @GetMapping("customer/{customerId}/tag/pag")
  public ResponseEntity<TagResponseObject<Page<TagModel>>> getPaginatedTagList(
      @PathVariable("customerId") Long customerId, Pageable pageable) {
    TagResponseObject<Page<TagModel>> tagResponseObjectPage =
        customerInfoService.getPaginatedListOfTags(customerId, pageable);
    return new ResponseEntity<>(tagResponseObjectPage, tagResponseObjectPage.getStatusCode());
  }
}
