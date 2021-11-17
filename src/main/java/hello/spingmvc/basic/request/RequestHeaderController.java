package hello.spingmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
@Slf4j
@RestController
public class RequestHeaderController {
    @RequestMapping("/headers")
    /**
     * MultiValueMap
     * MultiValueMap<String, String> map = new LinkedMultiValueMap();
     * keyA=value1&keyA=value2 key-value를 여러개 받아올 수 있다.
     * map.add("keyA", "value1");
     * map.add("keyA", "value2");
     * 즉,
     */
    // locale : 지역
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String>
                                  headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie", required = false)
                                  String cookie
    ) {
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }
}