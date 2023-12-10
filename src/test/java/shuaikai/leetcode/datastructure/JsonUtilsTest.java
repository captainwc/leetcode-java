package shuaikai.leetcode.datastructure;

import org.junit.Assert;
import org.junit.Test;
import com.google.gson.JsonObject;
import shuaikai.utils.JsonUtils;

public class JsonUtilsTest {
    @Test
    public void jsonUtilsTest() {
        JsonObject shuaikai = JsonUtils.newObj()
                .add2Obj("name", "shuaikai")
                .add2Obj("sex", "m")
                .add2Obj("handsome", true)
                .add2Obj("major", JsonUtils.newArray()
                        .add2Array("math")
                        .add2Array("Chinese")
                        .add2Array("English")
                        .buildArray())
                .add2Obj("home", "CHINA")
                .buildObj();
        Assert.assertEquals(
                "{\"name\":\"shuaikai\",\"sex\":\"m\",\"handsome\":true,\"major\":[\"math\",\"Chinese\",\"English\"],\"home\":\"CHINA\"}",
                shuaikai.toString());
    }
}
