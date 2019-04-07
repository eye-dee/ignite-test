package com.igor;

import com.igor.model.EmployeeDTO;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.DiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableIgniteRepositories
public class IgniteClientConfiguration {

//  @Bean
//  public Ignite ignite() {
//    boolean started = false;
//    try {
//      Ignition.ignite("testGrid-client");
//      started = true;
//    } catch (IgniteIllegalStateException e) {
//      log.debug("Using the Ignite instance that has been already started.");
//    }
//    if (started) {
//      return Ignition.ignite("testGrid-client");
//    } else {
//      var ignite = Ignition.start("ignite/example-hello.xml");
//      ((TcpDiscoverySpi) ignite.configuration().getDiscoverySpi())
//          .getIpFinder()
//          .registerAddresses(Collections.singletonList(new InetSocketAddress("localhost", DFLT_PORT)));
//      return ignite;
//    }
//  }

  @Bean
  public Ignite igniteInstance(DiscoverySpi discoverySpi) {
    IgniteConfiguration config = new IgniteConfiguration();

    CacheConfiguration<Integer, EmployeeDTO> cache = new CacheConfiguration<>("employee-cache");
    cache.setIndexedTypes(Integer.class, EmployeeDTO.class);

    // config.setClientMode(true);
    config.setCacheConfiguration(cache);

    config.setDiscoverySpi(discoverySpi);
    config.setDataStorageConfiguration(new DataStorageConfiguration()
        .setCheckpointReadLockTimeout(0));
    return Ignition.start(config);
  }

  @Bean
  public DiscoverySpi discoverySpi() {
    TcpDiscoverySpi discoSpi = new TcpDiscoverySpi();
    TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
    ArrayList<String> addrs = new ArrayList<>();
    addrs.add("127.0.0.1:47500..47509");
    ipFinder.setAddresses(addrs);
    discoSpi.setIpFinder(ipFinder);
    return discoSpi;
  }

}
