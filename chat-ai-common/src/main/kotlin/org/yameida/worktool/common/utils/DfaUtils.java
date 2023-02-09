package org.yameida.worktool.common.utils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 敏感词处理 -- DFA算法
 *
 * @author lieber
 */
public class DfaUtils {

    private final static String END_MARK_KEY = "end";

    private final static int MIN_MATCH_FLAG = 2;


    private final static Map<String, HashMap> DFA_MAPS = new ConcurrentHashMap<>();


    public static void add(String key, HashMap dfaMap) {
        DFA_MAPS.put(key, dfaMap);
    }

    public static void addAll(String key, HashMap<String, HashMap> dfaMap) {
        for (String groupName : dfaMap.keySet()) {
            DFA_MAPS.put(key + groupName, dfaMap.get(groupName));
        }

    }

    public static void remove(String key) {
        DFA_MAPS.remove(key);
    }

    public static HashMap get(String key) {
        return DFA_MAPS.get(key);
    }


    public static HashMap init(Collection<String> keywords) {
        if (keywords == null || keywords.isEmpty()) {
           new HashMap();
        }
        HashMap wordsMap = new HashMap(keywords.size());
        for (String keyword : keywords) {
            if (keyword == null) {
                continue;
            }
            Map nowMap = wordsMap;
            char[] chars = keyword.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char keyChar = chars[i];
                Object wordMap = nowMap.get(keyChar);

                if (wordMap != null) {
                    //如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                } else {
                    //不存在则，则构建一个map，同时将end设置为false，因为他不是最后一个
                    Map<String, Object> newWorMap = new HashMap<>(4);
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == chars.length - 1) {
                    //最后一个
                    nowMap.put(END_MARK_KEY, true);
                }
            }
        }
        return wordsMap;
    }


    public static boolean contain(String words, HashMap map) {
        for (int i = 0; i < words.length(); i++) {
            int matchFlag = check(words, i, map);
            if (matchFlag > 0) {
                return true;
            }
        }
        return false;
    }


    public static Optional<String> first(String words, HashMap map) {
        for (int i = 0; i < words.length(); i++) {
            int length = check(words, i, map);
            if (length > 0) {
                return Optional.of(words.substring(i, i + length));
            }
        }
        return Optional.empty();
    }


    public static Set<String> all(String words, HashMap map) {
        Set<String> sensitiveWordList = new HashSet<>();

        for (int i = 0; i < words.length(); i++) {
            int length = check(words, i, map);
            if (length > 0) {
                sensitiveWordList.add(words.substring(i, i + length));
                i = i + length - 1;

            }
        }

        return sensitiveWordList;
    }

    /**
     * 检查文字中是否包含敏感字符
     *
     * @param words      文本
     * @param beginIndex 开始位置
     * @return 如果存在，则返回敏感词字符的长度，不存在返回0
     */
    public static int check(String words, int beginIndex, HashMap map) {
        boolean flag = false;
        int matchFlag = 0;
        Map nowMap = map;
        for (int i = beginIndex; i < words.length(); i++) {
            char word = words.charAt(i);
            nowMap = (Map) nowMap.get(word);
            if (nowMap == null) {
                break;
            }
            matchFlag++;
            flag = Boolean.TRUE.equals(nowMap.get(END_MARK_KEY));
        }
        return matchFlag >= MIN_MATCH_FLAG && flag ? matchFlag : 0;

    }
}


