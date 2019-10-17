package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gaohan on 4/1/18.
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            int count = Integer.parseInt(cpdomains[i].split(" ")[0]);
            int start = 0;
            String domain = cpdomains[i].split(" ")[1];
            result.put(domain, result.getOrDefault(domain, 0) + count);
            while (true) {
                start = domain.indexOf(".");
                if (start == -1)
                    break;
                String subDomain = domain.substring(start + 1);
                result.put(domain, result.getOrDefault(domain, 0) + count);
                domain = subDomain;
            }
        }
        return result.keySet().stream().map(key -> result.get(key) + " " + key).collect(Collectors.toList());
    }
}
