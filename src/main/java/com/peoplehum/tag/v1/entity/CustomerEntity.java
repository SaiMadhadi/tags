package com.peoplehum.tag.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString(doNotUseGetters = true, exclude = {"tagEntities"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerEntity implements Serializable {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "CUSTOMER_ID")
  private Long customerId;

  @Column(name = "NAME")
  private String name;

  @Column(name = "AGE")
  private int age;

  @Column(name = "Email")
  private String email;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", updatable = false, insertable = false)
  private Set<TagEntity> tagEntities;

}

