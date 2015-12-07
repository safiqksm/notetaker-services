package com.aver.notetaker.services.notes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aver.notetaker.domain.Quote;
import com.aver.notetaker.domain.Value;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class QuoteRetriever {
    private final static Logger LOGGER = LoggerFactory
            .getLogger(QuoteRetriever.class);

    @Autowired
    private QuoteClient quoteClient;

    @HystrixCommand(fallbackMethod = "fallbackQuoteService")
    public Quote getRandomQuote() {
        Quote quote = quoteClient.getQuote();
        // RestTemplate restTemplate = new RestTemplate();
        // Quote quote =
        // restTemplate.getForObject("http://quote-service/quotes/",
        // Quote.class);
        LOGGER.info(quote.toString());

        return quoteClient.getQuote();
    }

    private Quote fallbackQuoteService() {
        Quote q = new Quote();
        q.setType("success");
        Value v = new Value();
        v.setId(1l);
        v.setJoke("Chuck Norris cannot be found but he is behind you so don't look back!");
        q.setValue(v);
        return q;
    }
}
