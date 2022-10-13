package android.os;

public strictfp interface IMessenger extends IInterface {
    void a(Message p0);

    abstract class Stub extends Binder implements IMessenger {
        public Stub() {
            super();
        }

        @Override
        public IBinder asBinder() {
            return null;
        }

        @Override
        public boolean onTransact(int p0, Parcel p1, Parcel p2, int p3) {
            return false;
        }
    }
}
