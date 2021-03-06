package com.guangbo.bayes;

/**
 * Created by muyawei on 2017/5/19.
 *  先验概率是我们需要计算的两大概率值之一
 */

/**
 * 先验概率计算
 * <h3>先验概率计算</h3>
 * P(c<sub>j</sub>)=N(C=c<sub>j</sub>)<b>/</b>N <br>
 * 其中，N(C=c<sub>j</sub>)表示类别c<sub>j</sub>中的训练文本数量；
 * N表示训练文本集总数量。
 */
public class PriorProbability
{
    private static TrainingDataManager tdm =new TrainingDataManager();
    /**
     * 先验概率
     * @param c 给定的分类
     * @return 给定条件下的先验概率
     */
    public static double calculatePc(String c)
    {
        double ret = 0;
        double Nc = tdm.getTrainingFileCountOfClassification(c);
        double N = tdm.getTrainingFileCount();
        ret = Nc / N;
        return ret;
    }
}

