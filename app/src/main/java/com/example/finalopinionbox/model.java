package com.example.finalopinionbox;

public class model
{
    String postText, op1, op2;
    //String username;

    model()
    {}

    public model(String postText, String op1, String op2) {
        // ,String username
        this.postText = postText;
        this.op1 = op1;
        this.op2 = op2;
        //this.username = username;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

   /* public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }  */
}

