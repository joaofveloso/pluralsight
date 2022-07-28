package httpclient.ws;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;

public class WebsocketExample {

    public static void main(String... args) throws Exception {

        int msgCount = 5;
        CountDownLatch receiveLatch = new CountDownLatch(msgCount);

    }


    static class EchoListener implements WebSocket.Listener {

        CountDownLatch receiveLatch;

        public EchoListener(CountDownLatch receiveLatch) {
            this.receiveLatch = receiveLatch;
        }

        @Override
        public void onOpen(WebSocket webSocket) {
            System.out.println("onOpen called");
        }

        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
            System.out.println("onText " + data);
            receiveLatch.countDown();
            return null;
        }

    }
}
