package com.peoplehum.tag.service;

import com.peoplehum.tag.repository.CustomerRepository;
import com.peoplehum.tag.repository.TagRepository;
import com.peoplehum.tag.service.impl.TagsInfoServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TagsInfoServiceTest {
  @Mock
  CustomerRepository customerRepository;

  @Mock
  TagRepository tagRepository;

  @InjectMocks
  TagsInfoServiceImpl tagsInfoService;
//
//  @Test
//  public void searchForIgnoreCaseTagTest1()
//  {
//    Set<TagEntity> tagEntitySet = new HashSet<>();
//
//    Set<String> strings = new HashSet<>();
//    strings.add("c");
//    strings.add("c++");
//    strings.add("c#");
//    when(tagRepository.findByTagNameStartingWithAndTagCategory("c","skills")).thenReturn(strings);
//  }
}
