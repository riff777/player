package com.example.wallet;

import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Balance {
    private static final Logger logger = LoggerFactory.getLogger(Balance.class);

    public static void sendBalanceUpdate() {
        Transaction transaction = new Transaction();
        transaction.setTransaction_id(34);
        transaction.setBalance_change(3D);
        transaction.setUsername("Juri");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(transaction);
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8094/api/wallet");
            HttpEntity stringEntity = new StringEntity(jsonStr, ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println(result);
        } catch (Exception e) {
            logger.error("Exception:", e);
        }
    }
}
