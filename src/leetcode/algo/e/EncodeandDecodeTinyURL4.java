package leetcode.algo.e;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class EncodeandDecodeTinyURL4 {

    public class Codec {
        Map<Integer, String> map = new HashMap<>();
        Random r = new Random();
        int key = r.nextInt(Integer.MAX_VALUE);

        public String encode(String longUrl) {
            while (map.containsKey(key)) {
                key = r.nextInt(Integer.MAX_VALUE);
            }
            map.put(key, longUrl);
            return "http://tinyurl.com/" + key;
        }

        public String decode(String shortUrl) {
            return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
        }
    }

}
