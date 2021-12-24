package com.sandracoe.booklistapp.Services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.sandracoe.booklistapp.Objects.BookCover;

import org.springframework.stereotype.Service;

@Service
public class CoverService {

    public static BookCover getCover(String isbn) {
        BookCover cover = new BookCover();
        String url = "https://covers.openlibrary.org/b/isbn/"+isbn+"-S.jpg";
        getCoverInformation(cover, url);
        return cover;
    }

    private static void getCoverInformation(BookCover cover, String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenAccept(response ->{
            if (response.statusCode() == 302 || response.statusCode() == 200) {
                cover.setUrl(url);
            } else {
                cover.setUrl("URL couldn't be fetch");
            }
            cover.setStatusCode(response.statusCode());
        })
        .join();
    }
}