package com.guangbo.bayes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by gaoguangbo on 2017/5/26.
 */
public class Training {
    TrainingDataManager manager = new TrainingDataManager();
    public void train() {
        manager.getTraningClassifications();
    }

    public int getCountContainKeyOfClassification(String classification,String key)
    {
        int ret = 0;
        try
        {
            String[] filePath = manager.getFilesPath(classification);
            for (int j = 0; j < filePath.length; j++)
            {
                String text = manager.getText(filePath[j]);
                if (text.contains(key))
                {
                    ret++;
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(TrainingDataManager.class.getName()).log(Level.SEVERE, null,ex);

        }
        catch (IOException ex)
        {
            Logger.getLogger(TrainingDataManager.class.getName()).log(Level.SEVERE, null,ex);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
