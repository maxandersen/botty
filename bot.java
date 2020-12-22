///usr/bin/env jbang "$0" "$@" ; exit $?
// //DEPS <dependency1> <dependency2>
//DEPS io.smallrye.reactive:mutiny:0.11.0
//DEPS io.quarkiverse.githubapp:quarkiverse-github-app:0.0.1
//FILES application.properties
package booty;

import static java.lang.System.*;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.kohsuke.github.GHEventPayload;

import io.quarkiverse.githubapp.event.Issue;
import io.quarkus.runtime.StartupEvent;

import org.jboss.logging.Logger;


@QuarkusMain
public class bot implements QuarkusApplication {

  private static final Logger LOG = Logger.getLogger(bot.class);

  public static void main(String[] args) {
    Quarkus.run(bot.class, args);
  }

    void init(@Observes StartupEvent startupEvent) {
            LOG.info("››› xybot running " + this);
    }
    
    void onOpen(@Issue.Opened GHEventPayload.Issue issuePayload) throws IOException {
  		issuePayload.getIssue().comment("Hello from MyGitHubApp");
    }

  @Override
  public int run(String... args) throws Exception {
    Quarkus.waitForExit();
    return 0;
  }
}
