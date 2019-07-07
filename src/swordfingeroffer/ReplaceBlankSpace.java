package swordfingeroffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceBlankSpace {

    /**
     * 采用字符数组进行巧妙的替换
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        String s=str.toString();
        char[] ch=s.toCharArray();
        StringBuffer res=new StringBuffer();
        for(int i=0;i<ch.length;i++){
            if(ch[i]==' '){
                res.append("%20");
            }else{
                res.append(ch[i]);
            }
        }
        return res.toString();
    }
}
