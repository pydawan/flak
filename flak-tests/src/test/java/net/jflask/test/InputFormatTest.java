package net.jflask.test;

import java.io.IOException;
import java.net.URISyntaxException;

import flak.annotations.InputFormat;
import flak.annotations.Post;
import flak.annotations.Route;
import flak.jackson.JsonInputParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author pcdv
 */
public class InputFormatTest extends AbstractAppTest {

  @Post
  @InputFormat(name = "JSON", type = Pojo.class)
  @Route("/pojo/:id")
  public String postJsonObject(String id, Pojo obj) {
    return obj.name + id;
  }

  public static class Pojo {
    public String name;
  }

  @Test
  public void testPostPojo() throws IOException, URISyntaxException {
    app.addInputParser("JSON", new JsonInputParser());
    Assert.assertEquals("foo42", client.post("/pojo/42", "{\"name\":\"foo\"}"));
  }
}