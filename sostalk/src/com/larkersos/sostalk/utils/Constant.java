package com.larkersos.sostalk.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.larkersos.sostalk.R;

public class Constant {
	
	// 每隔10秒发送一个心跳包
	public static int UPDATE_SEPARATE_TIME = 1000*10;
	// 检测用户是否在线,如果超过15说明用户已离线，秒则从列表中清除该用户
	public static int CHECK_SEPARATE_TIME = 1000*5;
	// 离线超时时长 
	public static int OFF_LINE_TIME = 1000*15;
	
	/**
	 * 可支持传递的文件类型
	 */
	public static Map<String,Integer> exts = new HashMap<String,Integer>();
	  static{
		  exts.put("doc", R.drawable.doc);exts.put("docx", R.drawable.doc);exts.put("xls", R.drawable.xls);exts.put("xlsx", R.drawable.xls);exts.put("ppt", R.drawable.ppt);exts.put("pptx", R.drawable.ppt);
		  exts.put("jpg", R.drawable.image);exts.put("jpeg", R.drawable.image);exts.put("gif", R.drawable.image);exts.put("png", R.drawable.image);exts.put("ico", R.drawable.image);
		  exts.put("apk", R.drawable.apk);exts.put("jar", R.drawable.jar);exts.put("rar", R.drawable.rar);exts.put("zip", R.drawable.rar);
		  exts.put("mp3", R.drawable.music);exts.put("wma", R.drawable.music);exts.put("aac", R.drawable.music);exts.put("ac3", R.drawable.music);exts.put("ogg", R.drawable.music);exts.put("flac", R.drawable.music);exts.put("midi", R.drawable.music);
		  exts.put("pcm", R.drawable.music);exts.put("wav", R.drawable.music);exts.put("amr", R.drawable.music);exts.put("m4a", R.drawable.music);exts.put("ape", R.drawable.music);exts.put("mid", R.drawable.music);exts.put("mka", R.drawable.music);
		  exts.put("svx", R.drawable.music);exts.put("snd", R.drawable.music);exts.put("vqf", R.drawable.music);exts.put("aif", R.drawable.music);exts.put("voc", R.drawable.music);exts.put("cda", R.drawable.music);exts.put("mpc", R.drawable.music);
		  exts.put("mpeg", R.drawable.video);exts.put("mpg", R.drawable.video);exts.put("dat", R.drawable.video);exts.put("ra", R.drawable.video);exts.put("rm", R.drawable.video);exts.put("rmvb", R.drawable.video);exts.put("mp4", R.drawable.video);
		  exts.put("flv", R.drawable.video);exts.put("mov", R.drawable.video);exts.put("qt", R.drawable.video);exts.put("asf", R.drawable.video);exts.put("wmv", R.drawable.video);exts.put("avi", R.drawable.video);
		  exts.put("3gp", R.drawable.video);exts.put("mkv", R.drawable.video);exts.put("f4v", R.drawable.video);exts.put("m4v", R.drawable.video);exts.put("m4p", R.drawable.video);exts.put("m2v", R.drawable.video);exts.put("dat", R.drawable.video);
		  exts.put("xvid", R.drawable.video);exts.put("divx", R.drawable.video);exts.put("vob", R.drawable.video);exts.put("mpv", R.drawable.video);exts.put("mpeg4", R.drawable.video);exts.put("mpe", R.drawable.video);exts.put("mlv", R.drawable.video);
		  exts.put("ogm", R.drawable.video);exts.put("m2ts", R.drawable.video);exts.put("mts", R.drawable.video);exts.put("ask", R.drawable.video);exts.put("trp", R.drawable.video);exts.put("tp", R.drawable.video);exts.put("ts", R.drawable.video);
	  }
	
	//自定义Action
	public static final String updateMyInformationAction = "com.larkersos.sostalk.updateMyInformation";
	public static final String personHasChangedAction = "com.larkersos.sostalk.personHasChanged";
	public static final String hasMsgUpdatedAction = "com.larkersos.sostalk.hasMsgUpdated";
	public static final String receivedSendFileRequestAction = "com.larkersos.sostalk.receivedSendFileRequest";
	public static final String refuseReceiveFileAction = "com.larkersos.sostalk.refuseReceiveFile";
	public static final String remoteUserRefuseReceiveFileAction = "com.larkersos.sostalk.remoteUserRefuseReceiveFile";
	public static final String dataReceiveErrorAction = "com.larkersos.sostalk.dataReceiveError";
	public static final String dataSendErrorAction = "com.larkersos.sostalk.dataSendError";
	public static final String whoIsAliveAction = "com.larkersos.sostalk.whoIsAlive";//询问当前那个Activity是激活状态
	public static final String imAliveNow = "com.larkersos.sostalk.imAliveNow";
	public static final String remoteUserUnAliveAction = "com.larkersos.sostalk.remoteUserUnAlive";
	public static final String fileSendStateUpdateAction = "com.larkersos.sostalk.fileSendStateUpdate";
	public static final String fileReceiveStateUpdateAction = "com.larkersos.sostalk.fileReceiveStateUpdate";
	public static final String receivedTalkRequestAction = "com.larkersos.sostalk.receivedTalkRequest";
	public static final String acceptTalkRequestAction = "com.larkersos.sostalk.acceptTalkRequest";
	public static final String remoteUserClosedTalkAction = "com.larkersos.sostalk.remoteUserClosedTalk";
	
	//系统Action
	//System Action declare
	public static final String bootCompleted = "android.intent.action.BOOT_COMPLETED";
	public static final String WIFIACTION="android.net.conn.CONNECTIVITY_CHANGE";
	public static final String ETHACTION = "android.intent.action.ETH_STATE";
	
	/**
	 * 类型  : 局域网网络，蓝牙
	 * @author lark
	 *
	 */
	public static enum PERSON_TYPE{
		blueTooth,wlan
	};

	
	//other 其它定义，另外消息长度为60个汉字，utf-8中定义一个汉字占3个字节，所以消息长度为180bytes
	//文件长度为30个汉字，所以总长度为90个字节
	public static final int bufferSize = 256;
	public static final int msgLength = 180;
	public static final int fileNameLength = 90;
	//文件读写缓存
	public static final int readBufferSize = 4096;
	public static final byte[] pkgHead = "AND".getBytes();
	public static final int CMD80 = 80;
	public static final int CMD81 = 81;
	public static final int CMD82 = 82;
	public static final int CMD83 = 83;
	public static final int CMD_TYPE1 = 1;
	public static final int CMD_TYPE2 = 2;
	public static final int CMD_TYPE3 = 3;
	public static final int OPR_CMD1 = 1;
	public static final int OPR_CMD2 = 2;
	public static final int OPR_CMD3 = 3;
	public static final int OPR_CMD4 = 4;
	public static final int OPR_CMD5 = 5;
	public static final int OPR_CMD6 = 6;
	public static final int OPR_CMD10 = 10;
	
	// 端口信息
	// IANA保留地址 用于多点传送
	public static final String MULTICAST_IP = "239.9.9.1";
	public static final int PORT = 5760;
	public static final int AUDIO_PORT = 5761;
	
	
	//其它定义
	public static final int FILE_RESULT_CODE = 1;
	public static final int SELECT_FILES = 1;//是否要在文件选择器中显示文件
	public static final int SELECT_FILE_PATH = 2;//文件选择器只显示文件夹
	//文件选择状态保存
	public static TreeMap<Integer,Boolean> fileSelectedState = new TreeMap<Integer,Boolean>();
 	  
}
