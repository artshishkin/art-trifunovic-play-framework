package model;

import jakarta.inject.Inject;
import org.apache.pekko.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

/**
 * Custom execution context wired to "database.dispatcher" thread pool
 */
public class DbExecutionContext extends CustomExecutionContext {

    @Inject
    public DbExecutionContext(ActorSystem actorSystem) {
        super(actorSystem, "database.dispatcher");
    }
}