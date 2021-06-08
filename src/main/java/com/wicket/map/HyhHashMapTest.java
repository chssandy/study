package com.wicket.map;

import org.junit.Test;

/**
 * HyhHasMap Test
 *
 * @Author heyuhua
 * @create 2021/2/9 17:54
 */
public class HyhHashMapTest {

    /**
     * 普通测试
     */
    @Test
    public void test() {
        HyhHashMap<String, String> hyhHashMap = new HyhHashMap<>();
        hyhHashMap.put("name", "heyuhua");
        hyhHashMap.put("height", "180cm");
        hyhHashMap.put("name", "hyh");
        hyhHashMap.put("height", "180");
        System.out.println("name:" + hyhHashMap.get("name") + ",height:" + hyhHashMap.get("height"));
    }

    /**
     * Hash冲突测试
     */
    @Test
    public void testHashConfilct() {
        HyhHashMap<String, String> hyhHashMap = new HyhHashMap<>();
        hyhHashMap.put("轷龚", "heyuhua1");
        hyhHashMap.put("轸齻", "heyuhua2");
        System.out.println("轷龚:" + hyhHashMap.get("轷龚") + ",轸齻:" + hyhHashMap.get("轸齻"));
    }
}