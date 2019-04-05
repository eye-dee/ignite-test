package com.igor;

import lombok.RequiredArgsConstructor;
import org.apache.ignite.Ignite;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IgniteSchedulerService {

  private final Ignite ignite;

  @Scheduled(fixedDelay = 1000)
  public void sendHello() {
    ignite.compute().broadcast(() -> System.out.println("Hello World!"));
  }

}
