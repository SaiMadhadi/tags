package com.peoplehum.tag.service.impl;

import com.peoplehum.tag.common.model.TagResponseObject;
import com.peoplehum.tag.common.model.TagStatusCode;
import com.peoplehum.tag.repository.CustomerRepository;
import com.peoplehum.tag.repository.TagRepository;
import com.peoplehum.tag.service.CustomerInfoService;
import com.peoplehum.tag.util.TagUtility;
import com.peoplehum.tag.v1.entity.TagEntity;
import com.peoplehum.tag.v1.model.TagModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service("com.peoplehum.tag.service.impl.CustomerInfoServiceImpl")
@Slf4j
public class CustomerInfoServiceImpl implements CustomerInfoService {

  @Autowired
  @Qualifier("com.peoplehum.tag.repository.CustomerRepository")
  private CustomerRepository customerRepository;

  @Autowired
  @Qualifier("com.peoplehum.tag.repository.TagRepository")
  private TagRepository tagRepository;

  @Autowired
  @Qualifier("com.peoplehum.tag.util.TagUtility")
  private TagUtility tagUtility;

  @Override
  @Transactional
  public TagResponseObject<TagModel> addTagForCustomer(TagModel tagModel) {

    TagResponseObject<TagModel> tagResponseObject = new TagResponseObject<>(TagStatusCode.SUCCESS);
    TagEntity tagEntity = tagUtility.convertTagModelToEntity(tagModel);
    tagRepository.save(tagEntity);
    TagModel responseTagModel = tagUtility.convertEntityToModel(tagEntity);
    tagResponseObject.setResponseObject(responseTagModel);
    return tagResponseObject;
  }

  @Override
  @Transactional
  public TagResponseObject<TagModel> deleteTagForCustomer(Long customerId, String tagName) {
    TagResponseObject<TagModel> tagResponseObject = new TagResponseObject<>(TagStatusCode.SUCCESS);
    TagEntity tagEntity = tagRepository.findByCustomerIdAndTagName(customerId, tagName);
    TagModel tagModel = tagUtility.convertEntityToModel(tagEntity);
    tagRepository.delete(tagEntity);
    tagResponseObject.setResponseObject(tagModel);
    return tagResponseObject;
  }

  @Override
  public TagResponseObject<List<String>> getAllTagsOfCustomer(Long customerId) {

    List<String> tagList = tagRepository.findTagNameByCustomerId(customerId);

    TagResponseObject<List<String>> tagResponseObject =
        new TagResponseObject<>(TagStatusCode.SUCCESS);
    if (CollectionUtils.isNotEmpty(tagList)) {
      tagResponseObject.setResponseObject(tagList);
    } else {
      tagResponseObject.setResponseObject(Collections.EMPTY_LIST);
    }
    return tagResponseObject;
  }

  @Override
  public TagResponseObject<TagModel> getTagOfCustomer(Long customerId, String tagName) {
    TagEntity tagEntity = tagRepository.findByCustomerIdAndTagName(customerId, tagName);
    TagResponseObject<TagModel> tagResponseObject = new TagResponseObject<>(TagStatusCode.SUCCESS);
    if (tagEntity != null) {
      tagResponseObject.setResponseObject(tagUtility.convertEntityToModel(tagEntity));
    }
    return tagResponseObject;
  }

  @Override
  @Transactional
  public TagResponseObject<TagModel> editTagOfCustomer(TagModel tagModel, String tagName) {
    TagEntity tagEntity =
        tagRepository.findByCustomerIdAndTagName(tagModel.getCustomerId(), tagName);
    TagResponseObject<TagModel> tagResponseObject = new TagResponseObject<>(TagStatusCode.SUCCESS);
    tagEntity.setTagName(tagModel.getTagName());
    tagEntity.setTagCategory(tagModel.getTagCategory());
    tagRepository.save(tagEntity);
    tagResponseObject.setResponseObject(tagUtility.convertEntityToModel(tagEntity));
    return tagResponseObject;
  }

  @Override
  public TagResponseObject<Page<TagModel>> getPaginatedListOfTags(Long customerId,
      Pageable pageable) {

    Page<TagEntity> tagEntityPage = tagRepository.findByCustomerId(customerId, pageable);
    Page<TagModel> tagModelPage = tagEntityPage.map(tagUtility::convertEntityToModel);
    TagResponseObject<Page<TagModel>> tagResponseObject =
        new TagResponseObject<>(TagStatusCode.SUCCESS);
    tagResponseObject.setResponseObject(tagModelPage);
    return tagResponseObject;
  }
}
