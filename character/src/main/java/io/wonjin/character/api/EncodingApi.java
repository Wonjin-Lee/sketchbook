package io.wonjin.character.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
public class EncodingApi {

    @PostMapping("/sketchbook/character/encoding-test")
    public String encodingTestApi(@RequestBody Map<String, String> parameter, HttpServletRequest httpServletRequest) {
        log.info("Default Encoding : {}", httpServletRequest.getCharacterEncoding());

        httpServletRequest.setCharacterEncoding();

        String text = parameter.get("text");
        log.info("Text : {}", text);

        return text;
    }
}
