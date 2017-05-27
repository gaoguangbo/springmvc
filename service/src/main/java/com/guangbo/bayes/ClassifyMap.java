package com.guangbo.bayes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaoguangbo on 2017/5/26.
 */
public class ClassifyMap {
    public static Map<String, Map<String, Integer>> classifyMap = new HashMap<String, Map<String, Integer>>();
    public static Map<String, Integer> classFileCount = new HashMap<String, Integer>();
    public static Map<String, Double> priorProbability = new HashMap<String, Double>();
    public static int fileCount = 0;
}
