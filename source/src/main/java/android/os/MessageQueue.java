package android.os;

public final class MessageQueue {
    MessageQueue() {
        super();
    }

    public void addIdleHandler(IdleHandler p0) {
    }

    public void removeIdleHandler(IdleHandler p0) {
    }

    @Override
    protected void finalize() throws Throwable {
    }

    public strictfp interface IdleHandler {
        boolean queueIdle();
    }
}
