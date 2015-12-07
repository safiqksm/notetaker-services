package com.aver.notetaker.services.notes;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aver.notetaker.domain.Quote;

@FeignClient("quote-service")
public interface QuoteClient {
    @RequestMapping(method = RequestMethod.GET, value = "/quotes/")
    Quote getQuote();
}