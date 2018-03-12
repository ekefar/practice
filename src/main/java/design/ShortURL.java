package design;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : Alexander Serebriyan
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 */
public class ShortURL {

    private static final Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String str = randomString(6);

        while (map.containsKey(str)) {
            str = randomString(6);
        }

        map.put(str, longUrl);
        return str;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    private static String randomString(int len){
        return UUID.randomUUID().toString().substring(0,len);
    }
}
