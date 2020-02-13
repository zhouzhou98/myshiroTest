package com.fly;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class MD5Test {
    @Test
    public void testMD5()throws Exception{
        String password="666";
        //加密MD5
        Md5Hash md5Hash=new Md5Hash(password);
        //没有加盐：fae0b27c451c728867a567e8c1bb4e53
        System.out.println(md5Hash.toString());

        System.out.println("-----------------------");
        //加密md5：加盐:2f1f526e25fdefa341c7a302b47dd9df
        md5Hash=new Md5Hash(password,"zhangsan");
        System.out.println(md5Hash.toString());
        System.out.println("-----------------------");

        //加密md5：加盐：加上散列次数:cd757bae8bd31da92c6b14c235668091
        md5Hash=new Md5Hash(password,"zhangsan",3);
        System.out.println(md5Hash.toString());
    }
}
