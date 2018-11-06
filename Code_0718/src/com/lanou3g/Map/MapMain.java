package com.lanou3g.Map;

import java.util.*;

public class MapMain {

    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
    public static final String KEY_HEIGHT = "height";


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //set里面的元素是不可以重复的,也是无序的
        set.add("周一");
        set.add("周二");
        set.add("周三");
        set.add("周四");
        set.add("周五");
        set.add("周一");
        System.out.println(set);

        //  Map 以键值对(key-value)形式存储数据
        //主要向Map中存储的数据是value
        //但是在存储的时候需要给value指定一个标签,这个标签是key
        //声明Map对象时,需要指定两个泛型
        //第一个泛型是key的类型,第二个泛型是value的类型
        Map<String, String> map = new HashMap<>();
        // 向Map中存储数据
        map.put("及时雨", "宋江");
        map.put("玉麒麟", "卢俊义");
        //从Map中获取数据
        String s = map.get("及时雨");
        System.out.println(s);

        Map<String, Object> map1 = new HashMap<>();
        map1.put(KEY_NAME, "张三");
        map1.put(KEY_AGE, 18);
        map1.put(KEY_HEIGHT, 188.0f);

        String name = (String) map1.get(KEY_NAME);
        int age = (int) map1.get(KEY_AGE);
        System.out.println(name + age);


        //Map中的k 不能重复
        //如果存放数据时,根据的是同一个k
        //那么会覆盖掉之前的数据
        Map<String, Object> map2 = new HashMap<>();
        map2.put(KEY_NAME, "李四");
        map2.put(KEY_AGE, 15);
        map2.put(KEY_HEIGHT, 178.0f);
        System.out.println(map2);


        Map<Integer, String> fruit = new HashMap<>();
        fruit.put(1, "小柿子");
        fruit.put(2, "香蕉");
        fruit.put(3, "葡萄");
        fruit.put(4, "西瓜");

        //Map中的元素 也是无序的
        System.out.println(fruit);
        //根据key移除数据,返回值是移除的数据的value
//        String s1 = fruit.remove("红色");
////        System.out.println(s1);
////        System.out.println(fruit);
        //Map的遍历
        //1.取到Map的所有key的集合
        //然后遍历该集合,根据集合中的元素从Map中获取数据
        Set<Integer> keys = fruit.keySet();
        for (Integer key : keys) {
            String fru = fruit.get(key);
            System.out.println(key + "-->" + fru);
        }
        //2.直接取出所有值得的集合
        // 缺点:不知道key都是什么
        Collection<String> values = fruit.values();
        for (String value : values) {
            System.out.println(value);
        }

        //3.最常用的一种遍历Map的方式
        Set<Map.Entry<Integer, String>> entries = fruit.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"--->"+value);
        }

        //在一个集合中,放Map对象
        List<Map<String,Object>> persons = new ArrayList<>();
        persons.add(map1);
        persons.add(map2);
        System.out.println(persons);

        //专辑集合
        List<Map<String, Object>> albumList = new ArrayList<>();
       //创建一个专辑
        Map<String,Object> jayAlbum = new HashMap<>();
        //把专辑放到集合中
        albumList.add(jayAlbum);
        //为专辑设置名字
        jayAlbum.put("name","Jay");
        //为专辑放入歌曲
        List<Map<String,String>> jayMusics = new ArrayList<>();
        jayAlbum.put("musics",jayMusics);

        //第一首歌
        Map<String,String> musics1 = new HashMap<>();
        musics1.put("musicName","反向的钟");
        musics1.put("duration","200");
        //第二首歌
        Map<String,String> musics2 = new HashMap<>();
        musics2.put("musicName","斗牛");
        musics2.put("duration","100");
        //为歌曲的集合放入歌曲
        jayMusics.add(musics1);
        jayMusics.add(musics2);

        //第二张专辑
        Map<String,Object> bdkjAlbum = new HashMap<>();
        albumList.add(bdkjAlbum);
        bdkjAlbum.put("name","八度空间");
        List<Map<String,String>> bdkjMusics = new ArrayList<>();
        bdkjAlbum.put("musics",bdkjMusics);
        Map<String,String> musics3 = new HashMap<>();
        musics3.put("musicName","暗号");
        musics3.put("duration","150");
        Map<String,String> musics4 = new HashMap<>();
        musics4.put("musicName","哀嚎");
        musics4.put("duration","200");
        bdkjMusics.add(musics3);
        bdkjMusics.add(musics4);
        System.out.println(albumList);

        //取出0张专辑1首歌的时长
        //第0张专辑
        Map<String, Object> album0 = albumList.get(0);
        //取这张专辑的所有歌曲
        List<Map<String,String>> musics = (List<Map<String, String>>) album0.get("musics");
        //取第一首歌曲
        Map<String, String> map3 = musics.get(0);
        //取歌曲的时长
        String duration = map3.get("duration");
        System.out.println(duration);


        //遍历
        for (Map<String, Object> stringObjectMap : albumList) {
            Object name1 = stringObjectMap.get("name");
            System.out.println(name1);
            List<Map<String,String>> musics5 = (List<Map<String, String>>) stringObjectMap.get("musics");
            for (Map<String, String> stringStringMap : musics5) {
                String name2 = stringStringMap.get("musicName");
                String duration1 = stringStringMap.get("duration");
                System.out.println("\t歌曲名称"+name2+"\t歌曲时长"+duration1);
            }
        }


    }
}
