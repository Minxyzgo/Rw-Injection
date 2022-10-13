package android.content.res;

import java.io.IOException;
import java.io.InputStream;

public final class AssetManager {
    public static final int ACCESS_UNKNOWN = 0;

    public static final int ACCESS_RANDOM = 0;

    public static final int ACCESS_STREAMING = 0;

    public static final int ACCESS_BUFFER = 0;

    AssetManager() {
        super();
    }

    public void close() {
    }

    public final InputStream open(String p0) throws IOException {
        return null;
    }

    public final InputStream open(String p0, int p1) throws IOException {
        return null;
    }

    public final AssetFileDescriptor openFd(String p0) throws IOException {
        return null;
    }

    public final native String[] list(String p0) throws IOException;

    public final AssetFileDescriptor openNonAssetFd(String p0) throws IOException {
        return null;
    }

    public final AssetFileDescriptor openNonAssetFd(int p0, String p1) throws IOException {
        return null;
    }

    public final XmlResourceParser openXmlResourceParser(String p0) throws IOException {
        return null;
    }

    public final XmlResourceParser openXmlResourceParser(int p0, String p1) throws IOException {
        return null;
    }

    @Override
    protected void finalize() throws Throwable {
    }

    public final native String[] getLocales();

    public final class AssetInputStream extends InputStream {
        AssetInputStream(AssetManager p0) {
            super();
        }

        public final int getAssetInt() {
            return 0;
        }

        @Override
        public final int read() throws IOException {
            return 0;
        }

        @Override
        public final boolean markSupported() {
            return false;
        }

        @Override
        public final int available() throws IOException {
            return 0;
        }

        @Override
        public final void close() throws IOException {
        }

        @Override
        public final void mark(int p0) {
        }

        @Override
        public final void reset() throws IOException {
        }

        @Override
        public final int read(byte[] p0) throws IOException {
            return 0;
        }

        @Override
        public final int read(byte[] p0, int p1, int p2) throws IOException {
            return 0;
        }

        @Override
        public final long skip(long p0) throws IOException {
            return 0;
        }

        @Override
        protected void finalize() throws Throwable {
        }
    }
}
