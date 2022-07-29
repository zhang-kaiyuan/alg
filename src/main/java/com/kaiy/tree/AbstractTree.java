package com.kaiy.tree;

import com.kaiy.common.FunctionInterface;
import com.kaiy.common.SamplesToGenerate;
import com.kaiy.common.TreeUtil;

import java.util.Objects;

public class AbstractTree {

    private static final int TIME = 100000;

    public static void treeLogarithmic(FunctionInterface<TreeNode, Object> fun1, FunctionInterface<TreeNode, Object> fun2) {
        for (int i = 0; i < TIME; i++) {
            TreeNode treeNode = SamplesToGenerate.generateRandomTree();
            if (!Objects.equals(fun1.fun(treeNode), fun2.fun(treeNode))) {
                TreeUtil.printTree(treeNode);
                System.out.println("shit!");
            }
        }
        System.out.println("finish!");
    }

}
