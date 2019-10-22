package leetcode.algo.e;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class EncodeandDecodeTinyURL3 {
    class Codec {
        Map<String, String> longToShort = new HashMap<>();
        Map<String, String> shortToLong = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (longToShort.containsKey(longUrl)) {
                return longToShort.get(longUrl);
            }

            while (true) {
                String shortUrl = "http://tinyurl.com/" + generateShortUrl();
                if (!shortToLong.containsKey(shortUrl)) {
                    shortToLong.put(shortUrl, longUrl);
                    longToShort.put(longUrl, shortUrl);
                    return shortUrl;
                }
            }
        }

        private String generateShortUrl() {
            String charArr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String res = "";
            for (int i = 0; i < 6; i++) {
                Random rand = new Random();
                int index = rand.nextInt(62);
                res += charArr.charAt(index);
            }
            return res;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            if (!shortToLong.containsKey(shortUrl))
                return null;
            return shortToLong.get(shortUrl);
        }
    }
}
