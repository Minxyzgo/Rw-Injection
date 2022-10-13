package android.net.http;

import android.content.ContentResolver;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

public final class AndroidHttpClient implements HttpClient {
    public static long DEFAULT_SYNC_MIN_GZIP_BYTES;

    AndroidHttpClient() {
        super();
    }

    public static AndroidHttpClient newInstance(String p0, Context p1) {
        return null;
    }

    public static AndroidHttpClient newInstance(String p0) {
        return null;
    }

    @Override
    protected void finalize() throws Throwable {
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest p0) {
    }

    public static InputStream getUngzippedContent(HttpEntity p0) throws IOException {
        return null;
    }

    public void close() {
    }

    @Override
    public HttpParams getParams() {
        return null;
    }

    @Override
    public ClientConnectionManager getConnectionManager() {
        return null;
    }

    @Override
    public HttpResponse execute(HttpUriRequest p0) throws IOException {
        return null;
    }

    @Override
    public HttpResponse execute(HttpUriRequest p0, HttpContext p1) throws IOException {
        return null;
    }

    @Override
    public HttpResponse execute(HttpHost p0, HttpRequest p1) throws IOException {
        return null;
    }

    @Override
    public HttpResponse execute(HttpHost p0, HttpRequest p1, HttpContext p2) throws IOException {
        return null;
    }

    @Override
    public Object execute(HttpUriRequest p0, ResponseHandler p1) throws IOException,
            ClientProtocolException {
        return null;
    }

    @Override
    public Object execute(HttpUriRequest p0, ResponseHandler p1, HttpContext p2) throws IOException,
            ClientProtocolException {
        return null;
    }

    @Override
    public Object execute(HttpHost p0, HttpRequest p1, ResponseHandler p2) throws IOException,
            ClientProtocolException {
        return null;
    }

    @Override
    public Object execute(HttpHost p0, HttpRequest p1, ResponseHandler p2, HttpContext p3) throws
            IOException, ClientProtocolException {
        return null;
    }

    public static AbstractHttpEntity getCompressedEntity(byte[] p0, ContentResolver p1) throws
            IOException {
        return null;
    }

    public static long getMinGzipSize(ContentResolver p0) {
        return 0;
    }

    public void enableCurlLogging(String p0, int p1) {
    }

    public void disableCurlLogging() {
    }

    public static long parseDate(String p0) {
        return 0;
    }

    /**
     * Rename from: android.net.http.AndroidHttpClient#1
     */
    static final class AndroidHttpClient44 implements HttpRequestInterceptor {
        AndroidHttpClient44() {
            super();
        }

        @Override
        public void process(HttpRequest p0, HttpContext p1) {
        }
    }

    /**
     * Rename from: android.net.http.AndroidHttpClient#2
     */
    static class AndroidHttpClient45 extends DefaultHttpClient {
        final AndroidHttpClient a = null;

        AndroidHttpClient45(AndroidHttpClient p0, ClientConnectionManager p1, HttpParams p2) {
            super(null,null);
        }

        @Override
        protected BasicHttpProcessor createHttpProcessor() {
            return null;
        }

        @Override
        protected HttpContext createHttpContext() {
            return null;
        }
    }
}
