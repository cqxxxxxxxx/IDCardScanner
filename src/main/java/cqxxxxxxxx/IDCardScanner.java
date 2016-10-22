package cqxxxxxxxx;

import java.io.UnsupportedEncodingException;


public class IDCardScanner {


    public static void main(String[] args) {
        int ret;
        int iPort = 1001;   //USB PORT

        ret = TestDll.INSTANCE.InitComm(iPort); //初始化端口
        if (ret != 1) {
            System.out.println("没有找到读卡器!");
        } else {
            System.out.println("读卡器连接成功!");
            ret = TestDll.INSTANCE.Authenticate();

            if (ret != 1) {
                System.out.println("读卡失败!");
            } else {
                System.out.println("读卡成功!");
                byte[] Name = new byte[31];
                byte[] Gender = new byte[3];
                byte[] Folk = new byte[10];
                byte[] BirthDay = new byte[9];
                byte[] Code = new byte[19];
                byte[] Address = new byte[71];
                byte[] Agency = new byte[31];
                byte[] ExpireStart = new byte[9];
                byte[] ExpireEnd = new byte[9];


                ret = TestDll.INSTANCE.ReadBaseInfos(Name, Gender, Folk, BirthDay, Code, Address, Agency, ExpireStart, ExpireEnd);
                if (ret > 0) {
                    System.out.println("信息读取成功!");
                    try {
                        System.out.println("-----------------------------------------------");
                        System.out.println("姓名" + new String(Name, "GBK"));
                        System.out.println("性别" + new String(Gender, "GBK"));
                        System.out.println("身份证号码" + new String(Code, "GBK"));
                        System.out.println("-----------------------------------------------");
                    } catch (UnsupportedEncodingException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        }
        ret = TestDll.INSTANCE.CloseComm();
        if (ret != 1) {
            System.out.println("读卡器关闭连接错误!");
        } else {
            System.out.println("读卡器关闭连接成功!");
        }
    }

}
