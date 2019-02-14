package com.peoplehum.tag;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.SpringLockableTaskSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

/**
 * Created by punit on 11/10/17.
 */
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.peoplehum.tag", "com.nethum.errorhandling"})
public class Application  {

  private Logger logger = LoggerFactory.getLogger(this.getClass());
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  // max. number of threads running when the queue is full, default queue capacity is INTEGER_MAX
  @Value("${thread.pool.max:20}")
  private Integer maxThreadPool;

  // number of threads running at a time
  @Value("${thread.pool.max:10}")
  private Integer corePoolSize;

  @Bean
  public LockProvider lockProvider(DataSource dataSource) {
    return new JdbcTemplateLockProvider(dataSource);
  }

  @Bean
  public TaskScheduler taskScheduler(LockProvider lockProvider) {
    int poolSize = 10;
    return SpringLockableTaskSchedulerFactory.newLockableTaskScheduler(poolSize, lockProvider);
  }

  @Bean(name = "defaultTaskExecutor")
  public ThreadPoolTaskExecutor defaultTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxThreadPool);
    return executor;
  }

}
