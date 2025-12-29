package com.chris.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;


@Component
public class HelloTools {
    private static final Logger log = LoggerFactory.getLogger(HelloTools.class);

    //tools
    @McpTool(name = "hello-greetings", description = "various greetings in different languages")
    public String greetings() {
        return """
                ** Hello
                ** Hola
                ** Bonjour
                ** Konnichiwa
                """;
    }

    //resources
    //prompt
}
