package fr.simplex_software.workshop;

import dev.langchain4j.service.*;
import dev.langchain4j.service.spring.*;

@AiService
public interface AgentService
{
  @SystemMessage("""
    You are a helpful assistant, answering general questions. 
    Answer in complete sentences.
    Your response MUST be a valid JSON object with a single field named 'response'.
    Do not include any other text before or after the JSON.
    """)
  @UserMessage("Provide a factual answer to the following inquiry: {{it}}.")
  Response chat2(@V("it") Inquiry inquiry);
  @UserMessage("Provide a short answer to the following question: {{it}}.")
  String chat(@V("it") String question);
}