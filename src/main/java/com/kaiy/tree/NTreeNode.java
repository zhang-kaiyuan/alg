package com.kaiy.tree;

import java.util.List;

public class NTreeNode {

    public int value;
    public List<NTreeNode> children;

    public NTreeNode(int value, List<NTreeNode> children) {
        this.value = value;
        this.children = children;

    }
}
