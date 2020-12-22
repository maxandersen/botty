///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:0.11.0
//DEPS io.quarkiverse.githubapp:quarkiverse-github-app:0.0.1
//Q:CONFIG quarkus.github-app.debug.payload-directory=payloads
//Q:CONFIG quarkus.log.category."io.quarkiverse".level=DEBUG

import java.io.IOException;

import org.kohsuke.github.GHEventPayload;

import io.quarkiverse.githubapp.event.Issue;
import org.jboss.logging.Logger;


public class bot {

  private static final Logger LOG = Logger.getLogger(bot.class);

    void onOpen(@Issue.Opened GHEventPayload.Issue issuePayload) throws IOException {
  		issuePayload.getIssue().comment("Hello from MyGitHubApp");
    }

}
