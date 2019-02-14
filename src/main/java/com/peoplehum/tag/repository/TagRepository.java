package com.peoplehum.tag.repository;

import com.peoplehum.tag.v1.entity.TagEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("com.peoplehum.tag.repository.TagRepository")
public interface TagRepository extends JpaRepository<TagEntity, Long> {

  TagEntity findByCustomerId(Long customerId);

  @Query(value = "SELECT DISTINCT TAG_NAME FROM TAGS_INFO WHERE TAG_NAME like concat(:tagName,'%') "
      + "AND TAG_CATEGORY = :tagCategory", nativeQuery = true)
  List<String> findTagNameByTagNameStartingWithAndTagCategory(@Param("tagName") String tagName,
      @Param("tagCategory") String tagCategory);

  @Query(value = "SELECT DISTINCT TAG_NAME FROM TAGS_INFO WHERE BINARY TAG_NAME like concat"
      + "(:tagName,'%') AND TAG_CATEGORY = :tagCategory", nativeQuery = true)
  List<String> findTagNameByTagNameStartingWithAndTagCategoryCaseSensitive(
      @Param("tagName") String tagName, @Param("tagCategory") String tagCategory);


  TagEntity findByCustomerIdAndTagName(Long customerId, String tagName);

  Page<TagEntity> findByCustomerId(Long customerId, Pageable pageable);

  @Query("SELECT DISTINCT tagName FROM TagEntity t WHERE t.customerId = :customerId")
  List<String> findTagNameByCustomerId(@Param("customerId") Long customerId);

  @Query("SELECT DISTINCT tagName FROM TagEntity")
  List<String> findAllTags();
}
