package com.menschmaschine.worker.configuration.bus;

import com.google.common.eventbus.AsyncEventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class EventBus {
  private static final Logger log = LoggerFactory.getLogger(EventBus.class);

  private final AsyncEventBus asyncEventBus;

  EventBus(ThreadPoolTaskExecutor executor) {
    this.asyncEventBus = new AsyncEventBus(executor);
  }

  void register(Object bean, String beanName) {
    this.asyncEventBus.register(bean);
    log.debug("Bean {} registered.", beanName);
  }

  public void post(Object o) {
    this.asyncEventBus.post(o);
  }
}
