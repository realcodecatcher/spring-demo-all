package com.handlecoder.staticproxy;

/**
 * @author handlecoder
 * @date 2022/2/15 13:04
 */
public class Lawer implements SeeChildSuit {

    SeeChildSuit seeChildSuit;

    public Lawer(SeeChildSuit seeChildSuit) {
        this.seeChildSuit = seeChildSuit;
    }
    @Override
    public void seeChild() {
        System.out.println("律师准备证据并陈述诉讼请求：");
        seeChildSuit.seeChild();
        System.out.println("律师进行法庭辩论");
    }
}
