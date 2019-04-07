package com.igor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class IgniteSchedulerService {

  private final Ignite ignite;

  @Scheduled(fixedDelay = 1000)
  public void sendHello() {
    log.info("sendHello");
    ignite.compute().broadcast(() -> System.out.println("Hello World!"));
  }

}
