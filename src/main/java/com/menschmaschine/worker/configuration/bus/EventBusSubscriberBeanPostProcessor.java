package com.menschmaschine.worker.configuration.bus;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

public class EventBusSubscriberBeanPostProcessor implements BeanPostProcessor {

  private static final Logger log = LoggerFactory.getLogger(EventBusSubscriberBeanPostProcessor.class);

  private final EventBus eventBus;

  public EventBusSubscriberBeanPostProcessor(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    for (Method m : bean.getClass().getMethods()) {
      if (m.isAnnotationPresent(Subscribe.class)) {
        this.eventBus.register(bean, beanName);
        break;
      }
    }
    return bean;
  }
}
