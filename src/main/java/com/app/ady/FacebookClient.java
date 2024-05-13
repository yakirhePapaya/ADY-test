package com.app.ady;


import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FacebookClient {
    private final String accessToken = "EAAE9kOQTps8BO0Htzv1s5iCYxMEDjZC3Lxv2Smt0Go0SJYVWpfIpqzjZCn6H6VN0DAkDecZAGfeLZCJKN0pFOes5NZCnH7JwVsZAgyx92nwZCr7E4zjYR1ITMQLuXfqyTGMylJKaszArgR4npgDolxiyHDsUZAeW6WcwXZBQ0Ktd4f7kWfqd6uliJbkb6A4uth4UY6L13SiSMPBv7icZB7fgZDZD";
    private final APIContext context;

    public FacebookClient() {
        this.context = new APIContext(this.accessToken).enableDebug(true);
    }

    public List<Ad> fetchAds() {
        try {
            AdAccount adAccount = new AdAccount("act_349167487788751", context);
            APINodeList<Ad> ads = adAccount.getAds().requestAllFields().execute();
            return mapToAdList(ads);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private List<Ad> mapToAdList(APINodeList<Ad> ads) {
        List<Ad> adList = new ArrayList<>();
        for (Ad ad : ads) {
            // Map ad data to your Ad model
            Ad mappedAd = new Ad(ad.getFieldId(), this.context);//, /* Other ad properties */
            adList.add(mappedAd);
        }
        return adList;
    }
}