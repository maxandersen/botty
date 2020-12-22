///usr/bin/env jbang "$0" "$@" ; exit $?
// //DEPS <dependency1> <dependency2>
//DEPS io.smallrye.reactive:mutiny:0.11.0
//DEPS io.quarkiverse.githubapp:quarkiverse-github-app:0.0.1
//DEPS io.quarkus:quarkus-bootstrap-gradle-resolver:1.10.3.Final
//FILES application.properties

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


public class bot {

  private static final Logger LOG = Logger.getLogger(bot.class);

    void onOpen(@Issue.Opened GHEventPayload.Issue issuePayload) throws IOException {
  		issuePayload.getIssue().comment("Hello from MyGitHubApp");
    }

}
