package com.peoplehum.tag.repository;


import com.peoplehum.tag.v1.entity.TagEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rushi on 2019-01-21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class},
    loader = AnnotationConfigContextLoader.class)
@Transactional
@Slf4j
public class TagRepositoryTest {

  @Autowired
  @Qualifier("com.peoplehum.tag.repository.TagRepository")
  private TagRepository tagRepository;

  @Before
  public void init() {
    TagEntity tagEntity = new TagEntity(1L,"c#","skills");
    tagEntity.setId(1L);
    log.info("{}",tagEntity);
    tagRepository.save(tagEntity);
  }


  @Test
  public void findByCustomerIdTest1_Success(){
    TagEntity tagEntity = new TagEntity(1L,"c#","skills");
    TagEntity dbTag = tagRepository.findByCustomerId(1L);
    Assert.assertEquals("db tag is not c#",tagEntity.getTagName(),dbTag.getTagName());
    Assert.assertEquals("db tag category is not skills",tagEntity.getTagCategory(),dbTag.getTagCategory());
  }


//
//  @Test
//  public void deleteByEnabledOrLastLoginTimeLessThanOrExpiresOnLessThan() {
//    int result = transactionAuthRepository
//        .deleteByEnabledOrLastLoginTimeLessThanOrExpiresOnLessThan(Boolean.FALSE,
//            Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()).minusMonths(6)),
//            Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC())));
//    assertEquals(transactionsEligibleForDeletion.size(), result);
//  }
//
//  @Test
//  public void findByTransactionIdAndEmailAndWorkflow_withValidDetails_returnsTransactionDetail() {
//    ExternalTransactionAuth transactionAuth =
//        ExternalTransactionAuth.builder().transactionId("1").email("email1@test.com")
//            .workflow("workflow1").transactionPassword("123").enabled(Boolean.TRUE).build();
//    Optional<ExternalTransactionAuth> result = transactionAuthRepository
//        .findByTransactionIdAndEmailAndWorkflow("1", "email1@test.com", "workflow1");
//    ExternalTransactionAuth actualTransactionAuth = result.get();
//    assertEquals(transactionAuth.getTransactionId(), actualTransactionAuth.getTransactionId());
//    assertEquals(transactionAuth.getEmail(), actualTransactionAuth.getEmail());
//    assertEquals(transactionAuth.getWorkflow(), actualTransactionAuth.getWorkflow());
//    assertEquals(transactionAuth.getTransactionPassword(),
//        actualTransactionAuth.getTransactionPassword());
//  }
//
//  @Test
//  public void findByTransactionIdAndEmailAndWorkflow_withUnknownTransactionId_returnsNullOptional() {
//    assertFalse(transactionAuthRepository
//        .findByTransactionIdAndEmailAndWorkflow("123", "email1@test.com", "workflow3").isPresent());
//  }
//
//  @Test
//  public void findByTransactionIdAndEmailAndWorkflowAndEnabled_withValidDetails_returnsTransactionDetail() {
//    ExternalTransactionAuth transactionAuth =
//        ExternalTransactionAuth.builder().transactionId("1").email("email1@test.com")
//            .workflow("workflow1").transactionPassword("123").enabled(Boolean.TRUE).build();
//    Optional<ExternalTransactionAuth> result = transactionAuthRepository
//        .findByTransactionIdAndEmailAndWorkflowAndEnabled("1", "email1@test.com", "workflow1",
//            Boolean.TRUE);
//    ExternalTransactionAuth actualTransactionAuth = result.get();
//    assertEquals(transactionAuth.getTransactionId(), actualTransactionAuth.getTransactionId());
//    assertEquals(transactionAuth.getEmail(), actualTransactionAuth.getEmail());
//    assertEquals(transactionAuth.getWorkflow(), actualTransactionAuth.getWorkflow());
//    assertEquals(transactionAuth.getTransactionPassword(),
//        actualTransactionAuth.getTransactionPassword());
//  }
//
//  @Test
//  public void findByTransactionIdAndEmailAndWorkflowAndEnabled_withUnknownTransactionId_returnsNullOptional() {
//    assertFalse(transactionAuthRepository
//        .findByTransactionIdAndEmailAndWorkflowAndEnabled("123", "email1@test.com", "workflow3",
//            Boolean.TRUE).isPresent());
//  }
//
//  private List<ExternalTransactionAuth> getValidTransactions() {
//    List<ExternalTransactionAuth> transactionAuthList = new ArrayList<>();
//    ExternalTransactionAuth transaction1 =
//        ExternalTransactionAuth.builder().transactionId("1").email("email1@test.com")
//            .workflow("workflow1").transactionPassword("123").enabled(Boolean.TRUE).build();
//    ExternalTransactionAuth transaction2 =
//        ExternalTransactionAuth.builder().transactionId("2").email("email2@test.com")
//            .workflow("workflow2").transactionPassword("123").enabled(Boolean.TRUE)
//            .expiresOn(Timestamp.valueOf(LocalDate.now().plusDays(2).atStartOfDay())).build();
//    ExternalTransactionAuth transaction3 =
//        ExternalTransactionAuth.builder().transactionId("3").email("email3@test.com")
//            .workflow("workflow3").transactionPassword("123").enabled(Boolean.TRUE)
//            .lastLoginTime(Timestamp.valueOf(LocalDate.now().minusMonths(5).atStartOfDay()))
//            .build();
//    transactionAuthList.add(transaction1);
//    transactionAuthList.add(transaction2);
//    transactionAuthList.add(transaction3);
//    return transactionAuthList;
//  }
//
//  private List<ExternalTransactionAuth> getTransactionsEligibleForDeletion() {
//    List<ExternalTransactionAuth> transactionAuthList = new ArrayList<>();
//    ExternalTransactionAuth transaction1 =
//        ExternalTransactionAuth.builder().transactionId("11").email("email11@test.com")
//            .workflow("workflow11").transactionPassword("123").enabled(Boolean.FALSE).build();
//    ExternalTransactionAuth transaction2 =
//        ExternalTransactionAuth.builder().transactionId("22").email("email22@test.com")
//            .workflow("workflow22").transactionPassword("123").enabled(Boolean.TRUE)
//            .expiresOn(Timestamp.valueOf(LocalDate.now().atStartOfDay())).build();
//    ExternalTransactionAuth transaction3 =
//        ExternalTransactionAuth.builder().transactionId("33").email("email33@test.com")
//            .workflow("workflow33").transactionPassword("123").enabled(Boolean.TRUE)
//            .lastLoginTime(Timestamp.valueOf(LocalDate.now().minusMonths(7).atStartOfDay()))
//            .build();
//    transactionAuthList.add(transaction1);
//    transactionAuthList.add(transaction2);
//    transactionAuthList.add(transaction3);
//    return transactionAuthList;
//  }

}
