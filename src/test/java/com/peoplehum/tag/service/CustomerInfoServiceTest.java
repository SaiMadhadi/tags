package com.peoplehum.tag.service;

import com.peoplehum.tag.repository.CustomerRepository;
import com.peoplehum.tag.repository.TagRepository;
import com.peoplehum.tag.service.impl.CustomerInfoServiceImpl;
import com.peoplehum.tag.v1.entity.TagEntity;
import com.peoplehum.tag.v1.model.TagModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class CustomerInfoServiceTest {

  @Mock
  CustomerRepository customerRepository;

  @Mock
  TagRepository tagRepository;

  @InjectMocks
  CustomerInfoServiceImpl customerInfoService;


  private InOrder inOrder;

 // @Before
//  public void setup() {
//    inOrder =
//        Mockito.inOrder(customerRepository, tagRepository);
//  }

//  @Test
//  public void getAllTagsOfCustomerTest1()
//  {
//    Set<TagEntity> set = new HashSet<>();
//    set.add(new TagEntity(1L,"c","skills"));
//    set.add(new TagEntity(2L,"c++","skills"));
//    set.add(new TagEntity(3L,"java","skills"));
//
//    Set<String> strings = new HashSet<>();
//    strings.add("c");
//    strings.add("c++");
//    strings.add("java");
//
//    when(customerRepository.findByCustomerId(1L)).thenReturn(new CustomerEntity(1L,1L,"abc",10,"abc@coviam.com",set));
//    Assert.assertEquals(strings,customerInfoService.getAllTagsOfCustomer(1L));
//  }

//  @Test
//  public void getAllTagsOfCustomerTest2()
//  {
//    Set<TagEntity> set = new HashSet<>();
//    set.add(new TagEntity(1L,"c","skills"));
//    set.add(new TagEntity(2L,"c++","skills"));
//    set.add(new TagEntity(3L,"Java","skills"));
//
//    Set<String> strings = new HashSet<>();
//    strings.add("c");
//    strings.add("c++");
//    strings.add("Java");
//
//    when(customerRepository.findByCustomerId(1L)).thenReturn(new CustomerEntity(1L,1L,"abc",10,"abc@coviam.com"));
//    Assert.assertEquals(strings,customerInfoService.getAllTagsOfCustomer(1L));
//  }

//  @Test
//  public void addTagForCustomerTest1()
//  {
//    TagModel tagModel = new TagModel(2L,"c#","skills");
//
//    TagEntity tagEntity = new TagEntity(2L,"c#","skills");
//
//    TagEntity newTagEntity = new TagEntity(2L,"c#","skills");
//    newTagEntity.setId(1L);
//    TagModel newTagModel = new TagModel(2L,"c#","skills");
//    newTagModel.setId(1L);
//    when(tagRepository.save(tagEntity)).thenReturn(newTagEntity);
//    Assert.assertEquals(newTagModel,customerInfoService.addTagForCustomer(tagModel));
//  }
//
  @Test
  public void editTagOfCustomerTest1()
  {
    TagEntity tagEntity = new TagEntity(1L,"java","skills");
    tagEntity.setId(1L);
    TagEntity newTagEntity = new TagEntity(1L,"javaEE","skills");
    newTagEntity.setId(1L);

    TagModel tagModel = new TagModel(1L,"javaEE","skills");
    tagModel.setId(1L);
    when(tagRepository.findByCustomerIdAndTagName(1L,"java")).thenReturn(tagEntity);

    when(tagRepository.save(any(TagEntity.class))).thenAnswer(new Answer<TagEntity>() {
      @Override
      public TagEntity answer(InvocationOnMock invocation) throws Throwable {
        TagEntity entityToSave = (TagEntity)invocation.getArguments()[0];

        return null;
      }
    });

    Assert.assertEquals(tagModel.toString(),customerInfoService.editTagOfCustomer(tagModel,"java").toString());
  }

  @Test
  public void editTagOfCustomerTest2()
  {
    TagEntity tagEntity = new TagEntity(2L,"c","skills");
    tagEntity.setId(2L);
    TagEntity newTagEntity = new TagEntity(2L,"c#","skill");
    newTagEntity.setId(2L);

    TagModel tagModel = new TagModel(2L,"c#","skill");
    tagModel.setId(2L);
    when(tagRepository.findByCustomerIdAndTagName(2L,"c")).thenReturn(tagEntity);
    when(tagRepository.findByCustomerIdAndTagName(2L,"c#")).thenReturn(newTagEntity);
    Assert.assertEquals(tagModel.toString(),customerInfoService.editTagOfCustomer(tagModel,"c").toString());
  }

  @Test
  public void deleteTagOfCustomerTest1()
  {
    TagEntity tagEntity = new TagEntity(1L,"java","skills");
    tagEntity.setId(1L);
    TagModel tagModel = new TagModel(1L,"java","skills");
    tagModel.setId(1L);
    when(tagRepository.findByCustomerIdAndTagName(1L,"java")).thenReturn(tagEntity);
    Assert.assertEquals(tagModel.toString(),customerInfoService.deleteTagForCustomer(1L,"java").toString());
  }

  @Test
  public void deleteTagOfCustomerTest2()
  {
    TagEntity tagEntity = new TagEntity(2L,"html","skills");
    tagEntity.setId(2L);
    TagModel tagModel = new TagModel(2L,"html","skills");
    tagModel.setId(2L);
    when(tagRepository.findByCustomerIdAndTagName(2L,"html")).thenReturn(tagEntity);
    Assert.assertEquals(tagModel.toString(),customerInfoService.deleteTagForCustomer(2L,"html").toString());
  }

  @Test
  public void getTagOfCustomerTest1()
  {
    TagEntity tagEntity = new TagEntity(1L,"java","skills");
    tagEntity.setId(1L);
    TagModel tagModel = new TagModel(1L,"java","skills");
    tagModel.setId(1L);
    when(tagRepository.findByCustomerIdAndTagName(1L,"java")).thenReturn(tagEntity);
    Assert.assertEquals(tagModel.toString(),customerInfoService.getTagOfCustomer(1L,"java").toString());

  }
  @Test
  public void getTagOfCustomerTest2()
  {
    TagEntity tagEntity = new TagEntity(2L,"c++","skills");
    tagEntity.setId(2L);
    TagModel tagModel = new TagModel(2L,"c++","skills");
    tagModel.setId(2L);
    when(tagRepository.findByCustomerIdAndTagName(2L,"c++")).thenReturn(tagEntity);
    Assert.assertEquals(tagModel.toString(),customerInfoService.getTagOfCustomer(2L,"c++").toString());

  }


//  @After
//  public void finish(){
//    inOrder.verifyNoMoreInteractions();
//  }
}

