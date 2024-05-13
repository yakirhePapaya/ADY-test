package com.app.ady;

import com.facebook.ads.sdk.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {

    @Autowired
    private FacebookClient facebookClient; // Initialize Facebook Marketing API client

    @GetMapping("/ads")
    public ResponseEntity<List<Ad>> getAds() {
        // Fetch ad data from Facebook Audience Network
        List<Ad> ads = facebookClient.fetchAds();
        return ResponseEntity.ok(ads);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }
}
