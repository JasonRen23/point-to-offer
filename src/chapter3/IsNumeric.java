package chapter3;

/**
 * @author zhicheng
 * @create 2018-07-12 下午5:01
 */


public class IsNumeric {

    public static boolean isNumeric(String str){
        if(str == null || str.length() < 1)
            return false;

        //标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'e' || str.charAt(i) == 'E'){
                // e后面一定要接数字
                if(i == str.length() - 1) return false;
                // 不能同时存在两个e
                if(hasE) return false;
                hasE = true;
            }else if(str.charAt(i) == '+' || str.charAt(i) == '-'){
                //第二次出现+-符号，则必学紧接在e之后
                if(sign && str.charAt(i - 1) != 'e' && str.charAt(i - 1) != 'E') return false;
                //第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if(!sign && i > 0 && str.charAt(i - 1) != 'e' && str.charAt(i - 1) != 'E') return false;
                sign = true;
            }else if(str.charAt(i) == '.'){
                //e后面不能接小数点，小数点不能出现两次
                if(hasE || decimal) return false;
                decimal = true;
            }else if(str.charAt(i) < '0' || str.charAt(i) > '9')
                //不合法字符
                return false;

        }

        return true;
    }




    public static void main(String[] args) {
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("123.45e+6") + "[" + true + "]");
        System.out.println(isNumeric("+500") + "[" + true + "]");
        System.out.println(isNumeric("5e2") + "[" + true + "]");
        System.out.println(isNumeric("3.1416") + "[" + true + "]");
        System.out.println(isNumeric("600.") + "[" + true + "]");
        System.out.println(isNumeric("-.123") + "[" + true + "]");
        System.out.println(isNumeric("-1E-16") + "[" + true + "]");
        System.out.println(isNumeric("100") + "[" + true + "]");
        System.out.println(isNumeric("1.79769313486232E+308") + "[" + true + "]");
        System.out.println();
        System.out.println(isNumeric("12e") + "[" + false + "]");
        System.out.println(isNumeric("1a3.14") + "[" + false + "]");
        System.out.println(isNumeric("1+23") + "[" + false + "]");
        System.out.println(isNumeric("1.2.3") + "[" + false + "]");
        System.out.println(isNumeric("+-5") + "[" + false + "]");
        System.out.println(isNumeric("12e+5.4") + "[" + false + "]");
    }
}
