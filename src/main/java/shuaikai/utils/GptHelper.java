package shuaikai.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Getter;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

/**
 * <pre>
 *     API to chat with GPT3.5 or GPT4
 *
 *     Unusual Package Used:
 *          {@link lombok.Lombok} generate Getter automatically
 * </pre>
 *
 * @author shuaikai
 */
public class GptHelper {
    /**
     * Your key to get access to GPT.
     */
    private static final String AUTHORIZATION = "See @link https://www.openai-hk.com/m/ai/key";

    @Getter
    public enum Model {
        GPT4_T("gpt-4-1106-preview"), GPT3_5_T("gpt-3.5-turbo-1106");

        private final String value;

        Model(String value) {
            this.value = value;
        }
    }

    public static JsonObject getResponse(JsonObject requestBody) throws IOException {

        String url = "https://api.openai-hk.com/v1/chat/completions";

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody body = RequestBody.create(mediaType, requestBody.toString());
        Request request = new Request.Builder().url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", AUTHORIZATION)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        return new Gson().fromJson(Objects.requireNonNull(response.body()).string(), JsonObject.class);
    }

    public static JsonObject genRequestBody(String question) {
        return genRequestBody(Model.GPT3_5_T, question);
    }

    public static JsonObject genRequestBody(Model model, String question) {
        String mask = "You are ChatGPT, a large language model trained by OpenAI. Answer as concisely as possible.";
        return genRequestBody(model, question, mask, 1200, 0.8);
    }

    public static JsonObject genRequestBody(Model model, String question, String mask) {
        return genRequestBody(model, question, mask, 1200, 0.8);
    }

    public static JsonObject genRequestBody(Model model, String question, String mask, int maxToken,
                                            Number temperature) {
        return JsonUtils.newObj()
                .add2Obj("max_tokens", maxToken)
                .add2Obj("model", model.getValue())
                .add2Obj("temperature", temperature)
                .add2Obj("top_p", 1)
                .add2Obj("presence_penalty", 1)
                .add2Obj("message", JsonUtils.newArray()
                        .add2Array(JsonUtils.newObj().add2Obj("role", "system").add2Obj("content", mask).buildObj())
                        .add2Array(JsonUtils.newObj().add2Obj("role", "user").add2Obj("content", question).buildObj())
                        .buildArray())
                .buildObj();
    }
}
