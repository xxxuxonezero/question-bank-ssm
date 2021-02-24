package com.onezero.parse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

public interface ICrawler {
    HttpClient createHttpClient();

    HttpResponse get();

    HttpResponse post();
}
