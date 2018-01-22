import okhttp3.*;

import java.io.IOException;

public class MyTest {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static OkHttpClient client = new OkHttpClient();

    public static final String json = "{InvestorId: 1712}";

    public static final String URL = "http://114.55.27.208:8555/api/PopActivity/SetDevoutDayFeedback";


    public static void main(String[] args) throws IOException {


//        String url1 = "http://114.55.27.208:8555/api/PopActivity/CheckDevoutDayActivity";
//        String value1 = post1(url1, "1");
//        System.out.println(value1);



//        String url2 = "http://114.55.27.208:8555/api/PopActivity/SetDevoutDayFeedback";
//        String value2 = post2(url2, "1");
//        System.out.println(value2);


    }

    //键值对
    public static String post1(String url, String json) throws IOException {

        RequestBody formBody = new FormBody.Builder()
                .add("InvestorId", "1987")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    //键值对
    public static String post2(String url, String json) throws IOException {

        RequestBody formBody = new FormBody.Builder()
                .add("InvestorId", "1987")
                .add("Units", "[\"15DB\"]")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}
