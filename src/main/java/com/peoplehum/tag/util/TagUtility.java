package com.peoplehum.tag.util;

import com.peoplehum.tag.v1.entity.TagEntity;
import com.peoplehum.tag.v1.model.TagModel;
import org.springframework.stereotype.Component;

@Component("com.peoplehum.tag.util.TagUtility")
public class TagUtility {
  public TagModel convertEntityToModel(TagEntity tagEntity) {
    TagModel tagModel = new TagModel();
    tagModel.setId(tagEntity.getId());
    tagModel.setCustomerId(tagEntity.getCustomerId());
    tagModel.setTagName(tagEntity.getTagName());
    tagModel.setTagCategory(tagEntity.getTagCategory());
    return tagModel;
  }

  public TagEntity convertTagModelToEntity(TagModel tagModel) {
    TagEntity tagEntity = new TagEntity();
    tagEntity.setCustomerId(tagModel.getCustomerId());
    tagEntity.setTagName(tagModel.getTagName());
    tagEntity.setTagCategory(tagModel.getTagCategory());
    return tagEntity;
  }
}

