package com.peoplehum.tag.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString(doNotUseGetters = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TAGS_INFO")
public class TagEntity implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "CUSTOMER_ID")
  private Long customerId;

  @Column(name = "TAG_NAME")
  private String tagName;

  @Column(name = "TAG_CATEGORY")
  private String tagCategory;

  public TagEntity(Long customerId, String tagName, String tagCategory) {
    this.customerId = customerId;
    this.tagName = tagName;
    this.tagCategory = tagCategory;
  }

  //  @JsonIgnore
//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "CUSTOMER_ID", insertable = false, updatable = false)
//  private CustomerEntity customerEntity;


}