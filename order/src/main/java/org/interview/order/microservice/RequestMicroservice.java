package org.interview.order.microservice;

public class RequestMicroservice {
    private static String token;

    public RequestMicroservice() {
        if (token == null) {
            token = getToken("clientId", "clientSecret");
        }
    }

    public String getToken(String clientId, String clientSecret) {
        return String.format("%s:%s", clientId, clientSecret);
    }

    public String sendRequest(String method, String url, Object body, String clientId, String clientSecret) {
        return "test";
    }

    public String getRequest(String url, String clientId, String clientSecret) {
        return sendRequest("GET", url, null, clientId, clientSecret);
    }

    public String postRequest(String url, Object body, String clientId, String clientSecret) {
        return sendRequest("POST", url, body, clientId, clientSecret);
    }
}
