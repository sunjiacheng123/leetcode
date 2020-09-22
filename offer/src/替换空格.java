public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        int len=str.length()-1;
        for(int i=0;i<=len;i++){
            if(str.charAt(i)==' '){
                str.append("  ");
            }
        }
        int len2=str.length()-1;
        while (len>=0 && len2>len){
            char ch=str.charAt(len--);
            if(ch==' '){
                str.setCharAt(len2--,'0');
                str.setCharAt(len2--,'2');
                str.setCharAt(len2--,'%');
            }else {
                str.setCharAt(len2--,ch);
            }
        }
        return str.toString();
    }
}
