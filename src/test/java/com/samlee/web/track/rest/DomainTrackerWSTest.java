package com.samlee.web.track.rest;

import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class DomainTrackerWSTest {
  
  @Test
  public void getDomainsByCountDesc_Test() {
    
    DomainTrackerWs domainTrackerWs = new DomainTrackerWs();
    
    // Insert domains.
    domainTrackerWs.saveDomain("test.domain.4");
    domainTrackerWs.saveDomain("test.domain.4");
    domainTrackerWs.saveDomain("test.domain.4");
    domainTrackerWs.saveDomain("test.domain.4");

    domainTrackerWs.saveDomain("test.domain.3");
    domainTrackerWs.saveDomain("test.domain.3");
    domainTrackerWs.saveDomain("test.domain.3");
    
    domainTrackerWs.saveDomain("test.domain.2");
    domainTrackerWs.saveDomain("test.domain.2");

    domainTrackerWs.saveDomain("test.domain.1");

    Map<String, Long> domainsByCountDesc = domainTrackerWs.getDomainsByCountDesc(3);
    
    Assert.assertEquals(3, domainsByCountDesc.size());
    
    int count = 4;
    for (long value : domainsByCountDesc.values()) {
      Assert.assertTrue(value == count--);
    }
  }

}
