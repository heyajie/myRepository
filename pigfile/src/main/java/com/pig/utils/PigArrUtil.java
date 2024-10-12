package com.pig.utils;


import java.util.*;

public class PigArrUtil {

    /**
     *
     * 
     * @return { a=[b, c, d, f], g=[guo22]}
     *
     * @param map  { a=[b, c], b=[d,f], g=[guo22]}
     */
    public static void getMregeMap(Map<String, Set<String>> map){
        List<String> deleKey = new ArrayList<>();
        //
        String resKey = "";
        Set<String> tmpArr = new TreeSet<>();
        //
        Set<String> keySet = map.keySet();
        for (String key: keySet) {
            Set<String> arr = map.get(key);
            //
            resKey = "";
            deleKey = new ArrayList<>();
            tmpArr = new TreeSet<>();
            resKey = key;
            tmpArr.addAll(arr);
            //
            for (String k2: arr) {
                if(keySet.contains(k2) && !key.equals(k2)){
                    Set<String> k2Set = map.get(k2);
                    deleKey.add(k2);
                    //
                    for(String s: k2Set){
                        if(!key.equals(s)){
                            tmpArr.add(s);
                        }
                    }
                }
            }
            if(deleKey.size() >=1){
                break;
            }
        }

        if(deleKey.size() >= 1){
            map.put(resKey, tmpArr);
            for(String delKey: deleKey){
                map.remove(delKey);
            }
            //System.out.println(map);
            getMregeMap(map);
        }else {
            return;
        }
    }

    public Map<String, Object> initMap(Map<String, Object> m){
        Map<String, Object> resMap = new HashMap<>();
        for(String key: m.keySet()){
            resMap.put(key, m.get(key));
            resMap.put(key+"_b", 0);
            resMap.put(key+"_b_hb", 0);
        }
        return resMap;
    }
    
    public static void main(String[] args) {

    }

}
