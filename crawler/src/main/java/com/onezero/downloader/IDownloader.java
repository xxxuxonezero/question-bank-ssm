package com.onezero.downloader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import java.net.URI;

public interface IDownloader {
    HttpClient createHttpClient();

    HttpResponse get(URI uri);

    HttpResponse post(URI uri);

    HttpResponse get(String url);

    HttpResponse post(String url);
}
