package org.interview.order.microservice;

public class CicMicroservice extends RequestMicroservice {
    private final String clientId = "clientId-1";
    private final String clientSecret = "clientSecret-1";

    public String sendRequest(String url, String method, Object body) {
        return super.sendRequest(method, url, body, clientId, clientSecret);
    }

    public String getRequest(String url) {
        return super.getRequest(url, clientId, clientSecret);
    }

    public String checkORSCustomerCIC() {
        String url = "url";
        String json = this.getRequest(url);
        return "checkORSCustomerCIC";
    }
}
