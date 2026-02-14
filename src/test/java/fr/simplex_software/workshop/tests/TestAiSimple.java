package fr.simplex_software.workshop.tests;

import dev.langchain4j.data.message.*;
import dev.langchain4j.model.chat.*;
import dev.langchain4j.model.chat.request.*;
import dev.langchain4j.model.input.*;
import fr.simplex_software.workshop.*;
import org.junit.jupiter.api.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.io.*;
import java.util.*;

@SpringBootTest
public class TestAiSimple
{
  private static final Logger LOG = LoggerFactory.getLogger(TestAiSimple.class);
  @Autowired
  private AgentService agentService;
  @Value("${test-ai-simple.question}")
  private String userText;

  @Test
  public void evaluateRelevancy()
  {
    Response response = agentService.chat(new Inquiry(userText));
    LOG.debug(">>> {} - Response: {}", userText, response.response());
  }
}
