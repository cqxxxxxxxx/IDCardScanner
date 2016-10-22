package cqxxxxxxxx;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;


public interface TestDll extends StdCallLibrary {
    String path = "D:\\ii\\Sdtapi";         //path of the .dll
    TestDll INSTANCE = (TestDll) Native.loadLibrary(path, TestDll.class);

    //卡认证接口
    int InitComm(int iPort);

    int CloseComm();

    int Authenticate();

    //读卡信息接口
    public int ReadBaseMsg(String pPPP, int len);
    public int ReadBaseMsgPhoto(byte[] pMsg, int len,byte[] directory);
    public int ReadBaseInfos(byte[] Name, byte[] Gender, byte[] Folk,
                             byte[] BirthDay, byte[] Code, byte[] Address,byte[] Agency, byte[] ExpireStart,byte[] ExpireEnd);
    public int ReadBaseInfosPhoto(byte[] Name,byte[] Gender,byte[] Folk,
                                  byte[] BirthDay,byte[] Code, byte[] Address,
                                  byte[] Agency, byte[] ExpireStart,
                                  byte[] ExpireEnd,byte[] directory);//此处使用了这个接口读取信息!注意只能用byte[],不能是char[];否则会乱码!转都转不了!
    public int ReadBaseMsgW(byte[] pMsg, int len);
    public int ReadBaseMsgWPhoto(byte[] pMsg, int[] len,byte[] directory);
    //读追加地址信息
    public int ReadNewAppMsg(byte[] pMsg, int num);
    public int ReadNewAppInfos(byte[] addr1,
                               byte[] addr2,byte[] addr3,
                               byte[] addr4,int num);
    public int ReadNewAppMsgW(byte[] pMsg, int[] num);
    //读卡体管理号
    public int ReadIINSNDN(byte[] pMsg);
    //读模块序列号
    public int GetSAMIDToStr(byte[] pcSAMID);

}
