package flask.test;

import flak.Response;
import flak.annotations.Route;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Misc Redirect  tests.
 */
public class RedirectTest extends AbstractAppTest {

  @Route("/foo")
  public void foo(Response resp) {
    resp.redirect("/bar");
  }

  @Route("/bar")
  public String bar() {
    return "foobar";
  }

  @Test
  public void testRedirect() throws Exception {
    assertEquals("foobar", client.get("/foo"));
  }
}
