package model;

import java.lang.reflect.Array;
import java.util.Random;

public class Model {

    public boolean isCorrectLogin(String name,String password)
    {
        if(name.equals("user") && password.equals("user"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getRandomAnswer()
    {
        String[] eightBallAnswers = {"It is certain.","It is decidedly so.","Without a doubt.","Yes – definitely.","You may rely on it.","As I see it, yes.","Most likely.","Outlook good.","Yes.","Signs point to yes.","Reply hazy, try again.","Ask again later.","Better not tell you now.","Cannot predict now.","Concentrate and ask again.","Don’t count on it.","My reply is no.","My sources say no.","Outlook not so good.","Very doubtful."};
        Random r = new Random();
        int random = r.nextInt(eightBallAnswers.length);
        return eightBallAnswers[random];
    }
}