package alie_api;

import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;

public class alieapi {

    private static String url = "https://api-sg.aliexpress.com";
    private static String appkey = "";
    private static String appSecret = "";
    private static String tracking_id = "";
    private static IopClient client;  // IopRequest에서 IopClient로 타입 변경

    public static void main(String[] args) throws ApiException, InterruptedException { // InterruptedException 처리 추가
        // TODO Auto-generated method stub
        System.out.println("api test start");

        init();
        IopRequest request = new IopRequest();
        
        
        request.setApiName("aliexpress.affiliate.productdetail.get");
        request.addApiParameter("app_signature", "aaaaa");
        request.addApiParameter("fields", "commission_rate,sale_price");
        request.addApiParameter("product_ids", "1005005454554991");
        request.addApiParameter("target_currency", "USD");
        request.addApiParameter("target_language", "EN");
        request.addApiParameter("tracking_id", tracking_id);
        request.addApiParameter("country", "US");
        
        IopResponse response = client.execute(request, Protocol.TOP);
        System.out.println(response.getGopResponseBody());
        Thread.sleep(10);
    
    }

    public static void init() {
        client = new IopClientImpl(url, appkey, appSecret);  // IopClientImpl을 사용하여 인스턴스 생성
    }
}
