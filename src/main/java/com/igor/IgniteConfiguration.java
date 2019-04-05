package com.igor;

import static org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi.DFLT_PORT;

import java.net.InetSocketAddress;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteIllegalStateException;
import org.apache.ignite.Ignition;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class IgniteConfiguration {

  @Bean
  public Ignite ignite() {
    boolean started = false;
    try {
      Ignition.ignite("testGrid-client");
      started = true;
    } catch (IgniteIllegalStateException e) {
      log.debug("Using the Ignite instance that has been already started.");
    }
    if (started) {
      return Ignition.ignite("testGrid-client");
    } else {
      var ignite = Ignition.start("ignite/example-hello.xml");
      ((TcpDiscoverySpi) ignite.configuration().getDiscoverySpi())
          .getIpFinder()
          .registerAddresses(Collections.singletonList(new InetSocketAddress("localhost", DFLT_PORT)));
      return ignite;
    }
  }

}
