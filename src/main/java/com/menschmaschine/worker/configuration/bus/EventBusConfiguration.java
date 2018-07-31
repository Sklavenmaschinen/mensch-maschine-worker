package com.menschmaschine.worker.configuration.bus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class EventBusConfiguration {

  @Bean
  public EventBus eventBus() {
    return new EventBus(getExecutor());
  }

  @Bean
  public EventBusSubscriberBeanPostProcessor subscriberAnnotationProcessor(EventBus eventBus) {
    return new EventBusSubscriberBeanPostProcessor(eventBus);
  }


  private ThreadPoolTaskExecutor getExecutor() {
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setCorePoolSize(5);
    threadPoolTaskExecutor.setMaxPoolSize(10);
    threadPoolTaskExecutor.setQueueCapacity(20);
    threadPoolTaskExecutor.initialize();
    return threadPoolTaskExecutor;
  }

}
