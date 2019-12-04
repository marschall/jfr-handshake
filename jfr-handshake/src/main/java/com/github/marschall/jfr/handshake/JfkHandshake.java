package com.github.marschall.jfr.handshake;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JfkHandshake {

  public static void main(String[] args) throws Exception {
    var request = HttpRequest
        .newBuilder()
        .uri(URI.create("https://marschall.github.io/"))
        .GET()
        .build();

    var response = HttpClient
        .newHttpClient()
        .send(request, HttpResponse.BodyHandlers.discarding());

    System.out.println(response.headers().firstValue("content-length").get());
  }

}
