package com.guangbo.bayes;

/**
 * Created by muyawei on 2017/5/19.
 *       用来保存各个分类及其计算出的概率值，
 */

/**
 * 分类结果
 */
public class ClassifyResult
{
    public double probility;//分类的概率
    public String classification;//分类
    public ClassifyResult()
    {
        this.probility = 0;
        this.classification = null;
    }
}