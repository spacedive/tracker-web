package com.samlee.web.track.rest;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/domains")
public class DomainTrackerWs
{

  private static final Map<String, Long> domainReferrals = new HashMap<String, Long>();

  @Path("{domain}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response saveDomain(@PathParam("domain") String domain) {
    
    if (domainReferrals.containsKey(domain)) {
      domainReferrals.put(domain, domainReferrals.get(domain) + 1);
    } else {
      domainReferrals.put(domain, 1L);
    }
    return Response.ok().build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, Long> getDomainsByCountDesc(@QueryParam("limit") int limit) {
    return getDomainsByCountDesc(domainReferrals, limit > 0 ? limit : 3);
  }

  private <K, V extends Comparable<? super V>> Map<K, V> getDomainsByCountDesc(Map<K, V> map, int limit) {
    return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).limit(limit)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }

}
