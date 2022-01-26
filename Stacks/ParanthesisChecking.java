import java.util.*;



class ParanthesisChecking
{
    static boolean isOpening(char o)
    {
        if(o=='('||o=='{'||o=='[')
        return true;
        
        else
        return false;
    }

    static boolean isMatching(char o, char c)
    {
        if(o=='('&&c==')' || o=='{'&&c=='}' || o=='['&&c==']')
        return true;
        
        else
        return false;
    }

    static boolean ispar(String x)
    {
        Stack<Character> par = new Stack<>();
        for(int i=0;i<x.length();i++)
        {
            char ch = x.charAt(i);

            if(isOpening(ch))
            par.add(ch);

            else
            {
                if(par.isEmpty())
                return false;

                else if(!isMatching(par.peek(), ch))
                {
                    return false;
                }
                else
                {
                    par.pop();
                }
            }
        }
            return par.isEmpty();


        
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String sen;
        System.out.println("Enter The String Of Brackets ==> ");
        sen = in.next();

        boolean flag = ispar(sen);

        if(flag==true)
        System.out.println("Balanced");

        else
        System.out.println("Unbalanced");
        
    }
}