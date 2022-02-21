package com.handlecoder.staticproxy;

/**
 * @author handlecoder
 * @date 2022/2/15 13:09
 */
public class TestCase {

    public static void main(String[] args) {
        System.out.println("法庭开庭");
        SeeChildSuit seeChildSuit = new Lawer(new Wanglihong());
        seeChildSuit.seeChild();
    }
}
